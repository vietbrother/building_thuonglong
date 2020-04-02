package com.api.thuonglongjsc.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(Utils.class.getName());

    public static String md5Genarate(String message){
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
           
            //converting byte array to Hexadecimal String
           StringBuilder sb = new StringBuilder(2*hash.length);
           for(byte b : hash){
               sb.append(String.format("%02x", b&0xff));
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
	
   
}
