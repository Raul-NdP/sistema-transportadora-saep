package br.com.senai.sistematranspotadorasaep.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import br.com.senai.sistematranspotadorasaep.entity.Entrega;
import br.com.senai.sistematranspotadorasaep.entity.Motorista;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public interface EntregaService {
	
	public Entrega salvar(
			@NotNull(message = "A entrega é obrigatória")
			Entrega entrega);
	
	public Entrega excluirPorId(
			@Positive(message = "O id deve ser positivo")
			@NotNull(message = "O id é obrigatório")
			Integer id);
	
	public Entrega buscarPorId(
			@Positive(message = "O id deve ser positivo")
			@NotNull(message = "O id é obrigatório")
			Integer id);
	
	public List<Entrega> listarPorMotorista(
			@NotNull(message = "O motorista não pode ser nulo")
			Motorista motorista);
	
}
