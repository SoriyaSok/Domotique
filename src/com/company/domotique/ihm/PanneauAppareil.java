package com.company.domotique.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.company.domotique.appareils.AppareilElectrique;
import com.company.domotique.exceptions.CompteurADisjoncteException;



public class PanneauAppareil extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -994447719145693175L;
	protected AppareilElectrique appareil;
	private JLabel  lblPresentation = new JLabel();
	protected JButton btnDemarrer = new JButton();
	protected JButton btnArreter = new JButton();
	protected JPanel onOff=new JPanel();
	protected PanneauCompteur lePanoCompteur;

	/*
	 * Construit graphiquement un nouveau panneau de commande
	 */
	public PanneauAppareil(AppareilElectrique pAppareil, PanneauCompteur pPanoC){
		super(new FlowLayout(FlowLayout.LEFT));
		// On note l'appareil reli�
		appareil=pAppareil;
		lePanoCompteur = pPanoC;

		// On poursuit la mise en page
		setPreferredSize(new Dimension(500,40));
		setBackground(new Color(210,210,210));
		setForeground(Color.black);
		// On prend marque et mod�le comme affichage
		lblPresentation=new JLabel( appareil.getMarque()+" "
												 +appareil.getModele());
		lblPresentation.setPreferredSize(new Dimension(150,30));
		add(lblPresentation);

		btnDemarrer = new JButton("Démarrer");
		// On d�clare cette classe comme �coutant les �v�nements du bouton
		btnDemarrer.addActionListener(this);
		btnDemarrer.setEnabled(true);
		add(btnDemarrer);

		onOff.setBackground(Color.red);
		add(onOff);

		btnArreter = new JButton("Arrêter");
		btnArreter.setOpaque(true);
		btnArreter.addActionListener(this);
		btnArreter.setEnabled(false);
		add(btnArreter);
	}


	/*
	 * On intercepte les evenements produits par l utilisateur
	 */
	public void actionPerformed(ActionEvent evt) {

		Object src = evt.getSource();

		if(src == btnDemarrer){
			try {
				appareil.demarrer(lePanoCompteur.getCompteur());
			} catch (CompteurADisjoncteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			btnDemarrer.setEnabled(false);
			btnArreter.setEnabled(true);
			onOff.setBackground(Color.green);
			try {
				lePanoCompteur.majConso();
			} catch (CompteurADisjoncteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}//btnDemarrer
		else if (src == btnArreter){
			try {
				appareil.arreter(lePanoCompteur.getCompteur());
			} catch (CompteurADisjoncteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			btnDemarrer.setEnabled(true);
			btnArreter.setEnabled(false);
			onOff.setBackground(Color.red);
			try {
				lePanoCompteur.majConso();
			} catch (CompteurADisjoncteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//btnArreter
	}//actionPerformed(ActionEvent evt)

	//En cas de disjonctage, permet d initialiser les elements du pano
	public void initPano() {
			btnDemarrer.setEnabled(true);
			btnArreter.setEnabled(false);
			onOff.setBackground(Color.red);	
}

}//PanneauAppareil