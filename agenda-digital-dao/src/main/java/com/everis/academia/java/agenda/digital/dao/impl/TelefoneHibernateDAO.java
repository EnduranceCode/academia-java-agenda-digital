package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.inter.ITelefoneDAO;
import com.everis.academia.java.agenda.digital.entity.Cidade;
import com.everis.academia.java.agenda.digital.entity.Telefone;

@Repository
public class TelefoneHibernateDAO implements ITelefoneDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Telefone create(Telefone telefone) {
		Session session = sessionFactory.getCurrentSession();
		session.save(telefone);
		session.flush();
		return telefone;
	}

	@Override
	public List<Telefone> read() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Telefone.class);
		return criteria.list();
	}

	@Override
	public void update(Telefone telefone) {
		Session session = sessionFactory.getCurrentSession();
		session.update(telefone);
		session.flush();
	}

	@Override
	public void delete(Integer codigo) {
		Session session = sessionFactory.getCurrentSession();
		Telefone telefone = session.get(Telefone.class, codigo);
		session.delete(telefone);
	}

	@Override
	public Boolean jaExisteEsteTelefone(Telefone telefone) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Telefone.class);

		criteria.add(Restrictions.eq("numero", telefone.getNumero()));
		
		if(telefone.getCodigo() != null) {
			criteria.add(Restrictions.ne("codigo", telefone.getCodigo()));
		}

		criteria.setProjection(Projections.count("codigo"));

		return (Long) criteria.uniqueResult() > 0;
	}
}
