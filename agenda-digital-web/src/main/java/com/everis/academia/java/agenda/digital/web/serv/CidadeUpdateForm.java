package com.everis.academia.java.agenda.digital.web.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.web.html.HeadHtml;

@WebServlet(name = "update", urlPatterns = "/update/cidade")
public class CidadeUpdateForm extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Obtemos os dados da cidade a editar */
		Integer codigo = Integer.valueOf(request.getParameter("codigo"));
		String cidade = request.getParameter("cidade");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(new HeadHtml("Editar cidade existente - Agenda Digital").getHead());
		out.println("<body>");
		out.println("<div class=\"container-fluid\">");

		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"span12\">");
		
		out.println("<h1>Academia Java</h1>");
		out.println("<h2>Agenda Digital</h2>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"offset4 span4\">");
		
		out.println("<form action=\"" + request.getContextPath() + "/editar/cidade\">");
		out.println("<fieldset>");
		out.println("<legend>Editar Cidade</legend>");
		out.println("<input type=\"hidden\" name=\"codigo\"/ value=\"" + codigo + "\">");
		out.println("<label>Cidade</label>");
		out.println("<input type=\"text\" name=\"cidade\"/ value=\"" + cidade + "\" class=\"input-xlarge\" style=\"height: 30px\" />");
		out.println("<input type=\"submit\" value=\"Enviar\"/ class=\"btn btn-primary pull-right\">");
		out.println("</fieldset>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
