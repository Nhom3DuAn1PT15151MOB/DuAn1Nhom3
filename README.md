
FPT POLYTECHNIC

DỰ ÁN 1

NGÀNH LẬP TRÌNH MÁY TÍNH (LẬP TRÌNH MOBILE)



HÀ NỘI 2020


 
MỤC LỤC
1	Phân tích	2
1.1	Hiện trạng	2
1.2	Yêu cầu hệ thống	2
1.3	Use case	2
2	Thiết kế	2
2.1	Mô hình triển khai	2
2.2	Thiết kế CSDL	2
2.2.1	Sơ đồ quan hệ thực thể	2
2.2.2	Thiết kế chi tiết các thực thể	2
2.3	Thiết kế giao diện	2
2.3.1	Sơ đồ tổ chức giao diện	2
2.3.2	Thiết kế giao diện cho các chức năng nghiệp vụ	2
3	Thực hiện viết mã	2
3.1	Viết mã tạo CSDL	2
3.1.1	Tạo CSDL	2
3.1.2	SQL truy vấn và thao tác	2
3.1.3	Các thủ tục lưu tổng hợp thống kê	2
3.2	Lập trình JDBC	3
3.2.1	Lớp hỗ trợ	3
3.2.2	Model class - Các lớp mô tả dữ liệu	3
3.2.3	DAO Class - Các lớp truy xuất dữ liệu	3
3.3	Viết mã cho ứng dụng	3
3.3.1	Xử lý Form X	3
3.3.2	Xử lý Form Y	3
4	Kiểm thử	3
4.1	Kiểm thử form X	3
4.2	Kiểm thử form Y	3
5	Đóng gói và triển khai	3
5.1	Hướng dẫn chuyển đổi jar thành exe	3
5.2	Hướng dẫn cài đặt triển khai	3
5.3	Hướng dẫn sử dụng phần mềm	3

1	PHÂN TÍCH
1.1	HIỆN TRẠNG
•	Một kho gạo lớn tại Hà Nội chuyên cung cấp một lượng gạo lớn ra thị trường tiêu thụ, hàng hóa nhiều khiến cho việc quản lý kho, nhân viên trong kho và ghi chép sổ sách trở nên phức tạp, khó quản lý dữ liệu, tốn thời gian thống kê và sai sót nhiều. Vì vậy để quản lý một lượng hàng rất lớn, cửa hàng cần có một phần mềm quản lý chung, quản lý kho bãi giúp doanh nghiệp dễ dàng nắm bắt được thông tin về hàng hóa, vật tư, nguyên vật liệu và sản phẩm một cách chính xác kịp thời ngay trên chiếc điện thoại thông minh của mình. Từ đó, người quản lý doanh nghiệp có thể đề ra các kế hoạch và quyết định đúng đắn, giảm chi phí và tăng khả năng cạnh tranh, nâng cao kết quả hoạt động sản xuất kinh doanh, kiểm soát số lượng gạo, loại gạo, xuất và nhập gạo trong kho để đưa ra báo cáo và thống kê các loại gạo bán chạy và tồn kho.
•	Ứng dụng đơn giản hóa việc nhập liệu các con số về giá cả và số lượng. Giúp người dùng sử dụng không cầu kì mất thời gian trên sổ sách, dữ liệu được lưu trữ trên server để có thể truy cập và bảo toàn dữ liệu dễ dàng
•	Chương trình sẽ cung cấp cho người dùng những kiến thức, kỹ thuật và công cụ hữu dụng trong việc tổ chức, thiết kế, vận hành kho hàng một cách khoa học nhất, đảm bảo dòng lưu thông hàng hoá hiệu quả đem lại hiệu quả tối ưu cho doanh nghiệp
1.2	YÊU CẦU HỆ THỐNG
•	Chạy trên hệ điều hành android
•	Có sử dụng mạng để truy cập để lưu trữ được dữ liệu với server.
•	Quản lý tất các các thể loại gạo trong kho bao gồm nhập và xuất
•	Quản lý số lượng gạo tồn kho và phân loại theo loại gạo, hạn sử dụng
•	Quản lý các hóa đơn xuất và nhập gạo.
•	Thống kê doanh số và số lượng gạo bán được bán ra và nhập vào theo tháng.
•	Để truy cập ứng dụng người dùng cần phải đăng nhập







