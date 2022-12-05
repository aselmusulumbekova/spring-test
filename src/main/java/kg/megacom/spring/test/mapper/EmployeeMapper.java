package kg.megacom.spring.test.mapper;

import kg.megacom.spring.test.models.Employee;
import kg.megacom.spring.test.models.dtos.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee,EmployeeDto>{

    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);

}
