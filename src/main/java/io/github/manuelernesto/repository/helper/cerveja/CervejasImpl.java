package io.github.manuelernesto.repository.helper.cerveja;

import io.github.manuelernesto.Model.Cerveja;
import io.github.manuelernesto.repository.filter.CervejaFilter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CervejasImpl implements CervejasQueries {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cerveja> filtrar(CervejaFilter filter) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);

        if (filter != null) {
            if (!StringUtils.isEmpty(filter.getSku())) {
                criteria.add(Restrictions.eq("sku", filter.getSku()));
            }
        }

        return criteria.list();
    }
}








