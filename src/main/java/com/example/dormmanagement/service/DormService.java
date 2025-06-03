package com.example.dormmanagement.service;

import com.example.dormmanagement.model.Dorm;
import com.example.dormmanagement.repository.DormRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service cho đối tượng Dorm, sử dụng JPA repository.
 */
@Service
public class DormService {

    private final DormRepository dormRepository;

    public DormService(DormRepository dormRepository) {
        this.dormRepository = dormRepository;
    }

    /**
     * Lấy toàn bộ Dorm.
     */
    public List<Dorm> findAll() {
        return dormRepository.findAll();
    }

    /**
     * Tìm Dorm theo id.
     */
    public Optional<Dorm> findById(String id) {
        return dormRepository.findById(id);
    }

    /**
     * Thêm mới Dorm.
     */
    public Dorm save(Dorm dorm) {
        return dormRepository.save(dorm);
    }

    /**
     * Cập nhật Dorm.
     */
    public Optional<Dorm> update(Dorm dorm) {
        if (!dormRepository.existsById(dorm.getId())) {
            return Optional.empty();
        }
        return Optional.of(dormRepository.save(dorm));
    }

    /**
     * Xóa Dorm theo id.
     */
    public boolean delete(String id) {
        if (!dormRepository.existsById(id)) {
            return false;
        }
        dormRepository.deleteById(id);
        return true;
    }

    /**
     * Filter Dorm theo tên (IgnoreCase). Nếu name == null hoặc rỗng, sẽ trả tất cả.
     */
    public List<Dorm> filterByName(String name) {
        if (name == null || name.isEmpty()) {
            return dormRepository.findAll();
        }
        return dormRepository.findByDormNameContainingIgnoreCase(name);
    }
}
