package com.POI.entities;

public class PoiEntityBuilder {

    private final PoiEntity poiEntity = new PoiEntity();

    public PoiEntityBuilder withName(String name) {
        poiEntity.setName(name);
        return this;
    }
    public PoiEntityBuilder withY(int x) {
        poiEntity.setX(x);
        return this;
    }
    public PoiEntityBuilder withX(int y) {
        poiEntity.setY(y);
        return this;
    }

    public PoiEntity build(){
        return poiEntity;
    }
}
