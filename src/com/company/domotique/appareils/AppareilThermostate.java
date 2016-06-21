package com.company.domotique.appareils;


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

	public void incrementeThermostat() {
		if (valeurThermostat < valeurThermostatMax) {
			valeurThermostat += 1;
		}
	}

	public int getConsommation() {
		puissanceInstantanee = 0;
		if (isEnMarche) {
			puissanceInstantanee = valeurThermostat*incPuissance; 
		} else {
			System.out.println("l'appareil n'est pas allumé");
			puissanceInstantanee = 0;
		}
		return puissanceInstantanee = 0;
	}//getConsommation

	@Override
	public String toString() {
		return "AppareilThermostate [puissanceInstantanee=" + puissanceInstantanee + ", incPuissance=" + incPuissance
				+ ", valeurThermostat=" + valeurThermostat + ", getPuissance()=" + getPuissance() + ", getMarque()="
				+ getMarque() + ", getModele()=" + getModele() + "]";
	}
	
	
}
