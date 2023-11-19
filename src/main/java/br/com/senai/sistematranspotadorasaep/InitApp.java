package br.com.senai.sistematranspotadorasaep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.sistematranspotadorasaep.repository.EntregasRepository;
import br.com.senai.sistematranspotadorasaep.repository.MotoristasRepository;
import br.com.senai.sistematranspotadorasaep.repository.TransportadorasRepository;
import br.com.senai.sistematranspotadorasaep.repository.UsuariosRepository;
import br.com.senai.sistematranspotadorasaep.view.LoginView;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	@Autowired
	UsuariosRepository repositoryU;
	
	@Autowired
	TransportadorasRepository repositoryT;
	
	@Autowired
	MotoristasRepository repositoryM;
	
	@Autowired
	EntregasRepository repositoryE;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			System.setProperty("java.awt.headless", "false");
			LoginView view = new LoginView();
			view.setVisible(true);
			
			//Transportadora transportadora = new Transportadora();
			//transportadora.setId(1);
			//transportadora.setNome("a");
			//System.out.println(transportadora);
			
			//System.out.println(repositoryT.buscarPorId(1));
			
			//Usuario usuario = new Usuario();
			//usuario.setId(1);
			//usuario.setEmail("a");
			//usuario.setSenha("a");
			//usuario.setTransportadora(transportadora);
			//System.out.println(usuario);
			
			//System.out.println(repositoryU.buscarPorId(1));
			
			//Motorista motorista = new Motorista();
			//motorista.setId(1);
			//motorista.setNome("a");
			//motorista.setCnh("a");
			//motorista.setTransportadora(transportadora);
			//System.out.println(motorista);
			
			//System.out.println(repositoryM.buscarPorId(1));
			//System.out.println(repositoryM.listarPorTransportadora(transportadora));
			
			//Entrega entrega = new Entrega();
			//entrega.setId(1);
			//entrega.setDescricao("a");
			//entrega.setMotorista(motorista);
			//System.out.println(entrega);
			
			//System.out.println(repositoryE.buscarPorId(1));
			//System.out.println(repositoryE.listarPorMotorista(motorista));
			
		};
	}

}
