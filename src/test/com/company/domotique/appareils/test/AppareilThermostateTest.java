package com.company.domotique.appareils.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.company.domotique.appareils.AppareilThermostate;

public class AppareilThermostateTest {

	@Test
	public void testIncrementeThermostat() {
		
		AppareilThermostate chauffage = new AppareilThermostate("Philips", "mod123", 250, 10, 25);
		int valeurThermostat = 10;
		chauffage.setValeurThermostat(valeurThermostat);
		chauffage.incrementeThermostat();
		int nouvelleValeurThermostat = chauffage.getValeurThermostat();
		
		assertEquals(valeurThermostat+1, nouvelleValeurThermostat);
	}

	@Test
	public void testIncrementeThermostatWhenThermostatMax() {
		
		AppareilThermostate chauffage = new AppareilThermostate("Philips", "mod123", 250, 10, 25);
		int valeurThermostat = 25;
		chauffage.setValeurThermostat(valeurThermostat);
		chauffage.incrementeThermostat();
		int nouvelleValeurThermostat = chauffage.getValeurThermostat();
		
		assertEquals(valeurThermostat, nouvelleValeurThermostat);
	}
}
