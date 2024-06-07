package com.example.demo.staff.staffmember;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;
public class StaffMemberId extends AbstractEntityId<UUID> {
   /**
   * Default constructor for JPA
   */
   protected StaffMemberId() {
   }
   public StaffMemberId(UUID id) {
       super(id);
   }
}