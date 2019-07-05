package com.everis.agenda.digital.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.agenda.digital.web.blocks.HeadHtml;
import com.everis.agenda.digital.web.blocks.ListaCidadesHtml;

@WebServlet(name = "read", urlPatterns = "/read")
public class CidadeReadController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(new HeadHtml("Listagem de cidades - Agenda Digital").getHead());
		out.println("<body>");
		out.println("<div class=\"container-fluid\">");
		
		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"span12\">");
		
		out.println("<h1>Academia Java</h1>");
		out.println("<h2>Agenda Digital</h2>");
		
		out.println("</div>");
		out.println("</div>");
		
		/* Listamos as cidades existentes executando o método read() */
		out.println(new ListaCidadesHtml(cidadeBusiness.read()).getHtmlListaCidades());
		
		out.println("<div class=\"container-fluid\">");
		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"span12\">");

		out.println("<p><a class=\"btn\" href=\"/agenda-digital-web/create/cidade\">Inserir nova cidade</a></p>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
