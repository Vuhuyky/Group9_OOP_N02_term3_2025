package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.DormRoom;
import com.example.servingwebcontent.repository.DormRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DormRoomService {
    @Autowired
    private DormRoomRepository dormRoomRepository;

    public List<DormRoom> getAllDormRooms() {
        try {
            return dormRoomRepository.findAll();
        } catch (Exception e) {
            return Collections.emptyList();
        } finally {
            
        }
    }

    public Optional<DormRoom> getDormRoomById(String id) {
        try {
            return dormRoomRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            
        }
    }

    public void saveDormRoom(DormRoom dormRoom) {
        try {
            dormRoomRepository.save(dormRoom);
        } catch (Exception e) {
            
        } finally {
            
        }
    }

    public void deleteDormRoom(String id) {
        try {
            dormRoomRepository.deleteById(id);
        } catch (Exception e) {
            
        } finally {
            
        }
    }

    public List<DormRoom> getDormRoomsByStatus(String status) {
        try {
            return dormRoomRepository.findByStatus(status);
        } catch (Exception e) {
            return Collections.emptyList();
        } finally {
            
        }
    }

    public boolean isRoomExist(String roomId) {
        try {
            return dormRoomRepository.existsById(roomId);
        } catch (Exception e) {
            return false;
        } finally {
            
        }
    }
}