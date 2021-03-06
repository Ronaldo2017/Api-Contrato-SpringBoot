package com.rc.gestaocontrato.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rc.gestaocontrato.domain.Contrato;
import com.rc.gestaocontrato.dto.ContratoDTo;
import com.rc.gestaocontrato.services.ContratoService;

@RestController
@RequestMapping(value = "/contratos")
public class ContratoResource {

	@Autowired
	private ContratoService contratoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Contrato> findById(@PathVariable Integer id) {
		Contrato obj = contratoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<ContratoDTo>> findAll() {
		List<Contrato> list = contratoService.findAll();
		List<ContratoDTo> listDTO = list.stream().map(obj -> new ContratoDTo(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Contrato> create(@RequestBody Contrato obj) {
		obj = contratoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ContratoDTo> update(@PathVariable Integer id, @RequestBody ContratoDTo objDTO) {
		Contrato newObj = contratoService.update(id, objDTO);
		return ResponseEntity.ok().body(new ContratoDTo(newObj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		contratoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
