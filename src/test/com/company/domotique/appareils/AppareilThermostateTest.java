package com.company.domotique.appareils;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppareilThermostateTest {

	@Test
	public void testIncrementeThermostat() {
		//fail("Not yet implemented");
		AppareilThermostate chauffage= new AppareilThermostate("Philips","mod123",1000,20,50);
		chauffage.demarrer();
		
		int valeurThermostat = 45;
		chauffage.setValeurThermostat(valeurThermostat);
		chauffage.incrementeThermostat();
		int nouvelleValeurThermostat = chauffage.getValeurThermostat();
		
		
		//testons...
		//vérifier que nouvelleValeurThermostat = valeurThermostat + 1 ???
		assertEquals(valeurThermostat +1, nouvelleValeurThermostat);
	}
	
	@Test
	public void testIncrementeThermostatWhenThermostatMax() {
		//fail("Not yet implemented");
		AppareilThermostate chauffage= new AppareilThermostate("Philips","mod123",1000,20,50);
		chauffage.demarrer();
		
		//ma version
		int valeurThermostat = 50;
		chauffage.setValeurThermostat(valeurThermostat);
		chauffage.incrementeThermostat();
		int nouvelleValeurThermostat = chauffage.getValeurThermostat();
		
		//testons...
		//vérifier que nouvelleValeurThermostat = valeurThermostat ??? il ne faut pas que valeurThermostat bouge, elle doit rester à 50
		assertEquals(valeurThermostat, nouvelleValeurThermostat);
	}

}
