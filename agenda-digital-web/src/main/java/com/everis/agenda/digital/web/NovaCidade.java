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
		
		/* Obtêm o nome da cidade inserido no formulário */
		String cidade = request.getParameter("cidade");
		
		/* Valida os dados recebidos*/
		Storage.validarCidade(cidade);
		
		/* Insere a nova cidade na lista de armazenamento*/
		Cidade cidadeNova = Storage.inserirCidade(cidade);
		
		PrintWriter out = response.getWriter();
		out.println(new HeadHtml().getHead());
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
		
		out.println("<p><a class=\"btn\" style=\"margin-right: 10px;\" href=\"/agenda-digital-web/create\">Inserir nova cidade</a><a class=\"btn btn-primary\" href=\"/agenda-digital-web/read\">Ver todas as cidades</a></p>");
		
		out.println("</div>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
