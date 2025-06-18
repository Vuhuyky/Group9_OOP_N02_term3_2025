# Group9
1. Vũ Huy Kỳ 22010414 Github id: Vuhuyky
2. Đỗ Minh Nhật 22010464 Github id: MinhNhat2710

## Tiêu đề:
Ứng dụng quản lý ký túc xá

## Readme Giới thiệu
https://vuhuyky.github.io/Group9_OOP_N02_term3_2025/

Xây dựng ứng dụng quản lý ký túc xá

**Yêu cầu:**

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
![z6620007013264_42ec8e3cd07be051214d0d5f5e29bc8b](https://github.com/user-attachments/assets/cdf2f69f-9bc9-4b3a-831d-cf48f73b864e)



Nội dung 03:

# Sequence them phong
![sequence them phong](https://github.com/user-attachments/assets/73e63c83-b0f5-406a-8375-1ccb4821c393)
# Sequence hop dong
![sequence hopdong](https://github.com/user-attachments/assets/815d8e56-9648-424a-9f67-9c36f2773447)
# Sequence gan sinh vien
![sequence gánv](https://github.com/user-attachments/assets/e612bfaa-0a92-427f-9647-443ee1de42eb)

## Lưu đồ thuật toán
![luudo](https://github.com/user-attachments/assets/9b82c599-9981-474d-9746-b251ae7a84ca)


**Phân chia:**
*Đỗ Minh Nhật* 
**Chức năng:** Kiểm tra xem phòng có tồn tại hay không.

Miêu tả công việc:

- Viết phương thức để kiểm tra sự tồn tại của phòng trong cơ sở dữ liệu.

- Phương thức này nhận ID phòng và tìm kiếm phòng trong cơ sở dữ liệu.

- Trả về thông báo nếu phòng không tồn tại.

public boolean isRoomExist(String roomId) {
    return roomRepository.existsById(roomId); // Kiểm tra sự tồn tại của phòng
}



*Vũ Huy Kỳ*
**Chức năng:** Kiểm tra phòng có đầy hay không và đăng ký sinh viên vào phòng.

Miêu tả công việc:

- Viết phương thức để kiểm tra phòng có đầy hay không (dựa vào số lượng sinh viên đã đăng ký trong phòng).

- Nếu phòng chưa đầy, tiếp tục đăng ký sinh viên vào phòng.

- Cập nhật thông tin sinh viên, ghi nhận ngày check-in và gán phòng cho sinh viên.

