package com.example.dormmanagement;

import com.example.dormmanagement.model.Dorm;
import com.example.dormmanagement.repository.DormRepository;
import com.example.dormmanagement.service.DormService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DormServiceTest {

    @Autowired
    private DormRepository dormRepository;

    @AfterEach
    public void cleanup() {
        dormRepository.deleteAll();
    }

    @Test
    public void testSaveAndFindAllDorm() {
        DormService dormService = new DormService(dormRepository);

        // Tạo Dorm, dùng constructor có id = null
        Dorm d1 = new Dorm(null, "KTX A", "123 Đường ABC", 5, "Quản lý X");
        Dorm saved = dormService.save(d1);
        assertNotNull(saved.getId());

        List<Dorm> all = dormService.findAll();
        assertEquals(1, all.size());
        assertEquals("KTX A", all.get(0).getDormName());
    }
}
