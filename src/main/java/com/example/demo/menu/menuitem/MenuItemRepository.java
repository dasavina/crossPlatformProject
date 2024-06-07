package com.example.demo.menu.menuitem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = true)
public interface MenuItemRepository extends CrudRepository<MenuItem, MenuItemId>, MenuItemRepositoryCustom {
}
