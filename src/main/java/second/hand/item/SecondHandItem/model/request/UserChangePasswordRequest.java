package second.hand.item.SecondHandItem.model.request;

import lombok.Data;

@Data
public class UserChangePasswordRequest {
    private String e_mail;
    private String new_password;
}
