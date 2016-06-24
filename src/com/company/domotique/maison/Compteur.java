package com.company.domotique.maison;

import java.util.Enumeration;
import java.util.Vector;

import com.company.domotique.appareils.AppareilElectrique;
import com.company.domotique.inter.ConsommateurDeCourant;
import com.company.domotique.inter.ProducteurDeCourant;
/**
 * la classe Compteur hérite de la classe AppareilElectrique et implemente l'interface Producteur de Courant
 * @author soriyaValentin
 *@version 1.0
 */
public class Compteur extends AppareilElectrique implements ProducteurDeCourant {

	private Vector<ConsommateurDeCourant> mesAppareilsBranches = new Vector<ConsommateurDeCourant>(10);
	private int puissanceInstantanee = 0;
	private boolean securite = false;

	/**
	 * constructeur vide de Compteur
	 */
	public Compteur() {
		super();
	}
	
	/**
	 * constructeur de Compteur 
	 * @param p_Puissance le parametre d'entrée la puissance maximale supportée par ce compteur.
	 */
	public Compteur(int p_Puissance) {
		super();
		this.iPuissance = p_Puissance;
	}


/**
 * 
 */
	public void calculerConsommation(){
		puissanceInstantanee = 0;
		//		for (int i = 0; i < this.size(); i++) {
		//			puissanceInstantanee += this.get(i).getConsommation();
		//		}
		Enumeration<ConsommateurDeCourant> enumerationCompteur = this.mesAppareilsBranches.elements();
		while (enumerationCompteur.hasMoreElements()) {
			ConsommateurDeCourant consommateurDeCourant = enumerationCompteur.nextElement();
			puissanceInstantanee += consommateurDeCourant.getConsommation();	
		}
		if (puissanceInstantanee >= iPuissance) {
			disjoncter();
		}
	}

	@Override
	public int getConsommation() {
		calculerConsommation();
		return puissanceInstantanee;
	}
	
	public void disjoncter() {
		setSecurite(true);
		Enumeration<ConsommateurDeCourant> enumerationCompteur = this.mesAppareilsBranches.elements();
		while (enumerationCompteur.hasMoreElements()) {
			ConsommateurDeCourant consommateurDeCourant = enumerationCompteur.nextElement();
			((AppareilElectrique) consommateurDeCourant).arreter();
		}
		calculerConsommation();
		this.arreter();
	}

	/**
	 * cette méthode brancher() est héritée de la classe AppareilElectrique.
	 * @param parametre d'entrée est une interface ConsommateurDeCourant cc
	 * dans le vecteur mesAppareilsBranches, on ajoute l'element ConsommateurDeCourant cc
	 * puis on effectue la methode calculerConsommation() 
	 */
	@Override
	public void brancher(ConsommateurDeCourant cc) {
		this.mesAppareilsBranches.addElement(cc);
		calculerConsommation();
	}

	/**
	 met l'appareil en marche
	 */
	
	public void demarrer() {
		calculerConsommation();
		if (puissanceInstantanee <= iPuissance) {
			isEnMarche=true;
			setSecurite(false);
		}
	}//demarrer

	public boolean isSecurite() {
		return securite;
	}

	public void setSecurite(boolean securite) {
		this.securite = securite;
	}

}
