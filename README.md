# Group9
1. Vũ Huy Kỳ 22010414 Github id: Vuhuyky
2. Đỗ Minh Nhật 22010464 Github id: MinhNhat2710

## Tiêu đề:
Web quản lý ký túc xá

## Readme Giới thiệu
https://vuhuyky.github.io/Group9_OOP_N02_term3_2025/

Xây dựng ứng dụng quản lý ký túc xá

Yêu cầu:

- Giao diện Java Spring Boot 

- Có chức năng quản lý các đối tượng chính trong ký túc xá như sau:

    + Thêm, sửa, xoá phòng ký túc xá.

    + Liệt kê thông tin các phòng, có thể lọc ra các phòng còn trống hoặc đã có người thuê.

- Có chức năng quản lý sinh viên:

    + Thêm, sửa, xoá thông tin sinh viên.

    + Liệt kê sinh viên, có thể lọc theo các tiêu chí như lớp, khoa, hoặc trạng thái thuê phòng.

- Có chức năng gán sinh viên vào phòng ký túc xá:

    + Khi gán cần kiểm tra phòng còn chỗ trống.

    + Quản lý trạng thái thuê phòng của sinh viên.

- Dữ liệu được lưu trữ xuống file nhị phân

    + Cần tạo các lớp liên quan đến Phòng ký túc xá (DormRoom), Sinh viên (Student), và Hợp đồng thuê phòng (RentalContract) để đọc, ghi xuống 1 hay nhiều file.

- Khi làm việc với dữ liệu trong bộ nhớ, dữ liệu cần được lưu trữ dưới dạng các Collection tùy chọn như ArrayList, LinkedList, Map,... để quản lý tập hợp đối tượng.

- Sinh viên có thể thêm các chức năng vào chương trình để ứng dụng phong phú hơn bằng cách thêm các nghiệp vụ nâng cao cho bài toán quản lý ký túc xá (tùy chọn).

Nội dung 02:

- Thiết kế và trình bày 1 sơ đồ Class Diagram của bài tập lớn, mô tả các lớp chính và mối quan hệ giữa chúng như: DormRoom, Student, RentalContract, v.v.

Nội dung 03:

- Thiết kế và trình bày 3 sơ đồ Behavioural Diagram của bài tập lớn:

    + Sequence Diagram mô tả trình tự tương tác khi thêm/sửa/xoá phòng, sinh viên, hoặc khi gán sinh viên vào phòng.

    + Activity Diagram mô tả luồng xử lý nghiệp vụ chính (ví dụ: quy trình thuê phòng, trả phòng).