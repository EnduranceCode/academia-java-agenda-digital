package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.inter.ITipoServicoDAO;
import com.everis.academia.java.agenda.digital.entity.TipoServico;

@Repository
public class TipoServicoHibernateDAO implements ITipoServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TipoServico create(TipoServico tipoServico) {
		Session session = sessionFactory.getCurrentSession();
		session.save(tipoServico);
		session.flush();
		return tipoServico;
	}

	@Override
	public List<TipoServico> read() {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(TipoServico.class);
		return criteria.list();
	}

	@Override
	public void update(TipoServico tipoServico) {
		Session session = sessionFactory.getCurrentSession();
		session.update(tipoServico);
		session.flush();
	}

	@Override
	public void delete(Short codigo) {
		Session session = sessionFactory.getCurrentSession();
		TipoServico tipoServico = session.get(TipoServico.class, codigo);
		session.delete(tipoServico);
	}

	@Override
	public Boolean jaExisteTipoServico(TipoServico tipoServico) {

		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(TipoServico.class);

		criteria.add(Restrictions.and(Restrictions.eq("descricao", tipoServico.getDescricao().trim()).ignoreCase()));
		
		if(tipoServico.getCodigo() != null) {
			criteria.add(Restrictions.ne("codigo", tipoServico.getCodigo()));
		}

		criteria.setProjection(Projections.count("codigo"));

		return (Long) criteria.uniqueResult() > 0;
	}
}
