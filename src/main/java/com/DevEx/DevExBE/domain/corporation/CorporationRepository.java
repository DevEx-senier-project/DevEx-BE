package com.DevEx.DevExBE.domain.corporation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorporationRepository extends JpaRepository<Corporation, Long> {
    Optional<Corporation> findById(Long id);

    Optional<Corporation> findByBusinessNumber(Long businessNumber);

    boolean existsByCorpName(String corpName);

    Optional<Corporation> findByCorpName(String corpName);
}