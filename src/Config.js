import {StyleSheet, Dimensions, Platform} from 'react-native';

const Config = {
    navbarBackgroundColor: '#2c3e50',
    statusBarColor: '#233240',
    vnd: '\u20AB',
    title: 'Thượng Long',
    warning: '#ffa505',
    errorColor: '#c40521',
    successColor: '#44bc37',
    mainColor: '#164687',
    // mainColor: '#235c8e',
    colorBold: '#365676',
    colorThin: '#3eb7e6',
    imageDefaul: '/wp-content/uploads/woocommerce-placeholder.png',

    api: {
        url: 'http://27.71.225.139:8080',
        apiLogin: '/api/main/v1/login',
        apiListBranch: '/api/cat/v1/chinhanh',
        apiHopDongBeTong: '/api/main/v1/hopdongbetong',
        apiLichXuatBeTong: '/api/main/v1/lichxuatbetong',
        apiGiaBanVatLieu: '/api/main/v1/giabanvatlieu',
        apiGachMenBong: '/api/main/v1/gachmenbong',
        apiGachTerrazo: '/api/main/v1/gachterrazo',
        apiGachXayDung: '/api/main/v1/gachxaydung',
        apiBricksContract: '/api/main/v1/brickscontracts',
        apiBricksTicket: '/api/main/v1/brickstickets',
        apiBricksOrders: '/api/main/v1/bricksorders',
        apiLichBanGach: '/api/main/v1/lichbangach',
        apiApprove: '/api/main/v1/approve',
        apiStatisticTotal: '/api/main/v1/statistic/sumary',
        apiStatisticDaily: '/api/main/v1/statistic/daily',
        apiStatisticBricks: '/api/main/v1/statistic/daily/bricks',
        apiStatisticDetail: '/api/main/v1/statistic/detail'
    },
    // sessionTime: 3600*24*7*1000,
    sessionTime: 3600*3*1000,
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

    goolge_vision_url: 'https://vision.googleapis.com/v1/images:annotate?key=',
    goolge_vision_key: 'AIzaSyBXBryO7MPVvhhneyQkKwW8CzfecAmpSSo', //thuclt

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
    titleCompany: 'THƯỢNG',
    titleCompanySub: 'LONG',
    titleHome: 'Màn hình chính',
    titleHopDongBeTong: 'Hợp đồng bê tông',
    titleLichXuatBeTong: 'Lịch trộn bê tông',
    titleHopDongBanNVL: 'Hợp đồng bán NVL',
    titleHopDongBanGach: 'Hợp đồng bán gạch',
    titleLichBanGach: 'Lịch bán gạch',
    titleGachMenBong: 'Hợp đồng gạch men bóng',
    titleGachTerrazo: 'Hợp đồng gạch terrazo',
    titleGachXayDung: 'Hợp đồng gạch xây dựng',
    titleReportHopDongBeTong: 'Báo cáo HĐ bê tông',

    APPROVE_TYPE: {
        CONTRACT_CONCRETE: '1',//duyet hop dong be tong,
        CALENDAR_CONCRETE: '2',//duyet lich tron be tong
        CONTRACT_MATERIAL: '3',//duyet hop dong vat lieu
        CONTRACT_BRICK_TILES: '4',//duyet hop dong gach
        CONTRACT_BRICK_TERRAZO: '5',//duyet hop dong gach
        CONTRACT_BRICK: '6',//duyet hop dong gach
        CONTRACT_BRICKS_SELL: '7',//duyet hop dong gach
        CONTRACT_BRICKS_TICKET: '8',//duyet hop dong gach
        CALENDAR_BRICK : '9',//duyet lich gach
    },

    contractConcrete: {
        title: 'Hợp đồng bê tông',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        providerName: 'Nhà cung cấp',
        projectName: 'Công trình',
        stoneType: 'Loại đá',
        subsidence: 'Độ sụt lún',
        specialRequire: 'Yêu cầu đặc biệt',
        concreteType: 'Mác bê tông',
        price: 'Giá thanh toán',
        priceBill: 'Giá hóa đơn',
        priceVAT: 'Đơn giá có thuế',
        priceNoVAT: 'Đơn giá không thuế',
        contractNumber: 'Số hợp đồng',
        planWeight: 'Khối lượng dự kiến'
    },

    calendarConcrete: {
        title: 'Lịch trộn bê tông',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        providerName: 'Nhà cung cấp',
        projectName: 'Công trình',
        stoneType: 'Loại đá',
        subsidence: 'Độ sụt lún',
        specialRequire: 'Yêu cầu đặc biệt',
        concreteType: 'Mác bê tông',
        pumpType: 'Hình thức bơm',
        employee: 'Nhân viên',
        technical: 'Kỹ thuật',
        cashier: 'Thu ngân',
        exportReal: 'Khối lượng thực xuất',
        exportPlan: 'Khối lượng đã bán',
        exportDate: 'Ngày xuất',
        exportHour: 'Giờ xuất',
        distance: 'Cự ly vận chuyển',
        contractNumber: 'Số hợp đồng',
        completeState: 'Trạng thái hoàn thành',

    },

    calendarBrick: {
        title: 'Lịch bán gạch',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        providerName: 'Nhà cung cấp',
        projectName: 'Công trình',
        subsidence: 'Hạng mục',
        materialType: 'Tên loại vật liệu',
        unit: 'Đơn vị tính',
        employee: 'Nhân viên',
        technical: 'Kỹ thuật',
        cashier: 'Thu ngân',
        exportReal: 'Số lượng thực xuất',
        exportCustomer: 'Số lượng khách hàng',
        distance: 'Cự ly vận chuyển',
        exportPlan: 'Số lượng đã bán',
        exportDate: 'Ngày xuất',
        exportHour: 'Giờ xuất',
        completeState: 'Trạng thái hoàn thành'
    },

    contractMaterial: {
        title: 'HĐ bán vật liệu',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        contractNumber: 'Số hợp đồng',
        providerName: 'Nhà cung cấp',
        projectName: 'Công trình',
        materialGroup: 'Nhóm vật liệu',
        materialType: 'Loại vật liệu',
        unit: 'Đơn vị tính',
        price: 'Giá thanh toán',
        priceBill: 'Giá hóa đơn',
        userCreate: 'Người tạo',
    },

    brickTiles: {
        title: 'HĐ gạch men bóng',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        userCreate: 'Người tạo',
        TenLoaiGach:  'Tên loại gạch',
        SoLuong:  'Số Lượng',
        GhiChu:  'Ghi chú',
        SoMeTron1:  'Số mẻ trộn 1',
        SoMeTron2:  'Số mẻ trộn',
        KLCatSongDa:  'Khối lượng cát sông Đà',
        KLBotMau:  'Khối lượng bột màu',
        KLKeoBong:  'Khối lượng keo bóng',
        KLXiMangPCB401:  'Khối lượng xi măng PCB40',
        KLCatSongDa2:  'Khối lượng cát sông Đà',
        KLXiMangPCB402:  'Khối lượng xi măng PCB40',
        KLDaMat:  'Khối lượng đá mạt',
        NgayThang: 'Ngày tháng',
    },

    brickTerrazo: {
        title: 'HĐ gạch terrazo',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        userCreate: 'Người tạo',
        TenLoaiGach: 'Tên loại gạch',
        SoLuong: 'Số lượng',
        GhiChu: 'Ghi chú',
        SoMeTron1:  'Số mẻ trộn 1',
        SoMeTron2:  'Số mẻ trộn',
        TLMauXi: 'Màu xi',
        TLMauDo: 'Màu đỏ',
        TLBotDa: 'Bột đá',
        TLDaDen2ly: 'Đá đen 2 ly',
        TLDaTrang2Ly: 'Đá trắng 2 ly',
        TLDaTrang4Ly: 'Đá trắng 2 ly',
        TLXiMangPCB401: 'Xi măng PCB401',
        TLXiMangPCB402: 'Xi măng PCB40',
        TLMatDa: 'Mạt đá',
        TLCatSongDa: 'Cát sông đà',
        NgayThang: 'Ngày tháng',
    },

    brick: {
        title: 'HĐ gạch xây dựng',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        userCreate: 'Người tạo',
        TenLoaiVatLieu: 'TenLoaiVatLieu',
        SoMeTron: 'Số mẻ trộn',
        KLXiMang: 'Xi măng',
        KLCat: 'Cát',
        KLDaMat: 'Đá mạt',
        KLVLKhac: 'Vật liệu khác',
        SoLuong: 'Số lượng',
        GhiChu: 'Ghi chú',
        NgayThang: 'Ngày tháng',
    },

    bricksContract: {
        title: 'Hợp đồng bán gạch',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        providerName: 'Nhà cung cấp',
        projectName: 'Công trình',
        numberContract: 'Số HĐ',
        materialGroup: 'Nhóm vật liệu',
        materialType: 'Loại vật liệu',
        unitType: 'Đơn vị tính',
        priceVAT: 'Đơn giá có thuế',
        priceNoVAT: 'Đơn giá không thuế',

        TenChiNhanh: 'Chi nhánh',
        NhaCungCap: 'Nhà cung cấp',
        CongTrinh: 'Công trình',
        SoHD: 'Số HĐ',
        NhomVatLieu: 'Nhóm vật liệu',
        LoaiVatLieu: 'Loại vật liệu',
        DonViTinh: 'Đơn vị tính',
        DonGiaCoThue: 'Đơn giá có thuế',
        DonGiaKhongThue: 'Đơn giá không thuế',
        TuNgay: 'Từ ngày',
        DenNgay: 'Đến ngày',

    },
    bricksTicket: {
        title: 'Phiếu bán gạch',
        detail: 'Thông tin chi tiết',
        numberTicket: 'Số phiếu',
        branch: 'Chi nhánh',
        providerName: 'Khách hàng',
        projectName: 'Công trình',
        materialGroup: 'Nhóm gạch',
        materialType: 'Loại gạch',
        unitType: 'Đơn vị tính',
        amoutOut: 'Số lượng thực xuất',
        amoutReceive: 'Số lượng khách hàng nhận',
        priceVAT: 'Đơn giá có thuế',
        priceNoVAT: 'Đơn giá không thuế',
        bill: 'Thành tiền hóa đơn',
        billNoVAT: 'Thành tiền thanh toán',

        SoPhieu: 'Số phiếu',
        TenChiNhanh: 'Chi nhánh',
        TenNhaCungCap: 'Khách hàng',
        CongTrinh: 'Công trình',
        TenNhomVatLieu: 'Nhóm gạch',
        TenLoaiVatLieu: 'Loại gạch',
        TenDonViTinh: 'Đơn vị tính',
        SoLuongThucXuat: 'Số lượng thực xuất',
        SoLuongNhan: 'Số lượng khách hàng nhận',
        DonGiaCoThue: 'Đơn giá có thuế',
        DonGiaKhongThue: 'Đơn giá không thuế',
        ThanhTienCoThue: 'Thành tiền hóa đơn',
        ThanhTienKhongThue: 'Thành tiền thanh toán',
    },
    bricksOrder: {
        title: 'Chốt bán gạch',
        detail: 'Thông tin chi tiết',
        branch: 'Chi nhánh',
        providerName: 'Nhà cung cấp',
        projectName: 'Công trình',

        NgayThang: 'Ngày tháng',
        TenChiNhanh: 'Chi nhánh',
        TenNhaCungCap: 'NCC vật liệu',
        TenNhomVatLieu: 'Nhóm vật liệu',
        TenLoaiVatLieu: 'Loại vật liệu',
        TenDonViTinh: 'ĐVT',
        TenBienSoXe: 'Biển số xe',
        TenLaiXe: 'Lái xe',
        KLBan: 'KL bán',
        KLXuatKho: 'KL xuất kho',
        KLQuanCan: 'KL qua cân',
        DonGiaCoThue: 'Hóa đơn',
        DonGiaKhongThue: 'Thanh toán',
        ThanhTienCoThue: 'Hóa đơn',
        ThanhTienKhongThue: 'Thanh toán',
        TLTong: 'TL tổng',
        TLBi: 'TL bì',
        TLHang: 'TL hàng',
        TyLeQuyDoi: 'Tỷ lệ quy đổi',

    },

    statisticDaily: {
        title: 'Báo cáo ngày',
        detail: 'Thông tin chi tiết',
        fund: 'Quỹ',
        fundTotalIn: 'Tổng Thu',
        fundTotalOut: 'Tổng Chi',
        fundLiabilitiesCollection: 'Công nợ phải thu',
        fundLiabilitiesPay: 'Công nợ phải trả',
        brick: 'Gạch',
        brickTazo3030: 'Số lượng gạch Tazo 30x30',
        brickTazo2040: 'Số lượng gạch Tazo 20x40',
        brickTazo5020: 'Số lượng gạch Tazo 50x20',
        brickUnit: 'viên',
        concrete: 'Bê tông',
        concreteOut: 'Khối lượng bê tông đã đổ',
        concreteMix: 'Khối lượng bê tông đã trộn',
        concretePlan: 'Khối lượng bê tông dự kiến đổ',
        concreteUnit: 'm3',
    },

    common: {
        fromDate: 'Từ ngày',
        toDate: 'Đến ngày',
        createDate: 'Ngày tạo',
        date: 'Ngày tháng'
    },
    state: {
        name: 'Trạng thái',
        wait: 'Chờ duyệt',
        approved: 'Đã duyệt',
        approve_delete: 'Chờ duyệt xóa',
        active: 'Đang thực hiện',
        complete: 'Đã hoàn thành',
        unComplete: 'Chưa hoàn thành',
    },
    stateCode: {
        wait: '1',
        approved: '2',
        approve_delete: '3',
        complete: '4',
        unComplete: '5',
    },
    resCode: {
        success: '0',
        false: '1',
    },
    currencyUnit: {
        thousand : 'K',
        million : 'Triệu',
        billion : 'Tỉ',
    },

    titleMngtDevices: 'Quản lý thiết bị',
    titleMngtOrders: 'Đơn hàng',
    titleMngtCustomers: 'Khách hàng',
    titleMngtStatistics: 'Thống kê',
    titleMngtProfile: 'Tài khoản',
    titleHotline: 'Hotline :',

    titleCopyRight: 'Thượng Long © 2020',
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
    btnApprove: 'Phê duyệt',
    btnComplete: 'Hoàn thành',
    btnReject: 'Từ chối',
    btnApply: 'Đồng ý',
    btnCopy: 'Sao chép',
    btnCopyAll: 'Sao chép tất cả',
    btnHide: 'Ẩn',

    //success
    success: 'Thành công',
    successApprove: 'Phê duyệt thành công',
    successComplete: 'Hoàn thành thành công',
    successCopyToClipboard: 'Đã sao chép thông tin',

    //error
    err_login: 'Tên đăng nhập hoặc mật khẩu không đúng',
    err_add: 'Lỗi khi thêm mới! Vui lòng thử lại sau',
    err_connect: 'Lỗi kết nối',
    err_order_add: 'Lỗi khi tạo đơn hàng',
    err_number_device_over: 'Số lượng bình cần nhập đã đủ',
    err_number_device_empty: 'Chưa nhập bình',
    err_device_save: 'Lỗi khi lưu thông tin bình',
    err_device_code_required: 'Chưa nhập mã bình',
    err_device_code_not_valid: 'Mã bình phải có 6 hoặc 7 ký tự',
    err_device_code_exist: 'Mã bình đã được nhập',
    err_approve: 'Phê duyệt thất bại',
    err_complete: 'Hoàn thành thất bại',
    err_no_data: 'Không có dữ liệu',

    //confirm
    confirm_title: 'Thông báo',
    confirm_approve: 'Bạn có chắc chắn phê duyệt hợp đồng này?',
    confirm_complete: 'Bạn có chắc chắn hoàn thành lịch này?',

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
    statisticTitle: "Báo cáo",
    statisticCountStage1: "Vỏ",
    statisticCountStage2: "Đang chuyển nạp",
    statisticCountStage3: "Khí Argonmed",
    statisticCountStage4: "Xuất khí Argonmed",
    statisticCountAll: "Tổng số thiết bị",


};


const IS_IOS = Platform.OS === 'ios';
const {width: viewportWidth, height: viewportHeight} = Dimensions.get('window');

function wp(percentage) {
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
