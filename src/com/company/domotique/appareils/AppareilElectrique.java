package com.company.domotique.appareils;


public class AppareilElectrique extends Appareil {

	protected int iPuissance=0;
	protected boolean isEnMarche=false;
	
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
    public void demarrer() {
	   isEnMarche=true;
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
		return "Marque : " + super.getMarque() + ", Modele : " + super.getModele() + 
				", Puissance = " + iPuissance;
	}

	
	
}
