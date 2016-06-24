package com.company.domotique.ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.company.domotique.exceptions.CompteurADisjoncteException;
import com.company.domotique.maison.Compteur;



public class PanneauCompteur
		extends JPanel {

	private static final long serialVersionUID = 8662093324834463792L;

	private Compteur compteur;

	public Compteur getCompteur() {
		return compteur;
	}

	private JLabel  lblPresentation;
	private JLabel  lblConso;
	private JLabel lblHorloge;

	//Reference sur les panneaux des appareils
	//recuperees grace a la methode abonnement de cette classe
	private PanneauAppareil panoE;
	private PanneauThermostat panoT;

	/*
	 * Construit graphiquement un nouveau panneau de commande
	 */
	public PanneauCompteur(Compteur pCompteur){

		//Recuperation du compteur
		compteur = pCompteur;
		
		//Creation du Horloge
		Horloge monHorloge = new Horloge();
		
		//Construction de l IHM
		setBackground(new Color(40,40,40));

		//Label puissance max
		lblPresentation = new JLabel("Puissance Max :" + compteur.getPuissance());
		lblPresentation.setForeground(Color.black);
		lblPresentation.setOpaque(true);
		add(lblPresentation);
		
		
		// Affichage de la consommation
		lblConso=new JLabel("    ");
		lblConso.setPreferredSize(new Dimension(100,30));
		lblConso.setForeground(Color.black);
		lblConso.setOpaque(true);
		add(lblConso);
		
		//affichage de l'heure
		lblHorloge = monHorloge.labCpt;
		lblHorloge.setForeground(Color.black);
		lblHorloge.setOpaque(true);
		add(lblHorloge);
	}
	
	public void majConso() throws CompteurADisjoncteException {
		int iNrj = compteur.getConsommation();
		
		//Test s'il y a eu disjonctage ou non
		if (iNrj != -1) {
			lblConso.setText(Integer.toString(compteur.getConsommation()));
		} 
		else {
			panoE.initPano();
			lblConso.setText("0");
			panoT.initPano();
			lblConso.setText("0");
		}				
	}

	//recupere les references sur les pano appareils en cas de disjonctage
	public void abonnement(PanneauAppareil pPanoE, PanneauThermostat pPanoT) {
		panoE = pPanoE;
		panoT = pPanoT; 
	}

}//class PanneauCompteur