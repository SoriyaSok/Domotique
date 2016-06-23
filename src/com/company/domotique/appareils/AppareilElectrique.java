package com.company.domotique.appareils;

import com.company.domotique.inter.ConsommateurDeCourant;
import com.company.domotique.maison.Compteur;

public class AppareilElectrique extends Appareil implements ConsommateurDeCourant {

	protected int iPuissance = 0;
	protected boolean isEnMarche = false;

	

	public AppareilElectrique() {
		super();
	}

	//Constructeur
	public AppareilElectrique(String p_MarqueAppareilElectrique,String p_Modele, int p_Puissance){
		super(p_MarqueAppareilElectrique, p_Modele);
		iPuissance=p_Puissance;
		isEnMarche=false;
	}// constructeur



	public void setPuissance(int pPuissance) {
		iPuissance = pPuissance;
	} // set
	
	
	public int getPuissance() {
		return iPuissance;
	} // get


	public void setIsEnMarche(boolean pOnOff) {
			isEnMarche = pOnOff ;
	} // set
	public boolean isEnMarche() {
			return isEnMarche;
	} // get


	/**
		 met l'appareil en marche
	*/
    public void demarrer(Compteur compteur) {
    	if (compteur.isEnMarche) {
    		isEnMarche = true;
		}
    	compteur.calculerConsommation();
    }//demarrer

   /**
    arrete l'appareil
   */
   public void arreter() {
   	      isEnMarche=false;
   }//arreter

	/**
	  retourne la consommation de l'appareil
	*/
	public int  getConsommation(){
		  if (isEnMarche)
		  		return iPuissance;
		  else
		  		return 0;
	}//getConsommation



	@Override
	public String toString() {
		return "AppareilElectrique [Puissance =" + iPuissance + ", EnMarche =" + isEnMarche + ", Modèle ="
				+ super.getModele() + " Marque ="+super.getMarque()+"]";
	}

	
	
}
