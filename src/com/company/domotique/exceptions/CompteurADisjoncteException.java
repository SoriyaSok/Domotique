package com.company.domotique.exceptions;

import com.company.domotique.maison.Compteur;

public class CompteurADisjoncteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -308051075251173922L;
	
	private Compteur compteurEnCause;
	private int puissanceDemandee;
	
	public CompteurADisjoncteException(Compteur p_CompteurEnCause, int p_PuissanceDemandee) {
		this.compteurEnCause = p_CompteurEnCause;
		this.puissanceDemandee = p_PuissanceDemandee;
	}

	public Compteur getCompteurEnCause() {
		return compteurEnCause;
	}

	public int getPuissanceDemandee() {
		return puissanceDemandee;
	}
	
}