1.3	USE CASE

























2	THIẾT KẾ
2.1	MÔ HÌNH TRIỂN KHAI
 
2.2	THIẾT KẾ CSDL
2.2.1	Sơ đồ quan hệ thực thể

 
2.2.2	Thiết kế chi tiết các thực thể

TheLoai	Kiểu	Ràng Buộc
MaLoaiGao	VARCHAR(225)	PK
TenLoaiGao	VARCHAR(255)	

Gao	Kiểu	Ràng Buộc
MaGao	VARCHAR(225)	PK
MaLoaiGao	VARCHAR(255)	FK
TenGao	VARCHAR(255)	
GiaNhap	DOUBLE	
NgayNhap	DATE	
HanSuDung	DATE	

GaoNhap	Kiểu	Ràng Buộc
MaGao	VARCHAR(225)	FK
MaLoaiGao	VARCHAR(255)	FK
TenGao	VARCHAR(255)	
GiaNhap	DOUBLE	
NgayNhap	DATE	
HanSuDung	DATE	

GaoXuat	Kiểu	Ràng Buộc
MaGao	VARCHAR(255)	FK
TenGao	VARCHAR(255)	
GiaXuat	DOUBLE	

HoaDon	Kiểu	Ràng Buộc
MaGao	VARCHAR(255)	FK
MaHoaDon	VARCHAR(255)	PK
LoaiHoaDon	VARCHAR(225)	
Ngay	DATE	
SoLuongGao	DOUBLE	
ThanhTien	DOUBLE	


2.3	THIẾT KẾ GIAO DIỆN

 



 


 
2.3.1	Sơ đồ tổ chức giao diện
2.3.2	Thiết kế giao diện cho các chức năng nghiệp vụ
2.3.2.1	Thiết kế Form X
2.3.2.2	Thiết kế Form Y
3	THỰC HIỆN VIẾT MÃ
3.1	VIẾT MÃ TẠO CSDL
3.1.1	Tạo CSDL
3.1.2	SQL truy vấn và thao tác
3.1.2.1	SQL đối với Bảng 1
3.1.2.2	SQL đối với Bảng 2
3.1.3	Các thủ tục lưu tổng hợp thống kê
3.1.3.1	Procedure 1
3.1.3.2	Procedure 2
3.2	LẬP TRÌNH JDBC
3.2.1	Lớp hỗ trợ
3.2.1.1	Lớp tiện ích X
3.2.1.2	Lớp tiện ích Y
3.2.2	Model class - Các lớp mô tả dữ liệu
3.2.2.1	Model 1
3.2.2.2	Model 2
3.2.3	DAO Class - Các lớp truy xuất dữ liệu
3.2.3.1	Lớp DAO làm việc với Bảng 1
3.2.3.2	Lớp DAO làm việc với Bảng 2
3.3	VIẾT MÃ CHO ỨNG DỤNG
3.3.1	Xử lý Form X
3.3.2	Xử lý Form Y
4	KIỂM THỬ
4.1	KIỂM THỬ FORM X
4.2	KIỂM THỬ FORM Y
5	ĐÓNG GÓI VÀ TRIỂN KHAI
5.1	HƯỚNG DẪN CHUYỂN ĐỔI JAR THÀNH EXE
5.2	HƯỚNG DẪN CÀI ĐẶT TRIỂN KHAI
5.3	HƯỚNG DẪN SỬ DỤNG PHẦN MỀM

