package br.com.senai.sistematranspotadorasaep.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import br.com.senai.sistematranspotadorasaep.entity.Motorista;
import br.com.senai.sistematranspotadorasaep.entity.Transportadora;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public interface MotoristaService {
	
	public Motorista salvar(
			@NotNull(message = "O motorista é obrigatório")
			Motorista motorista);
	
	public Motorista excluirPorId(
			@Positive(message = "O id deve ser positivo")
			@NotNull(message = "O id é obrigatório")
			Integer id);
	
	public Motorista buscarPorId(
			@Positive(message = "O id deve ser positivo")
			@NotNull(message = "O id é obrigatório")
			Integer id);
	
	public List<Motorista> listarPorTransportadora(
			@NotNull(message = "A transportadora não pode ser nula")
			Transportadora transportadora);
	
}
