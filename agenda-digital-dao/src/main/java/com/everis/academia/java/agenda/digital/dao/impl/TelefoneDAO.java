package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.inter.ITelefoneDAO;
import com.everis.academia.java.agenda.digital.entity.Telefone;

@Repository
public class TelefoneDAO implements ITelefoneDAO {
	
	private static List<Telefone> telefones = new ArrayList<>();

	/* Inicializamos um contador para o código do telefone */
	/* TODO: Implementar o código de telefone com a Base de Dados */
	private static Integer contadorCodigo = 0;
	
	/* Adicionamos alguns telefones à lista para para ter dados para usar como exemplo */
	/* TODO: Eliminar depois de adicionada a Base de Dados*/
	static {
		telefones.add(new Telefone(1, 90000001));
		telefones.add(new Telefone(2, 90000002));
		telefones.add(new Telefone(3, 90000003));
		
		contadorCodigo = 3;
	}
	
	/**
	 * Devolve a lista de telefones armazenados
	 * 
	 * @return
	 */
	public static List<Telefone> getTelefones() {
		return telefones;
	}

	@Override
	public Telefone create(Telefone telefone) {
		
		/* Incrementamos o contador do código do Telefone */
		/* TODO: Implementar o código de telefone com a Base de Dados */
		contadorCodigo++;
		
		/* Adicionamos o código do Telefone ao objecto Telefone */
		telefone.setCodigo(contadorCodigo);
		
		/* Adicionamos a nova cidade à lista de cidades */
		telefones.add(telefone);
		
		return telefone;
	}

	@Override
	public List<Telefone> read() {

		return telefones;
	}

	@Override
	public void update(Telefone telefone) {
		
		for (Telefone telefoneActual : telefones) {
			
			if (telefoneActual.getCodigo() == telefone.getCodigo()) {
				
				telefoneActual.setNumero(telefone.getNumero());
			}
		}
	}

	@Override
	public void delete(Integer codigo) {
		
		for (Telefone telefoneActual : telefones) {
			
			if (telefoneActual.getCodigo() == codigo) {
				
				telefones.remove(telefoneActual);
				break;
			}
		}
	}

	@Override
	public Boolean jaExisteEsteTelefone(Telefone telefone) {
		
		for (Telefone telefoneActual : telefones) {
			
			if (telefoneActual.equals(telefone)) {
				
				return true;
			}
		}
		
		return false;
	}
}
