package com.rc.gestaocontrato.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.gestaocontrato.domain.Cliente;
import com.rc.gestaocontrato.domain.Contrato;
import com.rc.gestaocontrato.repositories.ClienteRepository;
import com.rc.gestaocontrato.repositories.ContratoRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	public void instanciaDB() {
		Cliente c1 = new Cliente(null, 269, "José Junqueira");
		Cliente c2 = new Cliente(null, 270, "Joaquim Junqueira");
		Cliente c3 = new Cliente(null, 1025, "João da Silva");
		Cliente c4 = new Cliente(null, 2369, "Maria de Paula");
		
		Contrato cont1 = new Contrato(null, 5698, 2, 256.25, c4);
		Contrato cont2 = new Contrato(null, 1235, 8, 300.00, c3);
		Contrato cont3 = new Contrato(null, 8458, 2, 5000.00, c2);
		Contrato cont4 = new Contrato(null, 2569, 5, 36598.98, c1);
		Contrato cont5 = new Contrato(null, 256, 5, 158.25, c2);
		
		c1.getContratos().addAll(Arrays.asList(cont1));
		c2.getContratos().addAll(Arrays.asList(cont2));
		c3.getContratos().addAll(Arrays.asList(cont3));
		c4.getContratos().addAll(Arrays.asList(cont4));
		c1.getContratos().addAll(Arrays.asList(cont5));
		
		this.clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		this.contratoRepository.saveAll(Arrays.asList(cont1, cont2, cont3, cont4, cont5));
	}
}
