package com.example.dormmanagement.controller;

import com.example.dormmanagement.model.Dorm;
import com.example.dormmanagement.service.DormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST cho đối tượng Dorm.
 */
@RestController
@RequestMapping("/api/dorms")
public class DormController {

    private final DormService dormService;

    public DormController(DormService dormService) {
        this.dormService = dormService;
    }

    /**
     * GET /api/dorms → Lấy tất cả Dorm.
     */
    @GetMapping
    public ResponseEntity<List<Dorm>> getAllDorms() {
        return ResponseEntity.ok(dormService.findAll());
    }

    /**
     * GET /api/dorms/{id} → Lấy Dorm theo id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Dorm> getDormById(@PathVariable String id) {
        Optional<Dorm> opt = dormService.findById(id);
        return opt.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/dorms → Tạo mới Dorm.
     */
    @PostMapping
    public ResponseEntity<Dorm> createDorm(@RequestBody Dorm dorm) {
        Dorm saved = dormService.save(dorm);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * PUT /api/dorms/{id} → Cập nhật Dorm.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Dorm> updateDorm(
            @PathVariable String id,
            @RequestBody Dorm dormDetails
    ) {
        dormDetails.setId(id);
        Optional<Dorm> updated = dormService.update(dormDetails);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/dorms/{id} → Xóa Dorm.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDorm(@PathVariable String id) {
        boolean deleted = dormService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET /api/dorms/filter?name=… → Lọc theo tên (IgnoreCase).
     */
    @GetMapping("/filter")
    public ResponseEntity<List<Dorm>> filterDorms(
            @RequestParam(required = false) String name
    ) {
        return ResponseEntity.ok(dormService.filterByName(name));
    }
}
