package br.com.senai.sistematranspotadorasaep.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.senai.sistematranspotadorasaep.entity.Usuario;
import br.com.senai.sistematranspotadorasaep.service.UsuarioService;

@Component
public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField edtEmail;
	private JTextField edtSenha;
	
	@Autowired
	MotoristasView view;
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioService service;
	
	public LoginView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		edtEmail = new JTextField();
		edtEmail.setBounds(100, 40, 200, 30);
		contentPane.add(edtEmail);
		edtEmail.setColumns(10);
		
		edtSenha = new JTextField();
		edtSenha.setColumns(10);
		edtSenha.setBounds(100, 81, 200, 30);
		contentPane.add(edtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String email = edtEmail.getText();
					String senha = edtSenha.getText();
					Usuario usuario = service.validarLogin(email, senha);
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								
								view.setTxtNomeTransportadora(usuario.getTransportadora().getNome());
								view.setUsuario(usuario);
								view.setVisible(true);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
							
						}
					});
					
					dispose();
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
				
			}
		});
		btnEntrar.setBounds(100, 122, 200, 35);
		contentPane.add(btnEntrar);
	}
}
