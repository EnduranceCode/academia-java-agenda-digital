package com.everis.academia.java.agenda.digital.web.soap;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;

@WebService()
public class CidadeSOAP {

	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();

	@WebMethod(operationName = "create")
	@WebResult(name = "cidade")
	public Cidade create(
			@WebParam(name = "cidade") Cidade cidade)
			throws BusinessException {

		cidadeBusiness.create(cidade);
		return cidade;
	}
	
	@WebMethod(operationName = "read")
	@WebResult(name = "cidades")
	public Collection<Cidade> read() {

		return cidadeBusiness.read();
	}
	
	@WebMethod(operationName = "update")
	public void update(@WebParam(name = "cidade") Cidade cidade) throws BusinessException {
		
		cidadeBusiness.update(cidade);
	}
	
	@WebMethod(operationName = "delete")
	public void delete(@WebParam(name = "codigo") Integer codigo) throws BusinessException {
		
		cidadeBusiness.delete(codigo);
	}
}
