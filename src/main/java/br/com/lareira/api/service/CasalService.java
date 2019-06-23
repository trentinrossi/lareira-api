package br.com.lareira.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.lareira.api.model.Casal;
import br.com.lareira.api.model.Lareira;
import br.com.lareira.api.repository.CasalRepository;
import br.com.lareira.api.repository.LareiraRepository;
import br.com.lareira.api.service.exception.LareiraInexistenteException;

@Service
public class CasalService {

	@Autowired
	private CasalRepository repository;
	
	@Autowired 
	private LareiraRepository lareiraRepo;

	/**
	 * Valida informações antes de inserir
	 * @param casal
	 * @return
	 */
	public Casal inserir(Casal casal) {
		validarLareira(casal);
		return repository.save(casal);
	}
	
	/**
	 * Valida informações antes de alterar	
	 * @param codigo
	 * @param casal
	 * @return
	 */
	public Casal atualizar(Long codigo, Casal casal) {
		Casal r = retornaCasalPeloCodigo(codigo);
		validarLareira(casal);
		BeanUtils.copyProperties(casal, r, "idCasal");
		return repository.save(r);
	}

	/**
	 * Valida se lareira informada existe
	 * 
	 * @param lareira
	 */
	private void validarLareira(Casal casal) {
		Lareira l = null;
		if (casal.getLareira().getIdLareira() != null) {
			l = lareiraRepo.findOne(casal.getLareira().getIdLareira());
		}

		if (l == null) {
			throw new LareiraInexistenteException();
		}
	}

	public Casal retornaCasalPeloCodigo(Long codigo) {
		Casal casalSalvo = repository.findOne(codigo);

		if (casalSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return casalSalvo;
	}
}
