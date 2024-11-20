package com.POI.repository;

import com.POI.entities.PoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiRepository extends JpaRepository<PoiEntity, Long> {
}

