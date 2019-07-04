package com.everis.agenda.digital.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.agenda.digital.web.blocks.HeadHtml;
import com.everis.agenda.digital.web.blocks.ListaCidadesHtml;

@WebServlet(name = "create-cidade", urlPatterns = "/create/cidade")
public class CidadeCreateForm extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CidadeBusiness cidadeBusiness = new CidadeBusiness();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(new HeadHtml("Inserir nova cidade - Agenda Digital").getHead());

		out.println("<body>");
		out.println("<div class=\"container-fluid\">");
		
		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"span12\">");
		
		out.println("<h1>Academia Java</h1>");
		out.println("<h2>Agenda Digital</h2>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"span4 offset4\">");
		
		out.println("<form action=\"/agenda-digital-web/nova-cidade\">");
		out.println("<fieldset>");
		out.println("<legend>Inserir Cidade</legend>");
		out.println("<label>Cidade</label>");
		out.println("<input type=\"text\" name=\"cidade\" class=\"input-xlarge\" style=\"height: 30px\"/>");
		out.println("<input type=\"submit\" value=\"Enviar\"/ class=\"btn btn-primary pull-right\"/>");
		out.println("</fieldset>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println(new ListaCidadesHtml(cidadeBusiness.read()).getHtmlListaCidades());
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
