import { StyleSheet, Dimensions, Platform } from 'react-native';

const Config = {
  navbarBackgroundColor: '#2c3e50',
  statusBarColor: '#233240',
  vnd: '\u20AB',
  title: 'Thượng Long',
  errorColor: '#c40521',
  mainColor: '#164687',
  // mainColor: '#235c8e',
  colorBold: '#365676',
  colorThin: '#3eb7e6',
  imageDefaul: '/wp-content/uploads/woocommerce-placeholder.png',

  url: 'http://103.94.18.249/jstore',
  ssl: false,
  // consumerKey: 'ck_155068b58dd6614b3ace920437df62399bb94503',
  // consumerSecret: 'cs_9fb0b186ea0024bd6d9d497715e88e43b1bf2b6e',
  consumerKey: 'ck_29b281d2af61df58dadbeead327b06dd9a53f1be',
  consumerSecret: 'cs_a6d53b6572240d483749ee0123d48c76332c0e0d',

  hotline: '1900 0091',

  bankUserName: 'Nguyễn Văn A',
  bankNumber: 'xxxxxxxxxxx',
  bankName: 'Vietcombank',
  bankDepartment: 'Đống Đa',

  goolge_vision_url : 'https://vision.googleapis.com/v1/images:annotate?key=',
  goolge_vision_key : 'AIzaSyBXBryO7MPVvhhneyQkKwW8CzfecAmpSSo', //thuclt

  postgre_api: 'http://103.94.16.226:8086/api/equipment/save',

  imageHeight: 640,
  imageWidth: 400,
  // imageWidth: 800,

  //api
  odooUrl: '103.94.16.226',
  odooPort: 8069,
  odooDb: 'plasmadb',
  odooUser: 'admin',
  odooPass: '1@',

  //title
  titleCompany : 'Plasma',
  titleCompanySub : 'MED',
  titleHome : 'Màn hình chính',
  titleMngtDevices : 'Quản lý thiết bị',
  titleMngtOrders : 'Đơn hàng',
  titleMngtCustomers : 'Khách hàng',
  titleMngtStatistics : 'Thống kê',
  titleMngtProfile : 'Tài khoản',
  titleHotline: 'Hotline :',

  titleCopyRight: 'Plasma © 2019',
  required: 'Cần nhập ',

  //button
  btnLogin: 'Đăng nhập',
  btnLogout: 'Đăng xuất',
  btnCamera: 'Chụp ảnh',
  btnScan: 'Quét thiết bị',
  btnScanContinue: 'Quét tiếp',
  btnScanMultiple: 'Xuất hàng loạt',
  btnScanMultipleManual: 'Xuất hàng loạt thủ công',
  btnAddDevice: 'Nhập thiết bị',
  btnDeviceOut: 'Xuất thiết bị',
  btnOrderOut: 'Xuất hóa đơn',
  btnCancel: 'Hủy',
  btnStop: 'Dừng',
  btnSave: 'Lưu',
  btnClose: 'Đóng',

  //success
  success: 'Thành công',

  //error
  err_login : 'Tên đăng nhập hoặc mật khẩu không đúng',
  err_add : 'Lỗi khi thêm mới! Vui lòng thử lại sau',
  err_connect : 'Lỗi kết nối',
  err_order_add : 'Lỗi khi tạo đơn hàng',
  err_number_device_over : 'Số lượng bình cần nhập đã đủ',
  err_number_device_empty : 'Chưa nhập bình',
  err_device_save : 'Lỗi khi lưu thông tin bình',
  err_device_code_required : 'Chưa nhập mã bình',
  err_device_code_not_valid : 'Mã bình phải có 6 hoặc 7 ký tự',
  err_device_code_exist : 'Mã bình đã được nhập',

  //stage
  stage0KhongXacDinh: '0',
  stage1Vo: '1',
  stage2TaiNap: '2',
  stage3BinhTon: '3',
  stage4BinhDangSuDung: '4',

  //stage
  stageName0KhongXacDinh: 'Không xác định',
  stageName1Vo: 'Vỏ',
  stageName2TaiNap: 'Đang chuyển nạp',
  stageName3BinhTon: 'Khí Argonmed',
  stageName4BinhDangSuDung: 'Xuất khí Argonmed',

  //warehouse - kho
  warehouseKhongXacDinh: '0',
  warehouseKhoCongTy: '1',
  warehouseKhoNhaMay: '2',
  warehouseKhoKhachHang: '3',

  //order
  orderType0KhongXacDinh: '0',
  orderType1ThuHoi: '1',
  orderType2XuatTaiNap: '2',
  orderType3NhapKho: '3',
  orderType4XuatChoKhach: '4',
  orderList: 'Đơn hàng',
  orderDetail: 'Thông tin đơn hàng',
  orderDate: 'Thời gian tạo',
  orderCustomer: 'Khách hàng',
  orderCode: 'Mã đơn hàng',
  orderListDevice: 'Danh sách thiết bị',
  orderNumberDevice: 'Số lượng thiết bị cần quét',
  numberDeviceScanned: 'Số lượng thiết bị đã quét',
  numberDeviceInputed: 'Số lượng thiết bị đã nhập',

  //customer
  customerList: 'Khách hàng',
  customerAddTitle: 'Thêm khách hàng',
  customerDetail: 'Thông tin khách hàng',
  customerListTitle: 'Khách hàng',
  customerName: 'Tên khách hàng',
  customerAddress: 'Địa chỉ khách hàng',

  //devices
  deviceListTitle: "Ds thiết bị",
  deviceList: "Thiết bị",
  deviceListEmpty: "Không có thiết bị",
  deviceDetail: "Thông tin thiết bị",
  deviceCode: "Mã bình",
  deviceStage: "Trạng thái",
  deviceWarehouse: "Kho",
  deviceDes: "Thông số kỹ thuật",
  deviceCustomer: "Khách hàng",

  //bill
  keyStoreOrderDeviceOut: 'ORDER_DEVICE_OUT',

  //statistic
  statisticTitle: "Thống kê",
  statisticCountStage1: "Vỏ",
  statisticCountStage2: "Đang chuyển nạp",
  statisticCountStage3: "Khí Argonmed",
  statisticCountStage4: "Xuất khí Argonmed",
  statisticCountAll: "Tổng số thiết bị",

  //stock
  stockInListStage1: "Nhập vỏ",
  stockInListStage3: "Nhập khí",
  stockOutListStage2: "Xuất vỏ",
  stockOutListStage4: "Xuất khí",

};


const IS_IOS = Platform.OS === 'ios';
const { width: viewportWidth, height: viewportHeight } = Dimensions.get('window');

function wp (percentage) {
  const value = (percentage * viewportWidth) / 100;
  return Math.round(value);
}

const slideHeight = viewportHeight * 0.36;
const slideWidth = wp(80);
const itemHorizontalMargin = wp(2);

export const sliderWidth = viewportWidth;
export const itemWidth = slideWidth + itemHorizontalMargin * 2;

const entryBorderRadius = 8;
export default Config;
