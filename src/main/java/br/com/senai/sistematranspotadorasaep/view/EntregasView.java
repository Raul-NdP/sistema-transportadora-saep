package br.com.senai.sistematranspotadorasaep.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class EntregasView extends JFrame {

	private JPanel contentPane;
	private JTable tabelaEntregas;
	
	public EntregasView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeTransportadora = new JLabel("Nome Transportadora");
		lblNomeTransportadora.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomeTransportadora.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeTransportadora.setBounds(10, 11, 404, 25);
		contentPane.add(lblNomeTransportadora);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(497, 11, 77, 25);
		contentPane.add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 564, 267);
		contentPane.add(scrollPane);
		
		tabelaEntregas = new JTable();
		scrollPane.setViewportView(tabelaEntregas);
		
		JButton btnCadastrar = new JButton("Cadastrar Entrega");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(10, 325, 151, 25);
		contentPane.add(btnCadastrar);
	}

}
