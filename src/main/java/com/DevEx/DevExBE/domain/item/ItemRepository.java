package com.DevEx.DevExBE.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategory(String category);

    Item findByItemName(String name);
    boolean existsByItemName(String itemName);
    List<Item> findByItemNameIn(List<String> itemNames);

}
