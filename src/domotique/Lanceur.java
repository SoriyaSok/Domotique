package domotique;

public class Lanceur {
	
		public static void main(String [] args){
		
		System.out.println("Bonjour");
		AppareilElectrique ordinateur= new AppareilElectrique("DELL","GX100",500);
		AppareilThermostate chauffage= new AppareilThermostate("Philips","mod123",1000,20,50);
		System.out.println(ordinateur);
		System.out.println(chauffage);


		// affichage de l'objet chauffage (methode toString appelee par defaut)
		//Verification de l'instanciation
		System.out.println("111111111111111111111111111111111");
		System.out.println(ordinateur);
		System.out.println(chauffage);

	
		
		//Mise en marche chauffage, reglage thermostat
		chauffage.demarrer();
		chauffage.setValeurThermostat(7);
		
		System.out.println("Chauffage en marche? :" + chauffage.isEnMarche() 
						+ ", Thermostat : " + chauffage.getValeurThermostat());
		
		
		//Tentative d'incrementation du thermostat superieure � son thermostat maxi (50)
		for (int i=0; i<53; i++) {
			chauffage.incrementeThermostat();
		}
		
		System.out.println("Chauffage en marche? :" + chauffage.isEnMarche() 
		+ ", Thermostat : " + chauffage.getValeurThermostat());

		// mise en marche de l'ordinateur
		ordinateur.demarrer();

		//etc...................................


	System.out.println("Au revoir!");
				
	}

}
