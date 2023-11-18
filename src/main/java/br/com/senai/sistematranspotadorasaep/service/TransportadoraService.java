package br.com.senai.sistematranspotadorasaep.service;

import org.springframework.validation.annotation.Validated;

import br.com.senai.sistematranspotadorasaep.entity.Transportadora;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public interface TransportadoraService {
	
	public Transportadora salvar(
			@NotNull(message = "A transportadora é obrigatória")
			Transportadora Transportadora);
	
	public Transportadora excluirPorId(
			@Positive(message = "O id deve ser positivo")
			@NotNull(message = "O id é obrigatório")
			Integer id);
	
	public Transportadora buscarPorId(
			@Positive(message = "O id deve ser positivo")
			@NotNull(message = "O id é obrigatório")
			Integer id);
	
}
