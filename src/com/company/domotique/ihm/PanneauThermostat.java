package com.company.domotique.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.company.domotique.appareils.AppareilThermostate;
import com.company.domotique.exceptions.CompteurADisjoncteException;


public class PanneauThermostat extends PanneauAppareil implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2447031170194271256L;
	private JLabel lblThermostat = new JLabel();
	private JButton btnAugmenterThermostat = new JButton();
	private JButton btnDiminuerThermostat = new JButton();

	private int thermostatCourant;

	public PanneauThermostat(AppareilThermostate pAppThermo, PanneauCompteur pPanoC){
		super(pAppThermo, pPanoC);

		btnDiminuerThermostat.setText("-");
		btnDiminuerThermostat.addActionListener(this);
		btnDiminuerThermostat.setEnabled(true);
		add(btnDiminuerThermostat);

		add(lblThermostat);
		afficherThermostat();

		btnAugmenterThermostat.setText("+");
		btnAugmenterThermostat.addActionListener(this);
		btnAugmenterThermostat.setEnabled(true);
		add(btnAugmenterThermostat);
	}

	public void actionPerformed(ActionEvent evt){
		// On laisse traiter les actions demarrer et arreter au parent
		super.actionPerformed(evt);

		AppareilThermostate cetAppareil=(AppareilThermostate)appareil;

		Object src = evt.getSource();
		if (src == btnDemarrer) {
			try {
				appareil.demarrer(lePanoCompteur.getCompteur());
			} catch (CompteurADisjoncteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			btnArreter.setOpaque(false);
			btnDemarrer.setOpaque(true);
			onOff.setBackground(Color.green);
			try {
				lePanoCompteur.majConso();
			} catch (CompteurADisjoncteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (src == btnArreter) {
			try {
				appareil.arreter(lePanoCompteur.getCompteur());
			} catch (CompteurADisjoncteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			btnArreter.setOpaque(true);
			btnDemarrer.setOpaque(false);
			onOff.setBackground(Color.red);
			try {
				lePanoCompteur.majConso();
			} catch (CompteurADisjoncteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(src == btnAugmenterThermostat){
			try {
				cetAppareil.incrementeThermostat(lePanoCompteur.getCompteur());
			} catch (CompteurADisjoncteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			afficherThermostat();
			if (cetAppareil.getValeurThermostat() ==  cetAppareil.getValeurThermostatMax()) {
				btnAugmenterThermostat.setEnabled(false);
			}
			btnDiminuerThermostat.setEnabled(true);
			cetAppareil.calculConsommation();
			try {
				lePanoCompteur.majConso();
			} catch (CompteurADisjoncteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (src == btnDiminuerThermostat){
			try {
				cetAppareil.decrementeThermostat(lePanoCompteur.getCompteur());
			} catch (CompteurADisjoncteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			afficherThermostat();
			if (cetAppareil.getValeurThermostat() ==  0) {
				btnDiminuerThermostat.setEnabled(false);;
			}
			btnAugmenterThermostat.setEnabled(true);
			cetAppareil.calculConsommation();
			try {
				lePanoCompteur.majConso();
			} catch (CompteurADisjoncteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//btnDiminuerThermostat
	}//actionPerformed(ActionEvent evt)




	private void afficherThermostat(){
		AppareilThermostate  cetAppareil = (AppareilThermostate)appareil;
		String s = new Integer(cetAppareil.getValeurThermostat()).toString();

		if (s.length()<2) {
			s="0"+s;
		}

		lblThermostat.setText(s);
	}

	//En cas de disjonctage, permet d initialiser les elements du pano
	public void initPano() {
		btnDemarrer.setEnabled(true);
		btnArreter.setEnabled(false);
		btnArreter.setOpaque(true);
		btnDemarrer.setOpaque(false);
		onOff.setBackground(Color.red);
	}





	public int getThermostatCourant() {
		return thermostatCourant;
	}





	public void setThermostatCourant(int thermostatCourant) {
		this.thermostatCourant = thermostatCourant;
	}
}//PanneauAppareil