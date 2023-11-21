package br.com.senai.sistematranspotadorasaep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.sistematranspotadorasaep.entity.Entrega;
import br.com.senai.sistematranspotadorasaep.entity.Motorista;
import br.com.senai.sistematranspotadorasaep.repository.EntregasRepository;
import br.com.senai.sistematranspotadorasaep.service.EntregaService;

@Service
public class EntregaServiceImpl implements EntregaService {

	@Autowired
	EntregasRepository repository;
	
	@Override
	public Entrega salvar(Entrega entrega) {
		Entrega entregaSalva = this.repository.save(entrega);			
		return repository.buscarPorId(entregaSalva.getId());
	}

	@Override
	public Entrega excluirPorId(Integer id) {
		Entrega entregaEncontrada = repository.buscarPorId(id);	
		this.repository.deleteById(id);
		return entregaEncontrada;
	}

	@Override
	public Entrega buscarPorId(Integer id) {
		Entrega entregaEncontrada = repository.buscarPorId(id);
		Preconditions.checkNotNull(entregaEncontrada, 
				"Não existe entrega para o id informado");
		return entregaEncontrada;
	}

	@Override
	public List<Entrega> listarPorMotorista(Motorista motorista) {
		return repository.listarPorMotorista(motorista);
	}

}
