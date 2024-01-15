package rentals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "properties")
public class PropertyEntity {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer price;
    private String housingType;
    private Integer bedrooms;
    private Integer usableSurface;
    private Integer gardenSurface;
    private Integer terraceSurface;
    private Integer floors;
    private Integer addressID;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getHousingType() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getUsableSurface() {
        return usableSurface;
    }

    public void setUsableSurface(Integer usableSurface) {
        this.usableSurface = usableSurface;
    }

    public Integer getGardenSurface() {
        return gardenSurface;
    }

    public void setGardenSurface(Integer gardenSurface) {
        this.gardenSurface = gardenSurface;
    }

    public Integer getTerraceSurface() {
        return terraceSurface;
    }

    public void setTerraceSurface(Integer terraceSurface) {
        this.terraceSurface = terraceSurface;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
