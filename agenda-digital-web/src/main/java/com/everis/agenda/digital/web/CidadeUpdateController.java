package com.everis.agenda.digital.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entity.Cidade;
import com.everis.agenda.digital.web.blocks.HeadHtml;
import com.everis.agenda.digital.web.blocks.ListaCidadesHtml;

@WebServlet(name = "editar-cidade", urlPatterns = "/editar/cidade")
public class CidadeUpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private CidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Obtemos os dados da cidade a editar */
		Integer codigo = Integer.valueOf(request.getParameter("codigo"));
		String nomeCidade = request.getParameter("cidade");
		
		/* Criamos um objecto cidade com o nome de cidade recebido */
		Cidade cidadeNova = new Cidade(codigo, nomeCidade);
		
		try {
			
			/* Executamos o método update() */
			cidadeBusiness.update(cidadeNova);
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println(new HeadHtml("Cidade actualizada - Agenda Digital").getHead());
			out.println("<body>");
			out.println("<div class=\"container-fluid\">");
			
			out.println("<div class=\"row-fluid\">");
			out.println("<div class=\"span12\">");
			
			out.println("<h1>Academia Java</h1>");
			out.println("<h2>Agenda Digital</h2>");
			  
			out.println("<div class=\"alert alert-success\">");
			out.println("<p><strong>Sucesso!</strong></p>");
			out.println("<p>A cidade foi actualizada.</p>");
			out.println("</div>");
			
			out.println("</div>");
			out.println("</div>");
			
			out.println(new ListaCidadesHtml(cidadeBusiness.read()).getHtmlListaCidades());
			
			out.println("<div class=\"row-fluid\">");
			out.println("<div class=\"span12\">");
			
			out.println("<p><a class=\"btn\" href=\"/agenda-digital-web/create/cidade\">Inserir nova cidade</a></p>");
			
			out.println("</div>");
			out.println("</div>");
			
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {

			throw new ServletException(e);
		}
	}
}
