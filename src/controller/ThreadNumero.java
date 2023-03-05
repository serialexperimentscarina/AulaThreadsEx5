package controller;

import javax.swing.JTextField;

public class ThreadNumero extends Thread{
	
	private static final int MAX_GIROS = 150;
	private static final int MAX_NUM = 7;
	private JTextField numero;
	
	public ThreadNumero(JTextField numero) {
		this.numero = numero;
	}
	
	@Override
	public void run() {
		int numGiros = (int) (Math.random() * (MAX_GIROS - 1) + 1);
		
		for (int i = 0; i < numGiros; i++) {
			int num = (int) (Math.random() * (MAX_NUM - 1) + 1);
			numero.setText(String.valueOf(num));
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
