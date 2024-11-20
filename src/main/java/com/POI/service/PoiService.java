package com.POI.service;

import com.POI.dto.AllPoiNear;
import com.POI.dto.CreatePoiData;
import com.POI.dto.GetAllPoiData;
import com.POI.entities.PoiEntity;
import com.POI.repository.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiService {

    private final PoiRepository poiRepository;

    @Autowired
    public PoiService(PoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    //Register a new Point Of Interest in the database
    public void createPointOfInterest(CreatePoiData poiData) {
        if(poiData.x() < 0 || poiData.y() < 0){
            throw new IllegalArgumentException("Os valores de x e y devem ser positivos");
        }
        PoiEntity poiEntity = new PoiEntity(poiData);
        poiRepository.save(poiEntity);
    }

    //Returns a page os all Points Of Interest registered in the database
    public Page<GetAllPoiData> getAllPoi(Pageable pageable) {
        return poiRepository.findAll(pageable).map(GetAllPoiData::new);
    }

    //Searches for all Points Of Interest near the user location
    public List<PoiEntity> getPoiNear(AllPoiNear allPoiNear) {
        //Selects all Points Of Interest inside de X and Y boundry
        List<PoiEntity> pointOfInterest = poiRepository.findPoiEntitiesNear(allPoiNear.x(), allPoiNear.y(), allPoiNear.d_max());

        //Checks if each point of interest is inside the max distance (d_max) set by the user
        pointOfInterest.removeIf(poi -> Math.pow(allPoiNear.d_max(), 2) < Math.pow((poi.getX() - allPoiNear.x()), 2) + Math.pow((poi.getY() - allPoiNear.y()), 2));
        return pointOfInterest;
    }
}
