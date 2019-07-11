package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.inter.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.entity.PrestadorServico;

@Repository
public class PrestadorServicoHibernateDAO implements IPrestadorServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {
		Session session = sessionFactory.getCurrentSession();
		session.save(prestadorServico);
		session.flush();
		return prestadorServico;
	}

	@Override
	public List<PrestadorServico> read() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(PrestadorServico.class);
		return criteria.list();
	}

	@Override
	public void update(PrestadorServico prestadorServico) {
		Session session = sessionFactory.getCurrentSession();
		session.update(prestadorServico);
		session.flush();
	}

	@Override
	public void delete(Integer codigo) {
		Session session = sessionFactory.getCurrentSession();
		PrestadorServico prestadorServico = session.get(PrestadorServico.class, codigo);
		session.delete(prestadorServico);
	}
}
