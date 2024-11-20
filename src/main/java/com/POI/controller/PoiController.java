package com.POI.controller;

import com.POI.dto.AllPoiNear;
import com.POI.dto.CreatePoiData;
import com.POI.dto.GetAllPoiData;
import com.POI.entities.PoiEntity;
import com.POI.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poi")
public class PoiController {

    private final PoiService poiService;

    @Autowired
    public PoiController(PoiService poiService) {
        this.poiService = poiService;
    }

    @PostMapping
    public ResponseEntity<String> createPointOfInterest(@RequestBody CreatePoiData poiData){
        poiService.creatPointOfInterest(poiData);
        return ResponseEntity.ok("Point of Interest Registered");
    }

    @GetMapping()
    public ResponseEntity<Page<GetAllPoiData>> getAllPoi(@PageableDefault(size = 10, sort = "name")Pageable pageable){
        return ResponseEntity.ok(poiService.getAllPoi(pageable));
    }

    @GetMapping("/near")
    public ResponseEntity getPoiNear(@RequestParam AllPoiNear allPoiNear){
        poiService.getPoiNear(allPoiNear);

        return ResponseEntity.ok("sexo");
    }

}
