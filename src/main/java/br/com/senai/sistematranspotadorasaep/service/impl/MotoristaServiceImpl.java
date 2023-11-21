package br.com.senai.sistematranspotadorasaep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.sistematranspotadorasaep.entity.Motorista;
import br.com.senai.sistematranspotadorasaep.entity.Transportadora;
import br.com.senai.sistematranspotadorasaep.repository.MotoristasRepository;
import br.com.senai.sistematranspotadorasaep.service.MotoristaService;

@Service
public class MotoristaServiceImpl implements MotoristaService {

	@Autowired
	MotoristasRepository repository;
	
	@Override
	public Motorista salvar(Motorista motorista) {
		Motorista motoristaSalvo = this.repository.save(motorista);			
		return repository.buscarPorId(motoristaSalvo.getId());
	}

	@Override
	public Motorista excluirPorId(Integer id) {
		Motorista motoristaEncontrado = repository.buscarPorId(id);	
		this.repository.deleteById(id);
		return motoristaEncontrado;
	}

	@Override
	public Motorista buscarPorId(Integer id) {
		Motorista motoristaEncontrado = repository.buscarPorId(id);
		Preconditions.checkNotNull(motoristaEncontrado, 
				"Não existe motorista para o id informado");
		return motoristaEncontrado;
	}

	@Override
	public List<Motorista> listarPorTransportadora(Transportadora transportadora) {
		return repository.listarPorTransportadora(transportadora);
	}

}
