package kg.megacom.spring.test.models.dtos;

import kg.megacom.spring.test.models.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AccountDto {
    Long id;
    String login;
    String password;
    int count;
    AccountStatus status;
    Date addDate;
    Date updateDate;
}
