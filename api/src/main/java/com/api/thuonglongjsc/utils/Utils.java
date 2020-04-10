package com.api.thuonglongjsc.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

		} catch (UnsupportedEncodingException ex) {
			logger.error("error: ", ex);
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
		} else if (Constants.APPROVE_STATE.NONE.equals(stateId)) {

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

}
