package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.DormRoom;
import com.example.servingwebcontent.model.RentalContract;
import com.example.servingwebcontent.service.DormRoomService;
import com.example.servingwebcontent.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dormrooms")
public class DormRoomController {
    @Autowired
    private DormRoomService dormRoomService;
    @Autowired
    private RentalContractService rentalContractService;

    @GetMapping
    public String listDormRooms(@RequestParam(required = false) String status, Model model) {
        List<DormRoom> dormRooms;
        if (status != null && !status.isEmpty()) {
            dormRooms = dormRoomService.getDormRoomsByStatus(status);
        } else {
            dormRooms = dormRoomService.getAllDormRooms();
        }
        model.addAttribute("dormrooms", dormRooms);
        model.addAttribute("status", status);
        return "dormrooms";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dormRoom", new DormRoom());
        return "dormroom_form";
    }

    @PostMapping("/add")
    public String addDormRoom(@ModelAttribute DormRoom dormRoom) {
        dormRoomService.saveDormRoom(dormRoom);
        return "redirect:/dormrooms";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        DormRoom dormRoom = dormRoomService.getDormRoomById(id).orElse(null);
        model.addAttribute("dormRoom", dormRoom);
        return "dormroom_form";
    }

    @PostMapping("/edit")
    public String editDormRoom(@ModelAttribute DormRoom dormRoom) {
        dormRoomService.saveDormRoom(dormRoom);
        return "redirect:/dormrooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteDormRoom(@PathVariable String id) {
        // Xóa tất cả hợp đồng thuê liên quan trước khi xóa phòng
        List<RentalContract> contracts = rentalContractService.findByDormRoom_RoomId(id);
        for (RentalContract contract : contracts) {
            rentalContractService.deleteContract(contract.getContractId());
        }
        dormRoomService.deleteDormRoom(id);
        return "redirect:/dormrooms";
    }
}