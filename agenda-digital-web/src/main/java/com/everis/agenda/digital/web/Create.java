package com.everis.agenda.digital.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.agenda.digital.web.blocks.HeadHtml;

@WebServlet(name = "create-cidade", urlPatterns = "/create/cidade")
public class Create extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println(new HeadHtml().getHead());
		out.println("<html>");
		out.println("<body>");
		out.println("<div class=\"container-fluid\">");
		out.println("<div clas=\"row-fluid\">");
		out.println("<div clas=\"span12\">");
		out.println("<h1>Academia Java</h1>");
		out.println("<h2>Agenda Digital</h2>");
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div clas=\"row-fluid\">");
		out.println("<div clas=\"offset4 span8\">");
		out.println("<form action=\"/agenda-digital-web/nova-cidade\">");
		out.println("<fieldset>");
		out.println("<legend>Inserir Cidade</legend>");
		out.println("<label>Cidade</label>");
		out.println("<input type=\"text\" name=\"cidade\"/>");
		out.println("<input type=\"submit\" value=\"Enviar\"/>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
