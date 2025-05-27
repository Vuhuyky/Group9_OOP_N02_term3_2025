public class DormRoomService extends GenericService<DormRoom, String> {

    @Override
    protected String getId(DormRoom obj) {
        return obj.getRoomId(); // giả sử DormRoom có method getRoomId()
    }

    // Thêm các hàm đặc thù cho DormRoom nếu cần
}
