package com.company.domotique.application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.domotique.appareils.AppareilElectrique;
import com.company.domotique.appareils.AppareilThermostate;
import com.company.domotique.exceptions.CompteurADisjoncteException;
import com.company.domotique.ihm.CadreGeneral;
import com.company.domotique.maison.Compteur;

public class Lanceur {
	
		public static void main(String [] args){
		
	
		
//		System.out.println("Bonjour");
//		AppareilElectrique ordinateur= new AppareilElectrique("DELL","GX100",500);
//		AppareilElectrique ordinateur1= new AppareilElectrique("DELL","GX100",500);
//		AppareilElectrique ordinateur2= new AppareilElectrique("DELL","GX100",500);
//		AppareilThermostate chauffage= new AppareilThermostate("Philips","mod123",1000,20,50);
//		System.out.println(ordinateur);
//		System.out.println(chauffage);
//		System.out.println("===================================================");
//
//
////		// affichage de l'objet chauffage (methode toString appelee par defaut)
////		//Verification de l'instanciation
////	
////		System.out.println(ordinateur);
////		System.out.println(chauffage);
////
////	
////		
////		//Mise en marche chauffage, reglage thermostat
////		chauffage.demarrer();
////		chauffage.setValeurThermostat(7);
////		
////		System.out.println("Chauffage en marche? :" + chauffage.isEnMarche() 
////						+ ", Thermostat : " + chauffage.getValeurThermostat());
////		
////		
////		//Tentative d'incrementation du thermostat superieure � son thermostat maxi (50)
////		for (int i=0; i<53; i++) {
////			chauffage.incrementeThermostat();
////		}
////		
////		System.out.println("Chauffage en marche? :" + chauffage.isEnMarche() 
////		+ ", Thermostat : " + chauffage.getValeurThermostat());
////
////		// mise en marche de l'ordinateur
////		ordinateur.demarrer();
////
////		//etc...................................
//		
//		Compteur monCompteur = new Compteur(1000);
//		
//		monCompteur.demarrer();
//		
//		monCompteur.brancher(chauffage);
//		chauffage.demarrer();
//		chauffage.setValeurThermostat(10, monCompteur);
//		
//		monCompteur.brancher(ordinateur);
//		ordinateur.demarrer();
//		
//		monCompteur.brancher(ordinateur1);
//		ordinateur1.demarrer();
//		
//		monCompteur.brancher(ordinateur2);
//		ordinateur2.demarrer();
//
//	System.out.println("Au revoir!");
				
			
//			ArrayList alAppElec = new ArrayList();
//			ArrayList alAppThermos = new ArrayList();
//			

			AppareilElectrique unOrdinateur1 = new AppareilElectrique("DELL","GX100",500);
			AppareilElectrique unOrdinateur2 = new AppareilElectrique("DELL","GX100",500);
			AppareilElectrique unOrdinateur3 = new AppareilElectrique("DELL","GX100",500);
			AppareilThermostate unMicroOnde = new AppareilThermostate("Philips","mod123",250, 25, 10);
			Compteur unCompteurEDF = new Compteur(550);
		
			unCompteurEDF.setMarque("Boubou2000");

//			try {
//				unCompteurEDF.demarrer();
//				unCompteurEDF.brancher(unOrdinateur1, unCompteurEDF);
//				unOrdinateur1.demarrer(unCompteurEDF);
//				unCompteurEDF.brancher(unOrdinateur2, unCompteurEDF);
//				unOrdinateur2.demarrer(unCompteurEDF);
//				unCompteurEDF.brancher(unOrdinateur3, unCompteurEDF);
//				unOrdinateur3.demarrer(unCompteurEDF);
//			} catch (CompteurADisjoncteException e) {
//				System.out.println("le compteur : " + e.getCompteurEnCause().getMarque() 
//						+ " a disjoncté pour la puissance " + e.getPuissanceDemandee());
//			}
			
			
			try {
				unCompteurEDF.brancher(unMicroOnde, unCompteurEDF);
				unCompteurEDF.brancher(unOrdinateur1, unCompteurEDF);
			} catch (CompteurADisjoncteException e) {
				System.out.println("le compteur : " + e.getCompteurEnCause().getMarque() 
						+ " a disjoncté pour la puissance " + e.getPuissanceDemandee());
			}
			
			//-------------- JDBC --------------------------//
			Connection connexion=null;
			try{
				// 1) charger dynamiquement la classe du pilote
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				// 2) fournir le nom de la source de donnees
				String sPseudoURL = "jdbc:odbc:DSNDomotique";
				// 3)Etablir la connexion  
				connexion=DriverManager.getConnection(sPseudoURL);
			} catch (ClassNotFoundException e){
				System.out.println("Pilote non trouv�");
				System.exit(1);
			} catch(SQLException e){
				System.out.println("Erreur :"+e+" sur ");
				System.exit(1);
			}//catch
			
			try{
				Statement laRequete = connexion.createStatement();
				ResultSet leResultat = laRequete.executeQuery("select * from APPAREIL_ELECTRIQUE_TBL");
				
				// on peut fournir un tableau String[] lesTypes={ "TABLE" }; 
				// en fait on veut tout, d'o� le null ci-dessous
				
				//------ Boucle sur les tables ------
				while (leResultat.next()){
					int columns = leResultat.getMetaData().getColumnCount();
					String ligne = "";
					for (int i = 1; i <= columns; i++) {
						ligne += leResultat.getString(i) + " | ";
					}
					System.out.println(ligne);
					
					
//					System.out.println("R�pertoire - Schema - Nom - Type de Table -");
//					System.out.print(rsTables.getString("TABLE_CAT")+" - ");
//					System.out.print(rsTables.getString("TABLE_SCHEM")+" - ");
//					String sTable=rsTables.getString("TABLE_NAME");
//					System.out.print(sTable+" - ");
//					System.out.println(rsTables.getString("TABLE_TYPE"));
//					System.out.println("--------------------------------------------");
//					//--------- Boucle sur les champs de la table
//					ResultSet rsColonnes=dbmd.getColumns(null,null,sTable,null);
//					System.out.println("Nom - Type - Sous Type - Taille de colonne");
//						while (rsColonnes.next()){
//							System.out.print(rsColonnes.getString("COLUMN_NAME")+" - ");
//							System.out.print(rsColonnes.getShort("DATA_TYPE")+" - ");
//							String sType=rsColonnes.getString("TYPE_NAME");
//							System.out.print(sType+" - ");
//							if ( sType.equals("CHAR")){
//								System.out.println(rsColonnes.getInt("CHAR_OCTET_LENGTH")+" - ");
//							}
//							else {
//								System.out.println(rsColonnes.getInt("COLUMN_SIZE")+" - ");
//							}
//						}//while les colonnes
//						rsColonnes.close();
//						System.out.println("----------------------------------------");
				}//while les tables
				leResultat.close();
			}
			catch(SQLException e){
							System.out.println("Erreur :"+e+" sur ");
							System.exit(1);
			}//catch
			
			CadreGeneral monInterface = new CadreGeneral(unOrdinateur1, unMicroOnde, unCompteurEDF);	
	}

}
