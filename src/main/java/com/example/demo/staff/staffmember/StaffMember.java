package com.example.demo.staff.staffmember;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tt_staff_member")
public class StaffMember extends AbstractEntity<StaffMemberId> {

    @NotNull
    private StaffMemberName staffMemberName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private Position position;

    /**
     * Default constructor for JPA
     */
    protected StaffMember() {
    }

    public StaffMember(StaffMemberId id, StaffMemberName staffMemberName, Gender gender, Position position) {
        super(id);
        this.staffMemberName = staffMemberName;
        this.gender = gender;
        this.position = position;
    }

    public @NotNull StaffMemberName getStaffMemberName() {
        return staffMemberName;
    }

    public @NotNull Gender getGender() {
        return gender;
    }

    public @NotNull Position getPosition() {
        return position;
    }
}