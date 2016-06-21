package domotique;

public class AppareilElectrique extends Appareil {

	protected int iPuissance=0;
	protected boolean isEnMarche=false;


	//Constructeur
	public AppareilElectrique(String p_Marque,String p_Modele, int p_Puissance){
		super(p_Marque, p_Modele);
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
	public boolean getIsEnMarche() {
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

}
