package com.everis.agenda.digital.web.blocks;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.everis.academia.java.agenda.digital.entity.Cidade;

public class ListaCidadesHtml {
	
	private String htmlListaCidades = "";
	
	public ListaCidadesHtml(Collection<Cidade> cidades, HttpServletRequest request) {
		super();
		this.htmlListaCidades += "<div class=\"row-fluid\">";
		this.htmlListaCidades += "<div class=\"span12\">";
		this.htmlListaCidades += "<h3>Listagem de Cidades</h3>";
		this.htmlListaCidades += "<table class=\"table\">";
		this.htmlListaCidades += "<thead>";
		this.htmlListaCidades += "<tr><th>Codigo</th><th>Cidade</th><th></th></tr>";
		this.htmlListaCidades += "</thead>";
		this.htmlListaCidades += "<tbody>";
		
		for (Cidade cidadeActual : cidades) {
			this.htmlListaCidades 	+= "<tr>"
									+ "<td>" + cidadeActual.getCodigo() + "</td>"
									+ "<td>" + cidadeActual.getNome() + "</td>"
									+ "<td>"
										+ "<a href=\"" + request.getContextPath() + "/jsp/cidade/update.jsp?codigo=" + cidadeActual.getCodigo() + "&cidade=" + cidadeActual.getNome() + "\""
												+ "class=\"btn btn-small btn-success\""
												+ "style=\"margin-right: 10px\">Editar</a>"
										+ "<a href=\"" + request.getContextPath() + "/delete?codigo=" + cidadeActual.getCodigo() + "\""
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
