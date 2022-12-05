package kg.megacom.spring.test.services.impl;

import kg.megacom.spring.test.mapper.PhoneMapper;
import kg.megacom.spring.test.models.Phone;
import kg.megacom.spring.test.models.dtos.PhoneDto;
import kg.megacom.spring.test.repositories.PhoneRep;
import kg.megacom.spring.test.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRep rep;

    PhoneMapper mapper=PhoneMapper.INSTANCE;

    @Override
    public PhoneDto save(PhoneDto phone) {
        return mapper.toDto(rep.save(mapper.toEntity(phone)));
    }

    @Override
    public PhoneDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("Не найден сотрудник с таким id")));
    }

    @Override
    public List<PhoneDto> finaAll() {
        return mapper.toDtos(rep.findAll());
    }
}
