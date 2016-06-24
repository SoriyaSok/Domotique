package com.company.domotique.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.company.domotique.appareils.AppareilThermostate;


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
			btnArreter.setOpaque(false);
			btnDemarrer.setOpaque(true);
			onOff.setBackground(Color.green);
			cetAppareil.calculConsommation();
			lePanoCompteur.majConso();

		}
		else if (src == btnArreter) {
			btnArreter.setOpaque(true);
			btnDemarrer.setOpaque(false);
			onOff.setBackground(Color.red);
			cetAppareil.calculConsommation();
			lePanoCompteur.majConso();
		}
		else if(src == btnAugmenterThermostat){
			cetAppareil.incrementeThermostat();
			afficherThermostat();
			if (cetAppareil.getValeurThermostat() ==  cetAppareil.getValeurThermostatMax()) {
				btnAugmenterThermostat.setEnabled(false);
			}
			btnDiminuerThermostat.setEnabled(true);
			cetAppareil.calculConsommation();
			lePanoCompteur.majConso();
		}
		else if (src == btnDiminuerThermostat){
			cetAppareil.decrementeThermostat();
			afficherThermostat();
			if (cetAppareil.getValeurThermostat() ==  0) {
				btnDiminuerThermostat.setEnabled(false);;
			}
			btnAugmenterThermostat.setEnabled(true);
			cetAppareil.calculConsommation();
			lePanoCompteur.majConso();
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
		super.initPano();
		btnArreter.setOpaque(true);
		btnDemarrer.setOpaque(false);
		onOff.setBackground(Color.red);
		btnAugmenterThermostat.setEnabled(false);
		btnDiminuerThermostat.setEnabled(false);
		lblThermostat.setText("0");	
	}





	public int getThermostatCourant() {
		return thermostatCourant;
	}





	public void setThermostatCourant(int thermostatCourant) {
		this.thermostatCourant = thermostatCourant;
	}
}//PanneauAppareil