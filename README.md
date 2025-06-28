# Group9
1. Vũ Huy Kỳ 22010414 Github id: Vuhuyky
2. Đỗ Minh Nhật 22010464 Github id: MinhNhat2710

## Readme Giới thiệu
https://vuhuyky.github.io/Group9_OOP_N02_term3_2025/

Xây dựng ứng dụng quản lý ký túc xá

#### Yêu cầu 2:
## 1. Tiêu đề
**Xây dựng ứng dụng quản lý ký túc xá**

---

## 2. Phân tích đối tượng chính
- **Sinh viên (Student):**  
  Quản lý thông tin cá nhân, mã số, lớp, liên hệ, phòng ở.
- **Phòng ký túc xá (DormRoom):**  
  Quản lý mã phòng, loại phòng, số lượng tối đa, số lượng hiện tại, trạng thái phòng.
- **Hợp đồng thuê phòng (RentalContract):**  
  Quản lý mã hợp đồng, sinh viên thuê, phòng, ngày bắt đầu, ngày kết thúc, trạng thái hợp đồng.

---

## 3. Cấu trúc thư mục project
Theo code trong src ở trên

---

## 4. Các class chính

- **Student.java**
- **DormRoom.java**
- **RentalContract.java**

---

## 5. Các class kiểm định (test)

- **StudentTest.java**
- **DormRoomTest.java**
- **RentalContractTest.java**

---

#### Yêu cầu 3:

- Giao diện Java Spring Boot 

1. **Có chức năng qquản lý phòng ký túc xá**
   - Thêm, sửa, xoá phòng.
   - Liệt kê thông tin phòng.
   - Lọc phòng còn trống hoặc đã thuê.

2. **Có chức năng qquản lý sinh viên**
   - Thêm, sửa, xoá thông tin sinh viên.
   - Liệt kê sinh viên.
   - Lọc sinh viên theo lớp, khoa, trạng thái thuê phòng.

3. **Có chức năng quản lý hợp đồng thuê phòng**
   - Gán sinh viên vào phòng.
   - Kiểm tra phòng còn chỗ trống.
   - Quản lý trạng thái thuê phòng của sinh viên.

- Dữ liệu được lưu trữ xuống file nhị phân

    + Cần tạo các lớp liên quan đến Phòng ký túc xá (DormRoom), Sinh viên (Student), và Hợp đồng thuê phòng (RentalContract) để đọc, ghi xuống 1 hay nhiều file.

- Khi làm việc với dữ liệu trong bộ nhớ, dữ liệu cần được lưu trữ dưới dạng các Collection tùy chọn như ArrayList, LinkedList, Map,... để quản lý tập hợp đối tượng.

- Sinh viên có thể thêm các chức năng vào chương trình để ứng dụng phong phú hơn bằng cách thêm các nghiệp vụ nâng cao cho bài toán quản lý ký túc xá (tùy chọn).

