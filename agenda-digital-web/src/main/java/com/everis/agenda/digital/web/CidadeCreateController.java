package com.everis.agenda.digital.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;
import com.everis.agenda.digital.web.blocks.HeadHtml;

@WebServlet(name = "nova-cidade", urlPatterns = "/nova-cidade")
public class CidadeCreateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Obtemos o nome da cidade inserido no formulário */
		String nomeCidade = request.getParameter("cidade");
		
		/* Criamos um objecto cidade com o nome de cidade recebido */
		Cidade cidadeNova = new Cidade();
		cidadeNova.setNome(nomeCidade);
		
		try {
			
			/* Criamos um novo objecto cidade com os dados recebidos */
			cidadeNova = cidadeBusiness.create(cidadeNova);
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println(new HeadHtml("Inserida nova cidade - Agenda Digital").getHead());
			out.println("<body>");
			out.println("<div class=\"container-fluid\">");
			
			out.println("<div clas=\"row-fluid\">");
			out.println("<div clas=\"span12\">");
			out.println("<h1>Academia Java</h1>");
			out.println("<h2>Agenda Digital</h2>");
			out.println("<h3>Cidade Inserida</h3>");
			
			out.println("<table class=\"table\">");
			out.println("<thead>");
			out.println("<tr><th>Codigo</th><th>Cidade</th></tr>");
			out.println("</thead>");
			out.println("<tbody>");
			out.println("<tr><td>" + cidadeNova.getCodigo() + "</td><td>"+ cidadeNova.getNome() + "</td></tr>");
			out.println("</tbody>");
			out.println("</table>");
			
			out.println("<p>"
							+ "<a href=\"/agenda-digital-web/create/cidade\""
								+ "class=\"btn\" style=\"margin-right: 10px;\">Inserir nova cidade"
								+ "</a>"
							+ "<a href=\"/agenda-digital-web/read\""
								+ "class=\"btn btn-primary\">Ver todas as cidades"
							+ "</a>"
						+ "</p>");
			
			out.println("</div>");
			out.println("</div>");
			
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (BusinessException e) {
			
			throw new ServletException(e);
		} catch (Exception e) {
			
			throw new ServletException(e);
		}
	}
}