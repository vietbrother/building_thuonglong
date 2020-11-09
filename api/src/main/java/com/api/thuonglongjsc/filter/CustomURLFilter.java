package com.api.thuonglongjsc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

@Component
@Order(1)
public class CustomURLFilter implements Filter {

	   private static final String REQUEST_ID = "request_id";
	   private static final Logger logger = LogManager.getLogger(CustomURLFilter.class);
	   @Override
	   public void init(FilterConfig filterConfig) throws ServletException {

	   }

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		long lStartTime = System.currentTimeMillis();
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		String ndc = req.getHeader("NDC");
		if (ndc == null) {
			ndc = UUID.randomUUID().toString();
		}
		ThreadContext.push("HttpMsgAdaptor/" + ndc);
		
		 String remoteAddr = getClientIpAddress(req);// req.getHeader("C-FORWARDED-XES");
         if (remoteAddr != null && !"".equals(remoteAddr)) {
       	  logger.info("Forward IP is "+remoteAddr);
         }
         remoteAddr = req.getRemoteAddr();
         if (remoteAddr != null && !"".equals(remoteAddr)) {
       	  logger.info("Direct IP is "+remoteAddr);
         }
		
		filterChain.doFilter(servletRequest, servletResponse);
		long lEndTime = System.currentTimeMillis();
		long output = lEndTime - lStartTime;
		String path = req.getRequestURI();
		logger.info("Elapsed time in milliseconds of "+ path+" : " + output);
		ThreadContext.pop();
        ThreadContext.clearAll();
	}

	   @Override
	   public void destroy() {

	   }

	   private void logRequest(HttpServletRequest request, String requestId) {
	       if (request != null) {
	           StringBuilder data = new StringBuilder();
	           data.append("\nLOGGING REQUEST-----------------------------------\n")
	                   .append("[REQUEST-ID]: ").append(requestId).append("\n")
	                   .append("[PATH]: ").append(request.getRequestURI()).append("\n")
	                   .append("[QUERIES]: ").append(request.getQueryString()).append("\n")
	                   .append("[IPSOURCE]: ").append(getClientIpAddress(request)).append("\n")
	                   .append("[HEADERS]: ").append("\n");

	           Enumeration headerNames = request.getHeaderNames();
	           while (headerNames.hasMoreElements()) {
	               String key = (String) headerNames.nextElement();
	               String value = request.getHeader(key);
	               data.append("---").append(key).append(" : ").append(value).append("\n");
	           }
	           data.append("LOGGING REQUEST-----------------------------------\n");
	           logger.info(data.toString());
//	           System.out.println(data.toString());
	       }
	   }
	   
	   private static final String[] HEADERS_TO_TRY = {
	            "X-Forwarded-For",
	            "Proxy-Client-IP",
	            "WL-Proxy-Client-IP",
	            "HTTP_X_FORWARDED_FOR",
	            "HTTP_X_FORWARDED",
	            "HTTP_X_CLUSTER_CLIENT_IP",
	            "HTTP_CLIENT_IP",
	            "HTTP_FORWARDED_FOR",
	            "HTTP_FORWARDED",
	            "HTTP_VIA",
	            "REMOTE_ADDR" };

	private String getClientIpAddress(HttpServletRequest request) {
	    for (String header : HEADERS_TO_TRY) {
	        String ip = request.getHeader(header);
	        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	    }

	    return request.getRemoteAddr();
	}

}