Nội dung 02:
Sơ đồ Class Diagram
![image](https://github.com/user-attachments/assets/71143f92-4b96-4250-b912-a01a65aeb5b8)

Nội dung 03:

**Sequence them phong**
![sequence them phong](https://github.com/user-attachments/assets/73e63c83-b0f5-406a-8375-1ccb4821c393)
**Sequence hop dong**
![sequence hopdong](https://github.com/user-attachments/assets/815d8e56-9648-424a-9f67-9c36f2773447)
**Sequence gan sinh vien**
![sequence gánv](https://github.com/user-attachments/assets/e612bfaa-0a92-427f-9647-443ee1de42eb)


## Giai đoạn phát triển CRUD Java thuần (trước khi chuyển sang Spring Boot)

### 1. Thực hiện CRUD cho ít nhất 03 đối tượng

Ở phiên bản đầu tiên (Java console), nhóm đã xây dựng chức năng CRUD cho 3 đối tượng chính:
- Sinh viên (Student)
- Phòng ký túc xá (DormRoom)
- Hợp đồng thuê phòng (RentalContract)

### 2. Tái sử dụng code CRUD cho n đối tượng

Để tránh lặp lại code, nhóm đã thiết kế một class CRUD tổng quát sử dụng generic (hoặc interface chung), cho phép thực hiện các thao tác CRUD (thêm, sửa, xóa, tìm kiếm, liệt kê) cho nhiều đối tượng khác nhau chỉ với một lần cài đặt.

### 3. Kiểm thử CRUD cho n đối tượng

Nhóm đã kiểm thử các thao tác CRUD cho từng đối tượng bằng các class kiểm thử riêng biệt (ví dụ: StudentTest, DormRoomTest, RentalContractTest) để đảm bảo tính đúng đắn của các thao tác.
![image](https://github.com/user-attachments/assets/b9e53d7d-fbec-4e03-b86c-7cd660f7656e)
![image](https://github.com/user-attachments/assets/cbbd1796-580a-46c4-8275-71bbe990aee2)

> **Lưu ý:**  
> Toàn bộ mã nguồn của giai đoạn này được lưu trong nhánh "Nhat" của repo.  
> Sau khi hoàn thiện, nhóm đã chuyển sang phát triển ứng dụng web với Spring Boot ở các giai đoạn tiếp theo.


#### Yêu cầu 4:
## 1. Ba phương thức chính

1. Hiển thị và lọc danh sách sinh viên
2. Kiểm tra tình trạng phòng ký túc xá
3. Thêm mới hợp đồng thuê phòng cho sinh viên
## Câu 2. Phân công và hiện thực phương thức
Thành viên 1: Đỗ Minh Nhật  
Phương thức lựa chọn: Hiển thị và lọc danh sách sinh viên  
Mô tả:  
Phương thức này lấy danh sách sinh viên từ hệ thống, cho phép lọc theo lớp, khoa, trạng thái thuê phòng. Kết quả được hiển thị trên giao diện web.  
![Screenshot 2025-06-28 135822](https://github.com/user-attachments/assets/b9671584-9b1f-4385-a37b-e0a47e9bdc51)
![Screenshot 2025-06-28 135850](https://github.com/user-attachments/assets/4747cd9c-c6c7-485d-b7cc-fa87507b78ef)

Thành viên 2: Vũ Huy Kỳ  
Phương thức lựa chọn: Thêm mới hợp đồng thuê phòng cho sinh viên  
Mô tả:  
Phương thức này cho phép quản trị viên thêm sinh viên vào phòng  
![Screenshot 2025-06-28 140837](https://github.com/user-attachments/assets/b23aa6a4-7f60-4662-b03a-c5587d8a3fb9)  
![Screenshot 2025-06-28 140927](https://github.com/user-attachments/assets/9b53e1ca-937a-4ff1-bfb3-53112fd9b566)  


#### Yêu cầu 5:
## Lưu đồ thuật toán
![image](https://github.com/user-attachments/assets/5b72f3c3-d2f1-47b0-997e-f9ac496ccb22)

Câu 1: Chức năng chính của nhóm  
Chức năng chính:  
Quản lý hợp đồng thuê phòng ký túc xá cho sinh viên  

Phân tích chức năng thành các bước nhỏ:  
- Lọc danh sách sinh viên chưa thuê phòng  
- Hiển thị danh sách sinh viên có trạng thái "Chưa thuê" trên giao diện quản lý sinh viên.  
- Chọn phòng trong quản lý phòng, kiểm tra phòng còn chỗ trống  
- Tạo hợp đồng thuê phòng mới cho sinh viên  
- Chọn sinh viên chưa thuê, chọn phòng còn chỗ, tạo hợp đồng và cập nhật trạng thái phòng, sinh viên.  

Phân chia chức năng nhỏ cho các thành viên:  
- Đỗ Minh Nhật: Xây dựng chức năng lọc sinh viên chưa thuê phòng.  
- Vũ Huy Kỳ: Xây dựng chức năng kiểm tra phòng còn chỗ trống và tạo hợp đồng thuê phòng mới.  
- Cả nhóm: Gọi các chức năng con tạo thành chức năng chính.  


Câu 2: Mỗi thành viên thực hiện 1 phương thức nhỏ  
1. Đỗ Minh Nhật:  Lọc danh sách sinh viên chưa thuê phòng  
Miêu tả phương thức: Hiển thị danh sách sinh viên chưa có hợp đồng thuê phòng còn hiệu lực (trạng thái "Chưa thuê"). Chức năng này nằm trong StudentController, sử dụng bộ lọc trạng thái.

 ![image](https://github.com/user-attachments/assets/2cf7d89b-6c98-49a7-932a-51ff8e8acbba)  
3. Vũ Huy Kỳ: Kiểm tra phòng còn chỗ trống và tạo hợp đồng thuê phòng mới  
Miêu tả phương thức: Khi thêm hợp đồng thuê phòng, kiểm tra phòng còn chỗ trống, sau đó tạo hợp đồng thêm sinh viên và cập nhật trạng thái phòng, sinh viên.  

![image](https://github.com/user-attachments/assets/ec73b431-6a59-4dbb-a247-a85704b0f256)  
![image](https://github.com/user-attachments/assets/346df60c-db81-4339-9a8b-aca60020fe98)  

#### Yêu cầu 6:
Thêm try catch đã thực hiện trong code
#### Yêu cầu 7: 
Sau khi update giao diện đã được thực hiện ở ngay yêu cầu 55
