package com.DevEx.DevExBE.domain.handcarry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HandcarryRepository extends JpaRepository<Handcarry, Long> {
    Optional<Handcarry> findById(Long id);
    List<Handcarry> findAll();
    List<Handcarry> findByStartPointAndEndPoint(String startPoint, String endPoint);
}
