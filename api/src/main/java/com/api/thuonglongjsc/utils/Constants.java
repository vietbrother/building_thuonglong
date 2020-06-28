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
		public static String CONTRACT_BRICK_TILES = "4";//duyet dong gach men bong
		public static String CONTRACT_BRICK_TERRAZO = "5";//duyet hop dong gach terrazo
		public static String CONTRACT_BRICK = "6";//duyet hop dong gach xay dung
		public static String CONTRACT_BRICK_SELL = "7";//duyet hop dong ban gach
		public static String CONTRACT_BRICK_TICKET = "8";//duyet phieu ban gach
		public static String CALENDAR_BRICK = "9";//duyet lich ban gach
	}
	
	public static interface APPROVE_STATE {
		public static String NONE = "1";//chua duyet
		public static String APPROVED = "2";//da duyet
		public static String APPROVE_DELETE = "3";//cho duyet xoa
		public static String COMPLETE = "4";//hoan thanh
		public static String UN_COMPLETE = "5";//chua hoan thanh
	}
	
	public static interface APPROVE_STATE_NAME {
		public static String NONE = "Chờ duyệt";//chua duyet
		public static String APPROVED = "Đã duyệt";//da duyet
		public static String APPROVE_DELETE = "Chờ duyệt xóa";//duyet xoa
		public static String COMPLETE = "Đã hoàn thành";//hoan thanh
		public static String UN_COMPLETE = "Chưa hoàn thành";//hoan thanh
	}
	
}
