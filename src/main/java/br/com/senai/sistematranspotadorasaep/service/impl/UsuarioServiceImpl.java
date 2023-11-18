package br.com.senai.sistematranspotadorasaep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Preconditions;

import br.com.senai.sistematranspotadorasaep.entity.Usuario;
import br.com.senai.sistematranspotadorasaep.repository.UsuariosRepository;
import br.com.senai.sistematranspotadorasaep.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuariosRepository repository;
	
	@Override
	public Usuario salvar(Usuario usuario) {
		Usuario usuarioSalvo = this.repository.save(usuario);			
		return repository.buscarPorId(usuarioSalvo.getId());
	}

	@Override
	public Usuario excluirPorId(Integer id) {
		Usuario usuarioEncontrado = repository.buscarPorId(id);	
		this.repository.deleteById(id);
		return usuarioEncontrado;
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		Usuario usuarioEncontrado = repository.buscarPorId(id);
		Preconditions.checkNotNull(usuarioEncontrado, 
				"Não existe usuário para o id informado");
		return usuarioEncontrado;
	}

}
