package com.DevEx.DevExBE.domain.item;


import com.DevEx.DevExBE.domain.banneditem.BannedItem;
import com.DevEx.DevExBE.domain.banneditem.dto.BannedItemRequestDto;
import com.DevEx.DevExBE.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor//기본 생성자 추가
@AllArgsConstructor//모든 피드 값을 파라미터로 받는 생성자 추가
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_category")
    private String category;

    @Column(name = "item_name")
    private String itemName;

}
