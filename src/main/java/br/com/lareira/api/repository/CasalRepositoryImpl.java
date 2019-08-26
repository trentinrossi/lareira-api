package br.com.lareira.api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.com.lareira.api.model.Casal;

public class CasalRepositoryImpl implements CasalRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Casal> filtrar(CasalRepositoryFilter casalFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Casal> criteria = builder.createQuery(Casal.class);
		Root<Casal> root = criteria.from(Casal.class);

		// Predicate[] predicates = criarRestricoes(casalFilter, builder, root);
		Predicate maridoEmail = builder.like(builder.lower(root.get("maridoEmail")),"%" + "%");
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			maridoEmail = builder.like(builder.lower(root.get("maridoEmail")),"%" + casalFilter.getGlobalFilter().toLowerCase() + "%");
		}
		
		Predicate maridoNome = builder.like(builder.lower(root.get("maridoNome")),"%" + "%");
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			maridoNome = builder.like(builder.lower(root.get("maridoNome")),"%" + casalFilter.getGlobalFilter().toLowerCase() + "%");
		}

		Predicate maridoSobrenome = builder.like(builder.lower(root.get("maridoSobrenome")),"%" + "%");
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			maridoSobrenome = builder.like(builder.lower(root.get("maridoSobrenome")),"%" + casalFilter.getGlobalFilter().toLowerCase() + "%");
		}
		
		Predicate maridoProfissao = builder.like(builder.lower(root.get("maridoProfissao")),"%" + "%");
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			maridoProfissao = builder.like(builder.lower(root.get("maridoProfissao")),"%" + casalFilter.getGlobalFilter().toLowerCase() + "%");
		}
		
		Predicate maridoTelCelular = builder.like(builder.lower(root.get("maridoTelCelular")),"%" + "%");
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			maridoTelCelular = builder.like(builder.lower(root.get("maridoTelCelular")),"%" + casalFilter.getGlobalFilter().toLowerCase() + "%");
		}
		
		Predicate maridoProblemaSaude = builder.like(builder.lower(root.get("maridoProblemaSaude")),"%" + "%");
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			maridoProblemaSaude = builder.like(builder.lower(root.get("maridoProblemaSaude")),"%" + casalFilter.getGlobalFilter().toLowerCase() + "%");
		}
		
		Predicate finalPredicate = builder.or(maridoEmail, maridoNome, maridoSobrenome, maridoProfissao, maridoTelCelular, maridoProblemaSaude);
		criteria.where(finalPredicate);

		TypedQuery<Casal> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(casalFilter));
	}

	private Predicate[] criarRestricoes(CasalRepositoryFilter casalFilter, CriteriaBuilder builder, Root<Casal> root) {
		List<Predicate> predicates = new ArrayList<>();

		// Marido E-mail
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			predicates.add(builder.like(builder.lower(root.get("maridoEmail")),
					"%" + casalFilter.getGlobalFilter().toLowerCase() + "%"));
		}

		// Marido E-mail
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			predicates.add(builder.like(builder.lower(root.get("maridoNome")),
					"%" + casalFilter.getGlobalFilter().toLowerCase() + "%"));
		}

		// Marido E-mail
		if (!StringUtils.isEmpty(casalFilter.getGlobalFilter())) {
			predicates.add(builder.like(builder.lower(root.get("maridoSobrenome")),
					"%" + casalFilter.getGlobalFilter().toLowerCase() + "%"));
		}

		// Predicate finalPredicate = builder.or(predicates.toArray(new
		// Predicate[predicates.size()]));

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(CasalRepositoryFilter casalFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Casal> root = criteria.from(Casal.class);

		Predicate[] predicates = criarRestricoes(casalFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
