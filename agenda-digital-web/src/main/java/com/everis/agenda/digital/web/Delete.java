package com.everis.agenda.digital.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.entity.Cidade;
import com.everis.agenda.digital.web.blocks.HeadHtml;
import com.everis.agenda.digital.web.storage.Storage;

@WebServlet(name = "delete", urlPatterns = "/delete")
public class Delete extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Obt�m o nome da cidade a eliminar */
		String cidade = request.getParameter("cidade");

		Storage.apagarCidade(cidade);
		
		PrintWriter out = response.getWriter();
		out.println(new HeadHtml().getHead());
		out.println("<html>");
		out.println("<body>");
		out.println("<div class=\"container-fluid\">");
		out.println("<div clas=\"row-fluid\">");
		out.println("<div clas=\"span12\">");
		out.println("<h1>Academia Java</h1>");
		out.println("<h2>Agenda Digital</h2>");
		out.println("<h3>Listagem de Cidades</h3>");
		  
		out.println("<div class=\"alert alert-success\">");
		out.println("<p><strong>Sucesso!</strong></p>");
		out.println("<p>A cidade " + cidade + " foi eliminada</p>");
		out.println("</div>");
		
		out.println("<table class=\"table\">");
		out.println("<thead>");
		out.println("<tr><th>Codigo</th><th>Cidade</th><th></th></tr>");
		out.println("</thead>");
		out.println("<tbody>");

		for (Cidade cidadeActual : Storage.getCidades()) {
			out.println("<tr>"
							+ "<td>" + cidadeActual.getCodigo() + "</td>"
							+ "<td>"+ cidadeActual.getNome() + "</td>"
							+ "<td>"
								+ "<a style=\"margin-right: 10px;\" class=\"btn btn-small btn-success\">Editar</a>"
								+ "<a href=\"/agenda-digital-web/delete?cidade=" + cidadeActual.getNome() + "\""
										+ "class=\"btn btn-small btn-danger\">Eliminar"
								+ "</a>"
							+ "</td>"
						+ "</tr>");
		}
		
		out.println("</tbody>");
		out.println("</table>");
		
		out.println("<p><a class=\"btn\" href=\"/agenda-digital-web/create/cidade\">Inserir nova cidade</a></p>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
