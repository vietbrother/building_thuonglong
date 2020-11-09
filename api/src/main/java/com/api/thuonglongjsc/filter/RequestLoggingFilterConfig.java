package com.api.thuonglongjsc.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Configuration
@Profile("manualRegistration")
public class RequestLoggingFilterConfig {
	
	@Autowired Validator validator;
	   @Bean
	    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
	        RequestMappingHandlerAdapter requestMappingHandlerAdapter = requestMappingHandlerAdapter();
	        List<RequestBodyAdvice> requestBodyAdvices = new ArrayList<>();
	        requestBodyAdvices.add(new CustomRequestBodyAdviceAdapter());
	        requestMappingHandlerAdapter.setRequestBodyAdvice(requestBodyAdvices);

	        List<ResponseBodyAdvice<?>> responseBodyAdvices = new ArrayList<>();
	        responseBodyAdvices.add(new CustomResponseBodyAdviceAdapter());
	        requestMappingHandlerAdapter.setResponseBodyAdvice(responseBodyAdvices);

	        return requestMappingHandlerAdapter;
	    }
}
