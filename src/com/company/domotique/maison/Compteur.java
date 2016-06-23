package com.company.domotique.maison;

import java.util.Enumeration;
import java.util.Vector;

import com.company.domotique.appareils.AppareilElectrique;
import com.company.domotique.inter.ConsommateurDeCourant;
import com.company.domotique.inter.ProducteurDeCourant;

public class Compteur extends AppareilElectrique implements ProducteurDeCourant {

	private Vector<ConsommateurDeCourant> mesAppareilsBranches = new Vector<ConsommateurDeCourant>(10);
	private int puissanceInstantanee = 0;
	private boolean securite = false;

	public Compteur() {
		super();
	}
	
	public Compteur(int p_Puissance) {
		super();
		this.iPuissance = p_Puissance;
	}



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
