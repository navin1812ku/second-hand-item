package second.hand.item.SecondHandItem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "product")
@Data
public class ProductModel {
    @Id
    @Column(nullable = false)
    private String productId;
    @Column(nullable = false)
    private String e_mail;
    @Column(nullable = false)
    private String sellerName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String ownYear;
    @Column(nullable = false)
    private String kilometer;
    @Column(nullable = false)
    private String place;
    @Column(nullable = false)
    private String cost;
}
