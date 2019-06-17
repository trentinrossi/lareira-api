package br.com.lareira.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.lareira.api.model.Lareira;
import br.com.lareira.api.repository.LareiraRepository;

@Service
public class LareiraService {

	@Autowired
	private LareiraRepository repository;

	public Lareira retornaLareiraPeloCodigo(Long codigo) {
		Lareira lareiaSalva = repository.findOne(codigo);

		if (lareiaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return lareiaSalva;
	}

	public Lareira atualizar(Long codigo, Lareira lareira) {
		Lareira r = retornaLareiraPeloCodigo(codigo);
		BeanUtils.copyProperties(lareira, r, "idLareira");
		return repository.save(r);
	}
}
