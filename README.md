# Group9
1. Vũ Huy Kỳ 22010414 Github id: Vuhuyky
2. Đỗ Minh Nhật 22010464 Github id: MinhNhat2710

## Tiêu đề:
Ứng dụng quản lý ký túc xá

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
![z6620007013264_42ec8e3cd07be051214d0d5f5e29bc8b](https://github.com/user-attachments/assets/cdf2f69f-9bc9-4b3a-831d-cf48f73b864e)



Nội dung 03:

- Thiết kế và trình bày 3 sơ đồ Behavioural Diagram của bài tập lớn:

    + Sequence Diagram mô tả trình tự tương tác khi thêm/sửa/xoá phòng, sinh viên, hoặc khi gán sinh viên vào phòng.

    + Activity Diagram mô tả luồng xử lý nghiệp vụ chính (ví dụ: quy trình thuê phòng, trả phòng).


## Kiểm thử (Test)

Phần này hướng dẫn cách verify CRUD cho 3 đối tượng: **Student**, **Room**, **Payment**, dùng cURL (hoặc Postman).

### Môi trường chạy
- Java 11+  
- Maven: `mvn clean install`  
- Khởi động server: `mvn spring-boot:run`

---

### CRUD Student

| Method | URL                    | Body (JSON)                             | Mô tả                   |
| ------ | ---------------------- | --------------------------------------- | ----------------------- |
| POST   | `/students`            | `{ "id":"S001","fullName":"Nguyen A" }` | Tạo mới sinh viên       |
| GET    | `/students`            | —                                       | Lấy danh sách tất cả    |
| GET    | `/students/{id}`       | —                                       | Lấy sinh viên theo ID   |
| PUT    | `/students/{id}`       | `{ "fullName":"Nguyen B" }`             | Cập nhật tên sinh viên  |
| DELETE | `/students/{id}`       | —                                       | Xoá sinh viên theo ID   |

**Ví dụ cURL**:
```bash
# Tạo
curl -X POST localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{"id":"S001","fullName":"Nguyen A"}'

# Lấy all
curl localhost:8080/students

# Cập nhật
curl -X PUT localhost:8080/students/S001 \
  -H "Content-Type: application/json" \
  -d '{"fullName":"Nguyen B"}'

# Xoá
curl -X DELETE localhost:8080/students/S001
