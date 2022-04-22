package com.rc.gestaocontrato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.gestaocontrato.domain.Cliente;
import com.rc.gestaocontrato.dto.ClienteDTO;
import com.rc.gestaocontrato.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow();
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente create(Cliente obj) {
		obj.setId(null);
		return clienteRepository.save(obj);
	}
	
	public Cliente update(Integer id, ClienteDTO objDTO) {
		Cliente obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setNumero(objDTO.getNumero());
		return clienteRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			clienteRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
