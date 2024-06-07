package com.example.demo.menu.menuitem;

import com.example.demo.menu.menuitem.*;
import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("data-jpa-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MenuItemRepositoryTest {
    private final MenuItemRepository repository;
    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    MenuItemRepositoryTest(MenuItemRepository repository,
                              JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveMenuItem() {
        MenuItemId id = repository.nextId();
        repository.save(new MenuItem(id,
                new MenuItemName("Grilled fish", "---"),
                120.50));
        entityManager.flush();
        assertThat(jdbcTemplate.queryForObject("SELECT id FROM tt_menu_item", UUID.class)).isEqualTo(id.getId());
        assertThat(jdbcTemplate.queryForObject("SELECT item_name FROM tt_menu_item", String.class)).isEqualTo("Grilled fish");
        assertThat(jdbcTemplate.queryForObject("SELECT description FROM tt_menu_item", String.class)).isEqualTo("---");
        assertThat(jdbcTemplate.queryForObject("SELECT price FROM tt_menu_item", Double.class)).isEqualTo(120.50);
    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        public UniqueIdGenerator<UUID> uniqueIdGenerator() {
            return new InMemoryUniqueIdGenerator();
        }
    }
}
