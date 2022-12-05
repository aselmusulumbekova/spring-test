package kg.megacom.spring.test.services.impl;

import kg.megacom.spring.test.mapper.PositionsMapper;
import kg.megacom.spring.test.models.Positions;
import kg.megacom.spring.test.models.dtos.PositionsDto;
import kg.megacom.spring.test.repositories.PositionRep;
import kg.megacom.spring.test.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRep rep;

    PositionsMapper mapper=PositionsMapper.INSTANCE;

    @Override
    public PositionsDto save(PositionsDto positions) {
        return mapper.toDto(rep.save(mapper.toEntity(positions)));
    }

    @Override
    public PositionsDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("Не найдена позиция с таким id")));

    }

    @Override
    public List<PositionsDto> finaAll() {
        return mapper.toDtos(rep.findAll());
    }
}
