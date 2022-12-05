package kg.megacom.spring.test.services.impl;

import kg.megacom.spring.test.mapper.EmployeeMapper;
import kg.megacom.spring.test.models.Account;
import kg.megacom.spring.test.models.Employee;
import kg.megacom.spring.test.models.dtos.AccountDto;
import kg.megacom.spring.test.models.dtos.EmployeeDto;
import kg.megacom.spring.test.repositories.EmployeeRepository;
import kg.megacom.spring.test.services.AccountService;
import kg.megacom.spring.test.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private  EmployeeRepository rep;

    EmployeeMapper mapper=EmployeeMapper.INSTANCE;

    @Autowired
    private AccountService accountService;

    @Override
    public EmployeeDto save(EmployeeDto dto) {
        AccountDto accountDto=accountService.save(dto.getAccountId());
        dto.setAccountId(accountDto);
        return mapper.toDto(rep.save(mapper.toEntity(dto)));
    }

    @Override
    public EmployeeDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("Не найден сотрудник с таким id")));
    }

    @Override
    public List<EmployeeDto> finaAll() {
        return mapper.toDtos(rep.findAll());
    }
}
