package com.api.thuonglongjsc.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.thuonglongjsc.dto.GiaBanVatLieu;
import com.api.thuonglongjsc.dto.ResultDTO;

public class Utils {

	private static final Logger logger = LoggerFactory.getLogger(Utils.class.getName());

	public static String md5Genarate(String message) {
		String digest = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(message.getBytes("UTF-8"));

			// converting byte array to Hexadecimal String
			StringBuilder sb = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				sb.append(String.format("%02x", b & 0xff));
			}

			digest = sb.toString();
			
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			Charset UTF_8 = StandardCharsets.UTF_8;
//			byte[] md5InBytes = md.digest(message.getBytes(UTF_8));
//			StringBuilder sb = new StringBuilder();
//	        for (byte b : md5InBytes) {
//	            sb.append(String.format("%02x", b));
//	        }
//	        digest = sb.toString();
//	        System.out.println(sb.toString());
	        
//			MessageDigest md = MessageDigest.getInstance("MD5");
//		    md.update(message.getBytes());
//		    byte[] hash = md.digest();
//		    digest = DatatypeConverter
//		      .printHexBinary(hash).toUpperCase();

		} catch (NoSuchAlgorithmException ex) {
			logger.error("error: ", ex);
		} catch (Exception ex) {
			logger.error("error: ", ex);
		}
		return digest;
	}

	public static boolean isNullOrEmptyObj(Object str) {
		return (str == null || str.toString().isEmpty());
	}

	public static boolean isNullOrEmpty(String str) {
		return (str == null || str.isEmpty() || "null".equals(str));
	}

	public static ResultDTO switchApproveState(String stateId) {
		ResultDTO newState = new ResultDTO();
		if (Constants.APPROVE_STATE.NONE.equals(stateId)) {
			newState.setCode(Constants.APPROVE_STATE.APPROVED);
			newState.setMessage(Constants.APPROVE_STATE_NAME.APPROVED);
		} else if (Constants.APPROVE_STATE.APPROVED.equals(stateId)) {
			newState.setCode(Constants.APPROVE_STATE.NONE);
			newState.setMessage(Constants.APPROVE_STATE_NAME.NONE);
		} else if (Constants.APPROVE_STATE.APPROVE_DELETE.equals(stateId)) {
			
		} else if (Constants.APPROVE_STATE.COMPLETE.equals(stateId)) {
			newState.setCode(Constants.APPROVE_STATE.COMPLETE);
			newState.setMessage(Constants.APPROVE_STATE_NAME.COMPLETE);
		} else if (Constants.APPROVE_STATE.UN_COMPLETE.equals(stateId)) {
			newState.setCode(Constants.APPROVE_STATE.UN_COMPLETE);
			newState.setMessage(Constants.APPROVE_STATE_NAME.UN_COMPLETE);
		}
		return newState;
	}

	public static Object cashObject(Object object, Object[] data) {
		Field[] attributes = object.getClass().getDeclaredFields();
		for (int i = 0; i < attributes.length; i++) {
			try {
				Field field = attributes[i];
				field.setAccessible(true);
				field.set(object, data[i]);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return object;
	}

	public static String formatStr(String oldStr) {
		String newStr = "";
		if(oldStr != null && !"".equals(oldStr)) {
			newStr = oldStr.replaceAll("\\<.*?\\>", "");
			newStr = newStr.replaceAll("- ", "");
		}
		return newStr;
	}
}
