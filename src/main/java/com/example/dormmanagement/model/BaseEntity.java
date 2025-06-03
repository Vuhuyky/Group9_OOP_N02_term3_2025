package com.example.dormmanagement.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Lớp cha (MappedSuperclass) cho các Entity, cung cấp trường id chung.
 * Bỏ generator UUID vì id do người dùng nhập (ví dụ MSSV).
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 50)
    protected String id;

    public BaseEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
