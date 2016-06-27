import java.sql.*;
/**
 Exemple d'accès aux Meta Data JDBC
 Lancement par DumpTable nomDuDSN
*/
class DumpTable {

	public static void main(String[] args){
		if (args.length==0){
			System.out.println("lancer avec DumpTable nomDSN ");
			System.exit(1);
		}
		Connection con=null;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:"+args[0]);
		} catch (ClassNotFoundException e){
			System.out.println("Pilote non trouvé");
			System.exit(1);
		} catch(SQLException e){
			System.out.println("Erreur :"+e+" sur "+args[0]);
			System.exit(1);
		}//catch

		try{
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Produit : "+dbmd.getDatabaseProductName());
			System.out.println("Version : "+dbmd.getDatabaseProductVersion());
			System.out.println("Driver  : "+dbmd.getDriverName());

			// on peut fournir un tableau String[] lesTypes={ "TABLE" }; 
			// en fait on veut tout, d'où le null ci-dessous
			ResultSet rsTables=dbmd.getTables(null,null,null,null);
			//------ Boucle sur les tables ------
			while (rsTables.next()){
				System.out.println("Répertoire - Schema - Nom - Type de Table -");
				System.out.print(rsTables.getString("TABLE_CAT")+" - ");
				System.out.print(rsTables.getString("TABLE_SCHEM")+" - ");
				String sTable=rsTables.getString("TABLE_NAME");
				System.out.print(sTable+" - ");
				System.out.println(rsTables.getString("TABLE_TYPE"));
				System.out.println("--------------------------------------------");
				//--------- Boucle sur les champs de la table
				ResultSet rsColonnes=dbmd.getColumns(null,null,sTable,null);
				System.out.println("Nom - Type - Sous Type - Taille de colonne");
					while (rsColonnes.next()){
						System.out.print(rsColonnes.getString("COLUMN_NAME")+" - ");
						System.out.print(rsColonnes.getShort("DATA_TYPE")+" - ");
						String sType=rsColonnes.getString("TYPE_NAME");
						System.out.print(sType+" - ");
						if ( sType.equals("CHAR")){
							System.out.println(rsColonnes.getInt("CHAR_OCTET_LENGTH")+" - ");
						}
						else {
							System.out.println(rsColonnes.getInt("COLUMN_SIZE")+" - ");
						}
					}//while les colonnes
					rsColonnes.close();
					System.out.println("----------------------------------------");
			}//while les tables
			rsTables.close();
		}
		catch(SQLException e){
						System.out.println("Erreur :"+e+" sur "+args[0]);
						System.exit(1);
		}//catch
	}//main
}//DumpTable