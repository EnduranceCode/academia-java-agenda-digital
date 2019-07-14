package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.inter.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@Repository
public class CidadeHibernateDAO implements ICidadeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Cidade create(Cidade cidade) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cidade);
		session.flush();
		return cidade;
	}

	@Override
	public Collection<Cidade> read() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Cidade.class);
		return criteria.list();
	}

	@Override
	public void update(Cidade cidade) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cidade);
		session.flush();
	}

	@Override
	public void delete(Integer codigo) {
		Session session = sessionFactory.getCurrentSession();
		Cidade cidade = session.get(Cidade.class, codigo);
		session.delete(cidade);
	}

	@Override
	public Boolean jaExisteCidadeComNome(Cidade cidade) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cidade.class);

		criteria.add(Restrictions.and(Restrictions.eq("nome", cidade.getNome().trim()).ignoreCase()));
		
		if(cidade.getCodigo() != null) {
			criteria.add(Restrictions.ne("codigo", cidade.getCodigo()));
		}

		criteria.setProjection(Projections.count("codigo"));

		return (Long) criteria.uniqueResult() > 0;
	}

	@Override
	public String getNomeCidade(Integer codigo) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cidade.class);
		
		criteria.add(Restrictions.eq("codigo", codigo));
		List<Cidade> results = criteria.list();
		
		return results.get(0).getNome();
	}
}
