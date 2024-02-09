package second.hand.item.SecondHandItem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ProductModel {
    @Id
    private String productId;
    private String e_mail;
    private String sellerName;
    private String phoneNumber;
    private String model;
    private String brand;
    private String category;
    private String ownYear;
    private String kilometer;
    private String place;
    private String cost;
}
