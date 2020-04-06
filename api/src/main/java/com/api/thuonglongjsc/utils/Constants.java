package com.api.thuonglongjsc.utils;

public class Constants {

	public static interface ERROR_CODE {
		public static String SUCCESS = "0";
		public static String ERROR = "1";
	}
	
	public static interface APPOVE_TYPE {
		public static String CONTRACT_CONCRETE = "1";//duyet hop dong be tong;
		public static String CALENDAR_CONCRETE = "2";//duyet lich tron be tong
		public static String CONTRACT_MATERIAL = "3";//duyet hop dong vat lieu
		public static String CONTRACT_BRICK = "4";//duyet hop dong gach
	}
}
