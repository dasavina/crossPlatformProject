package com.tamingthymeleaf.staffmember;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.staff.StaffMember;
import com.example.demo.staff.StaffMemberId;
import com.example.demo.staff.StaffMemberRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StaffMemberRepositoryTest {
    private final StaffMemberRepository repository;
    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    StaffMemberRepositoryTest(StaffMemberRepository repository,
                           JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveStaffMember() {
        StaffMemberId id = repository.nextId();
        repository.save(new StaffMember(id));

        entityManager.flush();

        UUID idInDb = jdbcTemplate.queryForObject("SELECT id FROM Staffmember", UUID.class);
        assertThat(idInDb).isEqualTo(id.getId());
    }
}