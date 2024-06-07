package com.example.demo.staff;
import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_staff_member")
public class StaffMember extends AbstractEntity<StaffMemberId> {

    /**
     * Default constructor for JPA
     */
    protected StaffMember() {
    }
    public StaffMember(StaffMemberId id) {
        super(id);
    }
}