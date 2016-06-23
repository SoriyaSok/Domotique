package com.company.domotique.appareils;

import java.util.Collection;
import java.util.Vector;

/** Bordereau est une classe qui hérite de Vector. 
 * Bordereau contient les appareils de la maison.
 * @author soriyaValentin
 *@version 1.0
 */
public class Bordereau extends Vector<AppareilElectrique> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9024068173244951065L;

	/**
	 * constructeur de Bordereau 
	 */
	public Bordereau() {
		super();
	}

	public Bordereau(Collection<? extends AppareilElectrique> c) {
		super(c);
	}

	public Bordereau(int initialCapacity, int capacityIncrement) {
		super(initialCapacity, capacityIncrement);
	}

	public Bordereau(int initialCapacity) {
		super(initialCapacity);
	}

	public void trierCroissant(){
		SortByCroissant comparateur = new SortByCroissant();
		this.sort(comparateur);
	}
	
	public void trierDecroissant(){
		SortByDecroissant comparateur = new SortByDecroissant();
		this.sort(comparateur);
	}
	
	/**
	 * la méthode afficher sera utilisée dans la méthode toString.
	 * @param i l'indice d'un élement du Bordereau
	 * @return res, qui récupère les informations de l'élement i du Bordereau (ce sont des objets AppareilElectrique), 
	 * la méthode toString de la superclasse Appareilelectrique permet de récuperer la chaine de caracteres de cet élement.
	 */
	private String afficher(int i) {
		String res;
		res = this.get(i).toString();
		return res;
	}
	
	@Override
	public String toString() {
		String res = ""; 
		
		for (int i = 0; i < this.size(); i++) {
			res += afficher(i)+"\n";
		}
		return res;
	}
	
}