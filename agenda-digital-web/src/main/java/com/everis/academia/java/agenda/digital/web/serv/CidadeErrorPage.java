package com.everis.academia.java.agenda.digital.web.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.agenda.digital.web.blocks.HeadHtml;

@WebServlet(name = "error-cidade", urlPatterns = "/error/cidade")
public class CidadeErrorPage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(new HeadHtml(exception.getLocalizedMessage() + " - Agenda Digital").getHead());
		out.println("<body>");
		out.println("<div class=\"container-fluid\">");
		
		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"span12\">");
		
		out.println("<h1>Academia Java</h1>");
		out.println("<h2>Agenda Digital</h2>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"offset3 span6\">");
		  
		out.println("<div class=\"alert alert-danger\">");
		out.println("<p><strong>Ocorreu um erro!</strong></p>");
		out.println("<p>" + exception.getLocalizedMessage() + "</p>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class=\"row-fluid\">");
		out.println("<div class=\"offset4 span4\">");
		
		out.println("<p>"
				+ "<a href=\"/agenda-digital-web/create/cidade\""
					+ "class=\"btn\" style=\"margin-right: 10px;\">Inserir nova cidade"
					+ "</a>"
				+ "<a href=\"/agenda-digital-web/read\""
					+ "class=\"btn btn-primary pull-right\">Ver todas as cidades"
				+ "</a>"
			+ "</p>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	
}
