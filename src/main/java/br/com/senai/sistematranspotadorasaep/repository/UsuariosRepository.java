package br.com.senai.sistematranspotadorasaep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senai.sistematranspotadorasaep.entity.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value = "SELECT u "
			+ "FROM Usuario u "
			+ "JOIN FETCH u.transportadora t "
			+ "WHERE u.id = :id")
	public Usuario buscarPorId(Integer id);
	
	@Query(value = "SELECT u "
			+ "FROM Usuario u "
			+ "JOIN FETCH u.transportadora t "
			+ "WHERE u.email = :email")
	public Usuario buscarPorEmail(String email);
	
	@Query(value = "SELECT u "
			+ "FROM Usuario u "
			+ "JOIN FETCH u.transportadora t ")
	public List<Usuario> listarTodos();
	
}
