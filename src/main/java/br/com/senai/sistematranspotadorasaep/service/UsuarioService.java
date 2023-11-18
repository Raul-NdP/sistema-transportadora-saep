package br.com.senai.sistematranspotadorasaep.service;

import org.springframework.validation.annotation.Validated;

import br.com.senai.sistematranspotadorasaep.entity.Usuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public interface UsuarioService {
	
	public Usuario salvar(
			@NotNull(message = "O usuário é obrigatório")
			Usuario usuario);
	
	public Usuario excluirPorId(
			@Positive(message = "O id deve ser positivo")
			@NotNull(message = "O id é obrigatório")
			Integer id);
	
	public Usuario buscarPorId(
			@Positive(message = "O id deve ser positivo")
			@NotNull(message = "O id é obrigatório")
			Integer id);
	
}
