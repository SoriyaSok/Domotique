package com.company.domotique.ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.company.domotique.maison.Compteur;



public class PanneauCompteur
		extends JPanel {
			
		//implements ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8662093324834463792L;

	private Compteur compteur;

	private JLabel  lblPresentation;
	private JLabel  lblConso;
	private JButton btnConso;

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

	}

	public void majConso() {
		int iNrj = compteur.getConsommation();
		
		//Test s'il y a eu disjonctage ou non
		if (iNrj != -1) {
			lblConso.setText("" + compteur.getConsommation());
		} 
		else {
			lblConso.setText("tutu");
			panoE.initPano();
			panoT.initPano();
		}				
	}

	//recupere les references sur les pano appareils en cas de disjonctage
	public void abonnement(PanneauAppareil pPanoE, PanneauThermostat pPanoT) {
		panoE = pPanoE;
		panoT = pPanoT; 
	}

}//class PanneauCompteur