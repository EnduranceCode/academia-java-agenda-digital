package com.everis.academia.java.agenda.digital.web.conv;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.everis.academia.java.agenda.digital.entity.Cidade;

@FacesConverter(value = "CidadeConverter", forClass = Cidade.class)
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value == null || value.trim().isEmpty() || ! representaInteiro(value)) {

			return null;
		} else {

			Integer codigo = Integer.valueOf(value);
			Cidade cidade = new Cidade(codigo);

			return cidade;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value == null || !(value instanceof Cidade)) {

			return null;
		} else {
			
			return ((Cidade) value).getCodigo().toString();
		}
	}
	
	/**
	 * Verifica se uma String representa um número inteiro
	 * 
	 * @param string
	 * @return
	 */
	private Boolean representaInteiro(String string) {
		
		try {
			
			Integer.valueOf(string);
		} catch (Exception e) {
			
			return false;
		}
		
		return true;
	}
}
