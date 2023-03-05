package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThreadJogada;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField num1;
	private JTextField num2;
	private JTextField num3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setTitle("Caça-Níquel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		num1 = new JTextField();
		num1.setEditable(false);
		num1.setHorizontalAlignment(SwingConstants.CENTER);
		num1.setFont(new Font("Tahoma", Font.PLAIN, 48));
		num1.setBounds(180, 150, 90, 75);
		contentPane.add(num1);
		num1.setColumns(10);
		
		num2 = new JTextField();
		num2.setHorizontalAlignment(SwingConstants.CENTER);
		num2.setFont(new Font("Tahoma", Font.PLAIN, 48));
		num2.setEditable(false);
		num2.setColumns(10);
		num2.setBounds(350, 150, 90, 75);
		contentPane.add(num2);
		
		num3 = new JTextField();
		num3.setHorizontalAlignment(SwingConstants.CENTER);
		num3.setFont(new Font("Tahoma", Font.PLAIN, 48));
		num3.setEditable(false);
		num3.setColumns(10);
		num3.setBounds(520, 150, 90, 75);
		contentPane.add(num3);
		
		JLabel lblTitulo = new JLabel("Caça-Níquel");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(300, 50, 175, 40);
		contentPane.add(lblTitulo);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnJogar.setBounds(350, 310, 90, 25);
		btnJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread threadJogada = new ThreadJogada(btnJogar, num1, num2, num3, lblTitulo);
				threadJogada.start();
			}
		});
		contentPane.add(btnJogar);
	}
}
