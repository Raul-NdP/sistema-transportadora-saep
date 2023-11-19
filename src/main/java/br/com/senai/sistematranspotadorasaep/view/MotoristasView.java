package br.com.senai.sistematranspotadorasaep.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MotoristasView extends JFrame {

	private JPanel contentPane;
	private JTable tabelaMotoristas;
	
	public MotoristasView() {
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
		
		tabelaMotoristas = new JTable();
		scrollPane.setViewportView(tabelaMotoristas);
		
		JButton btnCadastrar = new JButton("Cadastrar Motorista");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(10, 325, 161, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExcluir.setBounds(497, 328, 77, 25);
		contentPane.add(btnExcluir);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVisualizar.setBounds(396, 328, 91, 25);
		contentPane.add(btnVisualizar);
	}
}
