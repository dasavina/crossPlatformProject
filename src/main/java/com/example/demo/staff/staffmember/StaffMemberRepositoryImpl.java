package com.example.demo.staff.staffmember;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;

import java.util.UUID;
public class StaffMemberRepositoryImpl implements StaffMemberRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;
    public StaffMemberRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }
    @Override
    public StaffMemberId nextId() {
        return new StaffMemberId(generator.getNextUniqueId());
    }
}