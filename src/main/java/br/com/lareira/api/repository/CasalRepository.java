package br.com.lareira.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.lareira.api.model.Casal;

public interface CasalRepository extends PagingAndSortingRepository<Casal, Long>, CasalRepositoryQuery {
	
}
