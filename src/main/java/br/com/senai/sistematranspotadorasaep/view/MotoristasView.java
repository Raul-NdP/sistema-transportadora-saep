package br.com.senai.sistematranspotadorasaep.view;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.sistematranspotadorasaep.entity.Motorista;
import br.com.senai.sistematranspotadorasaep.entity.Usuario;
import br.com.senai.sistematranspotadorasaep.service.MotoristaService;
import br.com.senai.sistematranspotadorasaep.view.components.table.MotoristaTableModel;

@Component
public class MotoristasView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable tabelaMotoristas;
	
	private JLabel txtNomeTransportadora;
	
	private Usuario usuario;
	
	@Autowired
	@Qualifier("motoristaServiceImpl")
	private MotoristaService service;
	
	public MotoristasView() {
		
		carregarTabela(usuario);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		txtNomeTransportadora = new JLabel("Nome Transportadora");
		txtNomeTransportadora.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNomeTransportadora.setHorizontalAlignment(SwingConstants.LEFT);
		txtNomeTransportadora.setBounds(10, 11, 404, 25);
		contentPane.add(txtNomeTransportadora);
		
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
	
	public void setTxtNomeTransportadora(String nome) {
		this.txtNomeTransportadora.setText(nome);
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	private void carregarTabela(Usuario usuario) {
		List<Motorista> categorias = service.listarPorTransportadora(usuario.getTransportadora());
		MotoristaTableModel model = new MotoristaTableModel(categorias);
		tabelaMotoristas.setModel(model);
		configurarTabela();
	}
	
	private void configurarColuna(int indice, int largura) {
		
		this.tabelaMotoristas.getColumnModel().getColumn(indice).setResizable(false);
		this.tabelaMotoristas.getColumnModel().getColumn(indice).setPreferredWidth(largura);
		
	}
	
	private void configurarTabela() {
		
		final int COLUNA_ID = 0;
		final int COLUNA_NOME = 1;
		
		this.tabelaMotoristas.getTableHeader().setReorderingAllowed(false);
		this.tabelaMotoristas.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.configurarColuna(COLUNA_ID, 90);
		this.configurarColuna(COLUNA_NOME, 250);
	}
	
}
