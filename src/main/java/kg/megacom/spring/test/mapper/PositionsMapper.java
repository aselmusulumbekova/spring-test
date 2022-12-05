package kg.megacom.spring.test.mapper;

import kg.megacom.spring.test.models.Positions;
import kg.megacom.spring.test.models.dtos.PositionsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PositionsMapper extends BaseMapper<Positions, PositionsDto>{

    PositionsMapper INSTANCE= Mappers.getMapper(PositionsMapper.class);
}
