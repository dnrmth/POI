package com.POI.controller;

import com.POI.dto.AllPoiNear;
import com.POI.dto.CreatePoiData;
import com.POI.dto.GetAllPoiData;
import com.POI.infra.entities.PoiEntity;
import com.POI.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        poiService.createPointOfInterest(poiData);
        return ResponseEntity.ok("Point of Interest Registered");
    }

    @GetMapping()
    public ResponseEntity<Page<GetAllPoiData>> getAllPoi(@PageableDefault(size = 10, sort = "name")Pageable pageable){
        return ResponseEntity.ok(poiService.getAllPoi(pageable));
    }

    @PostMapping("/near")
    public ResponseEntity<List<PoiEntity>> getPoiNear(@RequestBody AllPoiNear allPoiNear){

        return ResponseEntity.ok(poiService.getPoiNear(allPoiNear));
    }

}
