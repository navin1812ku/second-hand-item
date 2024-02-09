package second.hand.item.SecondHandItem.model.request;

import lombok.Data;

@Data
public class ProductCreationRequest {
    private String phoneNumber;
    private String model;
    private String brand;
    private String category;
    private String ownYear;
    private String kilometer;
    private String place;
    private String cost;
}
