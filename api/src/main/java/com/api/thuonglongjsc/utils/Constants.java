package com.api.thuonglongjsc.utils;

public class Constants {

	public static interface ERROR_CODE {
		public static String SUCCESS = "0";
		public static String ERROR = "1";
	}
	
	public static interface APPROVE_TYPE {
		public static String CONTRACT_CONCRETE = "1";//duyet hop dong be tong;
		public static String CALENDAR_CONCRETE = "2";//duyet lich tron be tong
		public static String CONTRACT_MATERIAL = "3";//duyet hop dong vat lieu
		public static String CONTRACT_BRICK = "4";//duyet hop dong gach
	}
	
	public static interface APPROVE_STATE {
		public static String NONE = "1";//chua duyet
		public static String APPROVED = "2";//da duyet
		public static String APPROVE_DELETE = "3";//duyet xoa
	}
	
	public static interface APPROVE_STATE_NAME {
		public static String NONE = "Chờ duyệt";//chua duyet
		public static String APPROVED = "Đã duyệt";//da duyet
		public static String APPROVE_DELETE = "Chờ duyệt xóa";//duyet xoa
	}
	
}
