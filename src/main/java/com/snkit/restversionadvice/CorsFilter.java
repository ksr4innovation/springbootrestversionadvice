package com.snkit.restversionadvice;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorsFilter implements Filter {

	    private static final Logger LOGGER = LoggerFactory.getLogger(CorsFilter.class);
  public CorsFilter() {
  }

  public void init(FilterConfig fc) throws ServletException {
  }

  public void destroy() {
  }

  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain) throws IOException, ServletException {

	  HttpServletRequest httpRequest = (HttpServletRequest) request;
	  HttpServletResponse r = (HttpServletResponse) response;
      String contextPath = httpRequest.getContextPath();
      String requestURI = httpRequest.getRequestURI();
      requestURI = StringUtils.substringAfter(requestURI, contextPath);
      r.addHeader("Access-Control-Allow-Origin", "*");
	  r.addHeader("Access-Control-Allow-Headers",	    			
	            "Accept,Accept-Encoding,Accept-Language,Cache-Control,Connection,Content-Length,Content-Type," +
	            "Cookie,Host,Pragma,Referer,RemoteQueueID,User-Agent,contenttype,headers");
	  r.addHeader("Access-Control-Allow-Credentials", "true");
	  r.addHeader("Access-Control-Allow-Methods", "GET,  POST");
	  
	 if (httpRequest.getMethod().equalsIgnoreCase("OPTIONS") &&   !StringUtils.equals("/", requestURI)){
		 r.setStatus(200);
		 return;
	 }else 	 {
		 chain.doFilter(request, response);
	 }
	 
  }
}
