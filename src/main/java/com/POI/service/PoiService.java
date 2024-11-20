package com.POI.service;

import com.POI.dto.AllPoiNear;
import com.POI.dto.CreatePoiData;
import com.POI.dto.GetAllPoiData;
import com.POI.entities.PoiEntity;
import com.POI.entities.PoiEntityBuilder;
import com.POI.repository.PoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class PoiService {

    private final PoiRepository poiRepository;
    private PoiEntityBuilder poiEntityBuilder;

    @Autowired
    public PoiService(PoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    public void creatPointOfInterest(CreatePoiData poiData) {
        if(poiData.x() < 0 || poiData.y() < 0){
            throw new IllegalArgumentException("Os valores de x e y devem ser positivos");
        }
        PoiEntity poiEntity = new PoiEntity(poiData);
        poiRepository.save(poiEntity);
    }

    public Page<GetAllPoiData> getAllPoi(Pageable pageable) {
        return poiRepository.findAll(pageable).map(GetAllPoiData::new);
    }

    public void getPoiNear(AllPoiNear allPoiNear) {



    }
}
