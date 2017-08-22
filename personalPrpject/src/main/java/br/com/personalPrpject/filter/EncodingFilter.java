package br.com.personalPrpject.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;
	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("text/html; charset=UTF-8");
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fc;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
