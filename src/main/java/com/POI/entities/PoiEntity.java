package com.POI.entities;
import com.POI.dto.CreatePoiData;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "point_of_interest")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PoiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    private int x;
    @Setter
    private int y;

    public PoiEntity(CreatePoiData poiData) {
        this.name = poiData.name();
        this.x = poiData.x();
        this.y = poiData.y();
    }
}
