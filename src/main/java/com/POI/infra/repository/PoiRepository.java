package com.POI.infra.repository;

import com.POI.infra.entities.PoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoiRepository extends JpaRepository<PoiEntity, Long> {

    @Query("""
    select u from point_of_interest u where (u.x - :value_x) <= :d_max and (u.y - :value_y) <= :d_max
    """)
    List<PoiEntity> findPoiEntitiesNear(@Param("value_x") int x,
                                        @Param("value_y") int y,
                                        @Param("d_max") int d_max);
}

