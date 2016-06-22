package com.company.domotique.appareils;

/**
 * AppareilThermostate est une classe d'appareilElectrique qui dispose de méthode lié à la présence d'un thermostat
 * 
 * @author Soriya & Valentin
 * @version 1.0
 *
 */
public class AppareilThermostate extends AppareilElectrique {

	
	private int puissanceInstantanee = 0;
	private int incPuissance = 20;
	private int valeurThermostat = 0;
	private static int valeurThermostatMax = 20;

	public AppareilThermostate(String p_Marque, String p_Modele, int p_Puissance,
			int p_incPuissance, int p_valeurThermostatMax) {
		super(p_Marque, p_Modele, p_Puissance);
		this.incPuissance = p_incPuissance;
		valeurThermostatMax = p_valeurThermostatMax;
	}

	public int getValeurThermostat() {
		return valeurThermostat;
	}

	public void setValeurThermostat(int p_nouvelleValeurThermostat) {
		this.valeurThermostat = p_nouvelleValeurThermostat;
	}

	/**
	 * cette méthode incrementeThermostat() vérifie si la valeur du thermostat n'est pas à sa valeur maximale.
	 * si elle ne l'est pas, elle incrémente sa valeur de +1.
	 * il n'y a pas de paramètre d'entrée et cette méthode ne retourne rien (void).
	 */
	public void incrementerThermostat() {
		if (valeurThermostat < valeurThermostatMax) {
			valeurThermostat += 1;
		}
	}

	private void calculConsommation () {
		if (isEnMarche) {
			puissanceInstantanee = valeurThermostat*incPuissance; 
		} else {
			System.out.println("l'appareil n'est pas allumé");
			puissanceInstantanee = 0;
		} 
	}
	
	public int getConsommation() {
		calculConsommation();
		return puissanceInstantanee;
	}

	@Override
	public String toString() {
		return "AppareilThermostate [puissanceInstantanee=" + puissanceInstantanee + ", incPuissance=" + incPuissance
				+ ", valeurThermostat=" + valeurThermostat + ", getPuissance()=" + getPuissance() + ", getMarque()="
				+ getMarque() + ", getModele()=" + getModele() + "]";
	}
	
	
}
