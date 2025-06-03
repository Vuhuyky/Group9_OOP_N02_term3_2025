package com.example.dormmanagement.repository;

import com.example.dormmanagement.model.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository cho entity Dorm.
 */
@Repository
public interface DormRepository extends JpaRepository<Dorm, String> {
    /**
     * Tìm tất cả Dorm có dormName chứa (ignore case).
     */
    List<Dorm> findByDormNameContainingIgnoreCase(String name);
}
