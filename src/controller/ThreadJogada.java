package controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadJogada extends Thread{
	
	private JButton btnJogar;
	private JTextField[] nums;
	private JLabel lblTitulo;
	
	public ThreadJogada(JButton btnJogar, JTextField num1, JTextField num2, JTextField num3, JLabel lblTitulo) {
		this.btnJogar = btnJogar;
		this.nums = new JTextField[] {num1, num2, num3};
		this.lblTitulo = lblTitulo;
	}
	
	@Override
	public void run() {
		lblTitulo.setText("Caça-Níquel");
		btnJogar.setEnabled(false);
		
		Thread[] numeros = new Thread[3];		
		for (int i = 0; i < 3; i++) {
			numeros[i] = new ThreadNumero(nums[i]);
			numeros[i].start();
		}
		
		for (Thread numero : numeros) {
			try {
				numero.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		lblTitulo.setText((nums[1].getText().equals(nums[2].getText()) && nums[2].getText().equals(nums[3].getText()) ? "GANHOU!" : "PERDEU!"));
		btnJogar.setEnabled(true);
		
	}

}
