package com.company.domotique.inter;

import com.company.domotique.exceptions.CompteurADisjoncteException;

public interface ConsommateurDeCourant {
	
	abstract int getConsommation() throws CompteurADisjoncteException;
	
}
