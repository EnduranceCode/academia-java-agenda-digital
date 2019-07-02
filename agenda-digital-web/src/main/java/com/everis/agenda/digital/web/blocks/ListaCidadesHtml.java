package com.everis.agenda.digital.web.blocks;

import com.everis.academia.java.agenda.digital.entity.Cidade;
import com.everis.agenda.digital.web.storage.Storage;

public class ListaCidadesHtml {
	
	private String htmlListaCidades = "";
	
	public ListaCidadesHtml() {
		super();
		this.htmlListaCidades += "<div class=\"row-fluid\">";
		this.htmlListaCidades += "<div class=\"span12\">";
		this.htmlListaCidades += "<h3>Listagem de Cidades</h3>";
		this.htmlListaCidades += "<table class=\"table\">";
		this.htmlListaCidades += "<thead>";
		this.htmlListaCidades += "<tr><th>Codigo</th><th>Cidade</th><th></th></tr>";
		this.htmlListaCidades += "</thead>";
		this.htmlListaCidades += "<tbody>";
		
		for (Cidade cidadeActual : Storage.getCidades()) {
			this.htmlListaCidades 	+= "<tr>"
									+ "<td>" + cidadeActual.getCodigo() + "</td>"
									+ "<td>" + cidadeActual.getNome() + "</td>"
									+ "<td>"
										+ "<a href=\"/agenda-digital-web/update/cidade?codigo=" + cidadeActual.getCodigo() + "&cidade=" + cidadeActual.getNome() + "\""
												+ "class=\"btn btn-small btn-success\""
												+ "style=\"margin-right: 10px\">Editar</a>"
										+ "<a href=\"/agenda-digital-web/delete?cidade=" + cidadeActual.getNome() + "\""
												+ "class=\"btn btn-small btn-danger\">Eliminar</a>"
									+ "</td>"
								+ "</tr>";
		}
		
		this.htmlListaCidades += "</tbody>";
		this.htmlListaCidades += "</table>";
		this.htmlListaCidades += "</div>";
		this.htmlListaCidades += "</div>";
	}

	public String getHtmlListaCidades() {
		
		return htmlListaCidades;
	}
}
