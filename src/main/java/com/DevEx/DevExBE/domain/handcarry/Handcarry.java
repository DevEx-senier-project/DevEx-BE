package com.DevEx.DevExBE.domain.handcarry;

import com.DevEx.DevExBE.domain.banneditem.BannedItem;
import com.DevEx.DevExBE.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor//기본 생성자 추가
@AllArgsConstructor//모든 피드 값을 파라미터로 받는 생성자 추가
public class Handcarry extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "end_point")
    private String endPoint;

    @Column(name = "unit_costs")
    private Long unitCosts;

    @Column(name = "max_weight")
    private Long maxWeight;

    @OneToMany
    private List<BannedItem> bannedItemList = new ArrayList<>();

    public Handcarry(String startPoint, String endPoint, Long unitCosts, Long maxWeight){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.unitCosts = unitCosts;
        this.maxWeight = maxWeight;
    }

    public void update(String startPoint, String endPoint, Long unitCosts, Long maxWeight) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.unitCosts = unitCosts;
        this.maxWeight = maxWeight;
    }

}