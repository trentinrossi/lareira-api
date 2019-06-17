package br.com.lareira.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lareira.api.event.RecursoCriadoEvent;
import br.com.lareira.api.model.Lareira;
import br.com.lareira.api.repository.LareiraRepository;
import br.com.lareira.api.service.LareiraService;

@RestController
@RequestMapping("/lareiras")
public class LareiraResource {

	@Autowired
	private LareiraRepository repository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private LareiraService service;

	@PostMapping
	@PreAuthorize("hasAuthority('LAREIRA_INSERT') and #oauth2.hasScope('write')")
	public ResponseEntity<Lareira> inserir(@Valid @RequestBody Lareira lareira, HttpServletResponse response) {
		Lareira lareiraSalva = repository.save(lareira);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lareiraSalva.getIdLareira()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lareiraSalva);
	}

	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('LAREIRA_UPDATE') and #oauth2.hasScope('write')")
	public ResponseEntity<Lareira> atualizar(@PathVariable Long codigo, @Valid @RequestBody Lareira lareira) {
		Lareira lareiraSalva = service.atualizar(codigo, lareira);
		return ResponseEntity.ok(lareiraSalva);
	}

	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('LAREIRA_DELETE') and #oauth2.hasScope('delete')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		repository.delete(codigo);
	}

	@GetMapping
	@PreAuthorize("hasAuthority('LAREIRA_VIEW') and #oauth2.hasScope('read')")
	public List<Lareira> listar() {
		return repository.findAll();
	}

	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('LAREIRA_VIEW') and #oauth2.hasScope('read')")
	public ResponseEntity<Lareira> retornaPeloCodigo(@PathVariable Long codigo) {
		if (repository.findOne(codigo) == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(repository.getOne(codigo));
		}
	}

}
