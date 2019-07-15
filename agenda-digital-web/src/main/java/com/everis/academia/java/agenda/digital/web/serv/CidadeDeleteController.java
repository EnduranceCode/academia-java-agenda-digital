package com.everis.academia.java.agenda.digital.web.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.agenda.digital.business.BusinessException;
import com.everis.academia.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.agenda.digital.business.inter.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.web.html.HeadHtml;
import com.everis.academia.java.agenda.digital.web.html.ListaCidadesHtml;

@WebServlet(name = "delete", urlPatterns = "/delete")
public class CidadeDeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	/* Instanciamos um novo objecto CidadeBusiness */
	private ICidadeBusiness cidadeBusiness = new CidadeBusiness();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Obtemos o código da cidade a eliminar */
		Integer codigo = Integer.valueOf(request.getParameter("codigo"));
		
		/* Executamos o método delete() para eliminar a cidade com o código recebido*/
		try {
			
			cidadeBusiness.delete(codigo);

			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println(new HeadHtml("Cidade eliminada - Agenda Digital").getHead());
			out.println("<body>");
			out.println("<div class=\"container-fluid\">");
			
			out.println("<div class=\"row-fluid\">");
			out.println("<div class=\"span12\">");
			out.println("<h1>Academia Java</h1>");
			out.println("<h2>Agenda Digital</h2>");
			  
			out.println("<div class=\"alert alert-success\">");
			out.println("<p><strong>Sucesso!</strong></p>");
			out.println("<p>A cidade foi eliminada</p>");
			out.println("</div>");
			
			out.println("</div>");
			out.println("</div>");
			
			out.println(new ListaCidadesHtml(cidadeBusiness.read(), request).getHtmlListaCidades());
			
			out.println("<div class=\"row-fluid\">");
			out.println("<div class=\"span12\">");
			
			out.println("<p><a class=\"btn\" href=\"" + request.getContextPath() + "/create/cidade\">Inserir nova cidade</a></p>");
			
			out.println("</div>");
			out.println("</div>");
			
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} catch (BusinessException e) {
			
			throw new ServletException(e);
		}
	}
}
