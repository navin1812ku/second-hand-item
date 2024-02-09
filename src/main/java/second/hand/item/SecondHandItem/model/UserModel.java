package second.hand.item.SecondHandItem.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class UserModel {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
}
