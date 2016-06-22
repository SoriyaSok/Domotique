package com.company.domotique.appareils;

/**
 * 
 * @author soriyaValentin
 * @version 1.0
 */
public class AppareilSecurise extends AppareilThermostate {
	
	/**
	 * attribut isSecuriteEnclenchee est initialisée à true (pour la sécurité de l'utilisateur)
	 */
	private boolean isSecuriteEnclenchee = true;
	
	/**
	 * constructeur vide d'AppareilSecurise 
	 */
	public AppareilSecurise() {
		super();
	}

	/**
	 * constructeur d'AppareilSecurise qui prend comme parametres d'entree :
	 * @param p_Marque la marque de l'appareil
	 * @param p_Modele le modele de l'appareil
	 * @param p_Puissance la puissance de l'appareil
	 * @param p_incPuissance l'increment de puissance de l'appareil
	 * @param p_valeurThermostatMax la valeur maximale du thermostat
	 */
	public AppareilSecurise(String p_Marque, String p_Modele, int p_Puissance, int p_incPuissance,
			int p_valeurThermostatMax) {
		super(p_Marque, p_Modele, p_Puissance, p_incPuissance, p_valeurThermostatMax);
	}
	
	/**
	 * methode desenclencheSecurite() assigne false au booleen isSecuriteEnclenchee
	 */
	public void desenclencheSecurite() {
		isSecuriteEnclenchee = false;
	}
	
	/**
	 * methode enclencheSecurite() assigne false au booleen isSecuriteEnclenchee
	 */
	public void enclencheSecurite() {
		isSecuriteEnclenchee = true;
	}
	
	/**
	 * méthode demarrer() est héritée de Appareilelectrique. Cette méthode vérifie si la sécurité est enclenchée ou non.
	 * Si la sécurité n'est pas enclenchée, l'appareil peut démarrer.
	 */
	@Override
	public void demarrer() {
		if (!isSecuriteEnclenchee) {
			super.demarrer();
		}
	}

	/**
	 * méthode toString() est héritée de AppareilThermostate, avec en plus l'affichage de l'état isSecuriteEnclenchee
	 */
	@Override
	public String toString() {
		return super.toString() + "\nsécurité : " + isSecuriteEnclenchee;
	}
	
}
