package com.api.thuonglongjsc.filter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import com.google.gson.Gson;
import com.api.thuonglongjsc.model.RequestMessage;
import com.api.thuonglongjsc.model.Status;

import com.api.thuonglongjsc.utils.GsonParserUtils;
import com.api.thuonglongjsc.utils.ValidateRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import java.lang.reflect.Type;

@ControllerAdvice
public class CustomRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {
	
	private static final Logger logger = LogManager.getLogger(CustomRequestBodyAdviceAdapter.class);

	@Autowired
	HttpServletRequest httpServletRequest;

	//@Autowired
	//private UserRepository userrepo;

	@Autowired
	ValidateRequest validateRequest;

	@Override
	public boolean supports(final MethodParameter methodParameter, final Type targetType,
			final Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		logger.info(GsonParserUtils.parseObjectToString(body));
//		RequestMessage requestMessage = new Gson().fromJson(new Gson().toJson(body), RequestMessage.class);
//		Status status = validateRequest.validate(requestMessage);
//		if (status.getStatusCode() != 0) {
//			throw new ValidationException(status.getStatusDesc());
//		}
//		Boolean ans = userrepo.validateUser(requestMessage.getUsername(), requestMessage.getPassword());
//		if (!ans) {
//			throw new ValidationException("User not authen");
//		}
		
		return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
	}


}
