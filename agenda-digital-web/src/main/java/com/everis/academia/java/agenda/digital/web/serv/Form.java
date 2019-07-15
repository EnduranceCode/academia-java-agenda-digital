package com.everis.academia.java.agenda.digital.web.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "form", urlPatterns = "/form")
public class Form extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=\"controller\">");
		out.println("<table border=\"1\">");
		out.println("<tr><td colspan=\"2\">Formul�rio</td></tr>");
		out.println("<tr><td>Nome</td><td><input type=\"text\" name=\"nome\"/></td></tr>");
		out.println("<tr><td>Idade</td><td><input type=\"text\" name=\"idade\"/></td></tr>");
		out.println("<tr><td>Sal�rio</td><td><input type=\"text\" name=\"salario\"/></td></tr>");
		out.println("<tr><td colspan=\"2\" align=\"center\">");
		out.println("<input type=\"submit\" value=\"Enviar\"/>");
		out.println("<input type=\"reset\" name=\"limpar\"/>");
		out.println("</td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
