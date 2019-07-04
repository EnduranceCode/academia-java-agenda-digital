package com.everis.agenda.digital.web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "FiltroGlobal", urlPatterns = "/*")
public class FiltroGlobal implements Filter {
	
	private String parametrosString = "";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Map<String, String[]> parametrosMap =  request.getParameterMap();
		
		for (Map.Entry<String, String[]> valor : parametrosMap.entrySet()) {
			
			parametrosString += "Parametro: " + valor.getKey() + " - Valores: " + Arrays.toString(valor.getValue());
		}
		
		chain.doFilter(request, response);
		String uri = ((HttpServletRequest) request).getRequestURI();
		
		if (parametrosString.isEmpty()) {
			
			System.out.println("A requisição " + uri + " não inclui parametros.");
		} else {
			
			System.out.println("Os parâmetros da requisição " + uri + " são os seguintes: " + parametrosString);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
