package com.DevEx.DevExBE.domain.handcarry;

import com.DevEx.DevExBE.domain.banneditem.BannedItem;
import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.global.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Float unitCosts;

    @Column(name = "max_weight")
    private Long maxWeight;

    @ManyToOne
    @JoinColumn(name = "corporation_id")
    @JsonBackReference
    private Corporation corporation;


    public static Handcarry toEntity(HandcarryRequestDto requestDto, Corporation corporation) {
        return Handcarry.builder()
                .startPoint(requestDto.getStartPoint())
                .endPoint(requestDto.getEndPoint())
                .unitCosts(requestDto.getUnitCosts())
                .maxWeight(requestDto.getMaxWeight())
                .corporation(corporation)
                .build();
    }

    public void update(String startPoint, String endPoint, Float unitCosts, Long maxWeight) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.unitCosts = unitCosts;
        this.maxWeight = maxWeight;
    }
}
