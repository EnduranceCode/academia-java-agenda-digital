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

@WebServlet(name = "nova-cidade", urlPatterns = "/nova-cidade")
public class NovaCidade extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Obt�m o nome da cidade inserido no formul�rio */
		String cidade = request.getParameter("cidade");
		
		/* Insere a nova cidade na lista de armazenamento*/
		Cidade cidadeNova = Storage.inserirCidade(cidade);
		
		PrintWriter out = response.getWriter();
		out.println(new HeadHtml().getHead());
		out.println("<html>");
		out.println("<html>");
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
		
		out.println("<p class=\"text-right\"><a href=\"#\">Ver todas as cidades</a><p>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}
}