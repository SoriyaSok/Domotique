package com.company.domotique.appareils;



public abstract class Appareil {

	private String marque;
	private String modele;

	public Appareil(String p_MarqueAppareil,String p_Modele){
		marque= p_MarqueAppareil;
		modele= p_Modele;

	}// constructeur
	public String getMarque() {
		return marque;
	} // get
	public void setMarque(String pMa) {
		marque =pMa;
	} // set
	public String getModele() {
		return modele;
	} // get
	public void setModele(String pModele) {
		modele = pModele;
	} // set
	@Override
	public String toString() {
		return "Appareil [marque=" + marque + ", modele=" + modele + "]";
	}

	
}
