package br.com.lareira.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lareira.api.model.Lareira;
import br.com.lareira.api.repository.LareiraRepository;

@RestController
@RequestMapping("/lareiras")
public class LareiraResource {
	
	@Autowired
	private LareiraRepository repository;
	
	@GetMapping
	public List<Lareira> listar() {
		return repository.findAll();
	}

	@PostMapping
	public void inserir(@Valid @RequestBody Lareira lareira) {
		repository.save(lareira);
	}
	
	
	
}
