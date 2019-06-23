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

import br.com.lareira.api.event.RecursoPadraoCriadoEvent;
import br.com.lareira.api.model.Casal;
import br.com.lareira.api.repository.CasalRepository;
import br.com.lareira.api.service.CasalService;

@RestController
@RequestMapping("/casais")
public class CasalResource {
	
	@Autowired
	private CasalRepository repository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private CasalService service;
	
	@PostMapping
	@PreAuthorize("hasAuthority('CASAL_INSERT') and #oauth2.hasScope('write')")
	public ResponseEntity<Casal> inserir(@Valid @RequestBody Casal casal, HttpServletResponse response) {		
		Casal casalSalvo = service.inserir(casal);				
		publisher.publishEvent(new RecursoPadraoCriadoEvent(this, response, casalSalvo.getIdCasal()));
		return ResponseEntity.status(HttpStatus.CREATED).body(casalSalvo);
	}

	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('CASAL_UPDATE') and #oauth2.hasScope('write')")
	public ResponseEntity<Casal> atualizar(@PathVariable Long codigo, @Valid @RequestBody Casal casal) {
		Casal casalSalvo = service.atualizar(codigo, casal);
		return ResponseEntity.ok(casalSalvo);
	}

	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('CASAL_DELETE') and #oauth2.hasScope('delete')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		repository.delete(codigo);
	}

	@GetMapping
	@PreAuthorize("hasAuthority('CASAL_VIEW') and #oauth2.hasScope('read')")
	public List<Casal> listar() {
		return repository.findAll();
	}

	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('CASAL_VIEW') and #oauth2.hasScope('read')")
	public ResponseEntity<Casal> retornaPeloCodigo(@PathVariable Long codigo) {
		if (repository.findOne(codigo) == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(repository.getOne(codigo));
		}
	}
}
