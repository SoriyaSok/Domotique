package com.company.domotique.ihm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Horloge extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -137468650667640182L;
	public JLabel	labCpt = new JLabel("Il est :   ");
	private Thread myThread;

	public Horloge() {
		add(labCpt);
		myThread = new Thread(this);
		myThread.start(); 
	}


	public void run() {
		//TODO
		String time = "";
		
		while (true) {
			//String txtDate = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date());
			try{
				Thread.sleep(1000);
				// Recuperer l'heure courante a partir du GregorianCalendar
				//time = (LocalDateTime.now(Clock.systemDefaultZone())).toString();
				DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				Date date = new Date();
				time = dateFormat.format(date);
				
				
				// setter le label avec lheure : HOUR.MINUT.SECND
				// TODO instancier le  calendrier
				//date = unCalendar.getTimeInMillis();
				
				
				// maj l'IHM
				//labCpt.setText("Il est: "
			}// try
			catch (InterruptedException e){
				e.toString();
			}// catch
			labCpt.setText("il est : "+ time);
		} // while
	}


} // class Horloge