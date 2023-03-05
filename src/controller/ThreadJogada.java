package controller;

import java.awt.Color;
import java.awt.Font;

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
		
		Thread[] numeros = comecaJogo();
		
		for (Thread numero : numeros) {
			try {
				numero.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		encerraJogo();
	}
	
	private Thread[] comecaJogo() {
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setText("Caça-Níquel");
		btnJogar.setEnabled(false);
		
		Thread[] numeros = new Thread[3];		
		for (int i = 0; i < 3; i++) {
			numeros[i] = new ThreadNumero(nums[i]);
			numeros[i].start();
		}
		return numeros;
	}
	
	private void encerraJogo() {
		if (nums[1].getText().equals(nums[2].getText()) && nums[2].getText().equals(nums[3].getText())) {
			lblTitulo.setText("GANHOU!");
			lblTitulo.setForeground(new Color(124, 252, 0));
		} else {
			lblTitulo.setText("PERDEU!");
			lblTitulo.setForeground(new Color(200, 0, 0));
		}
		btnJogar.setEnabled(true);
	}

}
