package br.com.senai.sistematranspotadorasaep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.sistematranspotadorasaep.entity.Usuario;
import br.com.senai.sistematranspotadorasaep.repository.UsuariosRepository;
import br.com.senai.sistematranspotadorasaep.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuariosRepository repository;
	
	@Override
	public Usuario salvar(Usuario usuario) {
		Usuario usuarioEncontrado = repository.buscarPorId(usuario.getId());
		List<Usuario> usuarios = repository.listarTodos();
		Usuario usuarioSalvo = null;
		for (Usuario u : usuarios) {
			if (!usuarioEncontrado.getEmail().equals(u.getEmail())) {
				usuarioSalvo = repository.save(usuario);
			} else {
				throw new IllegalArgumentException("Email já cadastrado");
			}
		}
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

	@Override
	public Usuario buscarPorEmail(String email) {
		Usuario usuarioEncontrado = this.repository.buscarPorEmail(email);
		Preconditions.checkNotNull(usuarioEncontrado, 
				"Não existe usuário para o email informado");
		return usuarioEncontrado;
	}

	@Override
	public Usuario validarLogin(String email, String senha) {
		Usuario usuarioEncontrado = buscarPorEmail(email);
		Preconditions.checkArgument(usuarioEncontrado.getSenha().equals(senha), 
				"Senha incorreta");
		return usuarioEncontrado;
	}
	
	

}
