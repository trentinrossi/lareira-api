package br.com.lareira.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.lareira.api.model.Casal;

public interface CasalRepositoryQuery {
	public Page<Casal> filtrar(CasalRepositoryFilter casalFilter, Pageable pageable);
}
