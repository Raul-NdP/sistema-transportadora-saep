package br.com.senai.sistematranspotadorasaep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senai.sistematranspotadorasaep.entity.Transportadora;

@Repository
public interface TransportadorasRepository extends JpaRepository<Transportadora, Integer>{
	
	@Query(value = "SELECT t "
			+ "FROM Transportadora t "
			+ "WHERE t.id = :id")
	public Transportadora buscarPorId(Integer id);
	
}
