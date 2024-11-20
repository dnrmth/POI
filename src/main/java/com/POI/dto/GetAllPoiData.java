package com.POI.dto;

import com.POI.entities.PoiEntity;

public record GetAllPoiData(Long id, String name, int x, int y) {
    public GetAllPoiData(PoiEntity poiEntity) {
        this(poiEntity.getId(), poiEntity.getName(), poiEntity.getX(), poiEntity.getY());
    }
}
