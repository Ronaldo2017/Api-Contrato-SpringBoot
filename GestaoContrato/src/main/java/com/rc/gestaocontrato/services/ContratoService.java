package com.rc.gestaocontrato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.gestaocontrato.domain.Contrato;
import com.rc.gestaocontrato.dto.ContratoDTo;
import com.rc.gestaocontrato.repositories.ContratoRepository;

@Service
public class ContratoService {
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	public Contrato findById(Integer id) {
		Optional<Contrato> obj = contratoRepository.findById(id);
		return obj.orElseThrow();
	}
	
	public List<Contrato> findAll(){
		return contratoRepository.findAll();
	}
	
	public Contrato create(Contrato obj) {
		obj.setId(null);
		return contratoRepository.save(obj);
	}
	
	public Contrato update(Integer id, ContratoDTo objDTO) {
		Contrato obj = findById(id);
		obj.setNumero(objDTO.getNumero());
		obj.setQuantidade(objDTO.getQuantidade());
		obj.setValor(objDTO.getValor());
		return contratoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			contratoRepository.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
