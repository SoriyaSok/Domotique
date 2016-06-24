package com.company.domotique.inter;

import com.company.domotique.exceptions.CompteurADisjoncteException;
import com.company.domotique.maison.Compteur;

public interface ProducteurDeCourant {
	
	abstract void brancher(ConsommateurDeCourant cc, Compteur compteur) throws CompteurADisjoncteException;
	
}
