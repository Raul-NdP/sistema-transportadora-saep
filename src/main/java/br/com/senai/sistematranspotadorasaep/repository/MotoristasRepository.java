package br.com.senai.sistematranspotadorasaep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senai.sistematranspotadorasaep.entity.Motorista;
import br.com.senai.sistematranspotadorasaep.entity.Transportadora;

@Repository
public interface MotoristasRepository extends JpaRepository<Motorista, Integer>{
	
	@Query(value = "SELECT m "
			+ "FROM Motorista m "
			+ "JOIN FETCH m.transportadora t "
			+ "WHERE m.id = :id")
	public Motorista buscarPorId(Integer id);
	
	@Query(value = "SELECT m "
			+ "FROM Motorista m "
			+ "JOIN FETCH m.transportadora t "
			+ "WHERE m.transportadora = :transportadora")
	public List<Motorista> listarPorTransportadora(Transportadora transportadora);
	
}
