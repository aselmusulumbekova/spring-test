package kg.megacom.spring.test.models.dtos;

import kg.megacom.spring.test.models.Employee;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhoneDto {
    Long id;
    String number;
    EmployeeDto employeeId;
}
