package com.company.domotique.appareils;

import java.util.Comparator;

public class SortByDecroissant implements Comparator<AppareilElectrique> {
	
	@Override
	public int compare(AppareilElectrique p_Appareil1, AppareilElectrique p_Appareil2) {
		int res;
		//TODO algo decroissant
		
		String sMarque1 = p_Appareil1.getMarque();
		String sMarque2 = p_Appareil2.getMarque();
		
		res = sMarque1.compareTo(sMarque2);
		
		if (res == 0) {
			String sModele1 = p_Appareil1.getModele();
			String sModele2 = p_Appareil2.getModele();
			res = sModele1.compareTo(sModele2);
			
			if (res == 0) {
				Integer iPuissanceAppareil1 = new Integer(p_Appareil1.getPuissance());
				Integer iPuissanceAppareil2 = new Integer(p_Appareil2.getPuissance());
				res = iPuissanceAppareil1.compareTo(iPuissanceAppareil2);
			}
		}
		
		return res;
	}
}
