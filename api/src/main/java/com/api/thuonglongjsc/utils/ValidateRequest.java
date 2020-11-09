package com.api.thuonglongjsc.utils;

import org.springframework.stereotype.Service;

import com.api.thuonglongjsc.model.RequestMessage;
import com.api.thuonglongjsc.model.Status;



@Service
public class ValidateRequest {
	
	public Status validate(RequestMessage rq){
		
		Status status =new Status();
		status.setStatusCode(0);
		if(Utils.isNullOrEmptyObj(rq.getUsername())){
			String msg = "Username is missing";
			status.setStatusCode(Constants.ERROR_CODE.REQUEST_REQUIRED_FIELD_MISSING);
			status.setStatusDesc(msg);
			return status;
		}
		
		if(Utils.isNullOrEmptyObj(rq.getPassword())){
			String msg = "Password is missing";
			status.setStatusCode(Constants.ERROR_CODE.REQUEST_REQUIRED_FIELD_MISSING);
			status.setStatusDesc(msg);
			return status;
		}
		
		if(Utils.isNullOrEmptyObj(rq.getChannel())){
			String msg = "Channel is missing";
			status.setStatusCode(Constants.ERROR_CODE.REQUEST_REQUIRED_FIELD_MISSING);
			status.setStatusDesc(msg);
			return status;
		}
				
		return status;
	}
	



}
