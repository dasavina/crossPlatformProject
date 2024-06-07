package com.example.demo.staff.staffmember;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = true)
public interface StaffMemberRepository extends CrudRepository<StaffMember, StaffMemberId>, StaffMemberRepositoryCustom {
}
