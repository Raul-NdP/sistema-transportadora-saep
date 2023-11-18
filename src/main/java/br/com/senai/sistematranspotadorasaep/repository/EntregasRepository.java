package br.com.senai.sistematranspotadorasaep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senai.sistematranspotadorasaep.entity.Entrega;
import br.com.senai.sistematranspotadorasaep.entity.Motorista;

@Repository
public interface EntregasRepository extends JpaRepository<Entrega, Integer>{
	
	@Query(value = "SELECT e "
			+ "FROM Entrega e "
			+ "JOIN FETCH e.motorista m "
			+ "JOIN FETCH m.transportadora t "
			+ "WHERE e.id = :id")
	public Entrega buscarPorId(Integer id);
	
	@Query(value = "SELECT e "
			+ "FROM Entrega e "
			+ "JOIN FETCH e.motorista m "
			+ "JOIN FETCH m.transportadora t "
			+ "WHERE e.motorista = :motorista")
	public List<Entrega> listarPorMotorista(Motorista motorista);
	
}
