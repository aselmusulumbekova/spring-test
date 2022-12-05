package kg.megacom.spring.test.models.dtos;

import kg.megacom.spring.test.models.Account;
import kg.megacom.spring.test.models.Positions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {
    Long id;
    String name;
    AccountDto accountId;
    PositionsDto positions;
}
