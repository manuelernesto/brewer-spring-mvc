package io.github.manuelernesto.repository.helper.estilo;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.Model.Estilo;
import io.github.manuelernesto.repository.filter.CervejaFilter;
import io.github.manuelernesto.repository.filter.EstiloFilter;
import io.github.manuelernesto.repository.helper.cerveja.CervejasQueries;
import io.github.manuelernesto.repository.pagination.PaginacaoUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EstilosImpl implements EstilosQueries {

    @PersistenceContext
    private EntityManager manager;

    private final PaginacaoUtil paginacaoUtil;

    public EstilosImpl(PaginacaoUtil paginacaoUtil) {
        this.paginacaoUtil = paginacaoUtil;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Estilo> filtrar(EstiloFilter filter, Pageable pageable) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);
        paginacaoUtil.prepare(criteria, pageable);
        adicionarFiltro(filter, criteria);
        return new PageImpl<>(criteria.list(), pageable, total(filter));
    }


    private void adicionarFiltro(EstiloFilter filter, Criteria criteria) {
        if (filter != null) {
            if (!StringUtils.isEmpty(filter.getNome()))
                criteria.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.ANYWHERE));
        }
    }

    private Long total(EstiloFilter filter) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);
        adicionarFiltro(filter, criteria);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

}




















