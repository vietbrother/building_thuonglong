package com.api.thuonglongjsc.logging;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoggingService {
   private static final String REQUEST_ID = "request_id";
   private Logger log = Logger.getLogger(LoggingService.class);

   public void logRequest(HttpServletRequest httpServletRequest, Object body) throws JsonProcessingException {
       if (httpServletRequest.getRequestURI().contains("medias")) {
           return;
       }
       Object requestId = httpServletRequest.getAttribute(REQUEST_ID);
       String ip = httpServletRequest.getHeader("X-FORWARDED-FOR");
       if (ip == null) {
           ip = httpServletRequest.getRemoteAddr();
       } else {
    	   ip += " " + httpServletRequest.getRemoteAddr();
       }
       StringBuilder data = new StringBuilder();
       ObjectMapper mapper = new ObjectMapper();	
       data.append("\nLOGGING REQUEST BODY-----------------------------------\n")
       		   .append("[X-FORWARDED-FOR]: ").append(ip).append("\n")
               .append("[REQUEST-ID]: ").append(requestId).append("\n")
               .append("[BODY REQUEST]: ").append("\n")
               .append(mapper.writeValueAsString(body))
               .append("\n")
               .append("LOGGING REQUEST BODY-----------------------------------\n");

       log.info(data.toString());
   }

   public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) throws JsonProcessingException {
       if (httpServletRequest.getRequestURI().contains("medias")) {
           return;
       }
       Object requestId = httpServletRequest.getAttribute(REQUEST_ID);
       StringBuilder data = new StringBuilder();
       ObjectMapper mapper = new ObjectMapper();	
       data.append("\nLOGGING RESPONSE-----------------------------------\n")
               .append("[REQUEST-ID]: ").append(requestId).append("\n")
               .append("[BODY RESPONSE]: ").append("\n")
//               .append(mapper.writeValueAsString(body))
//               .append("\n\n")
               .append("LOGGING RESPONSE-----------------------------------\n");

       log.info(data.toString());
   }
}
