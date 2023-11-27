package com.DevEx.DevExBE.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategory(String category);

    Optional<Item> findByItemName(String name);

    boolean existsByItemName(String itemName);

}
