package br.com.waiso.framework.view.servlets;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.waiso.framework.view.Servlet;

public abstract class AbstractServlet<T> extends Servlet<T>{
	private static final long serialVersionUID = -2279488023940997163L;

	protected abstract T executeWebClassSpring(ServletRequest request, ServletResponse response, String webClassId, String invoke);
	
	protected abstract void preExecute(ServletRequest request, ServletResponse response);
	
	protected abstract void posExecute(ServletRequest request, ServletResponse response);
}