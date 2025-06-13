package services;

import models.DormRoom;
import models.CrudManager;

public class DormRoomService {
    private CrudManager<DormRoom> dormRoomManager = new CrudManager<>();

    public void createDormRoom(DormRoom dormRoom) {
        dormRoomManager.create(dormRoom);
    }

    public void listAllDormRooms() {
        dormRoomManager.readAll();
    }

    public void updateDormRoom(String dormRoomID, DormRoom newDormRoom) {
        dormRoomManager.update(dormRoomID, newDormRoom);
    }

    public void deleteDormRoom(String dormRoomID) {
        dormRoomManager.delete(dormRoomID);
    }

    public CrudManager<DormRoom> getDormRoomManager() {
        return dormRoomManager;
    }
}
