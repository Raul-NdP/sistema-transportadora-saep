package br.com.senai.sistematranspotadorasaep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Preconditions;

import br.com.senai.sistematranspotadorasaep.entity.Transportadora;
import br.com.senai.sistematranspotadorasaep.repository.TransportadorasRepository;
import br.com.senai.sistematranspotadorasaep.service.TransportadoraService;

public class TransportadoraServiceimpl implements TransportadoraService {
	
	@Autowired
	TransportadorasRepository repository;
	
	@Override
	public Transportadora salvar(Transportadora transportadora) {
		Transportadora transportadoraSalva = this.repository.save(transportadora);			
		return repository.buscarPorId(transportadoraSalva.getId());
	}

	@Override
	public Transportadora excluirPorId(Integer id) {
		Transportadora transportadoraEncontrada = repository.buscarPorId(id);	
		this.repository.deleteById(id);
		return transportadoraEncontrada;
	}

	@Override
	public Transportadora buscarPorId(Integer id) {
		Transportadora transportadoraEncontrada = repository.buscarPorId(id);
		Preconditions.checkNotNull(transportadoraEncontrada, 
				"Não existe transportadora para o id informado");
		return transportadoraEncontrada;
	}

}
