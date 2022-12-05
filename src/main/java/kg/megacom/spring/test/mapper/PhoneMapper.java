package kg.megacom.spring.test.mapper;

import kg.megacom.spring.test.models.Phone;
import kg.megacom.spring.test.models.dtos.PhoneDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper extends BaseMapper<Phone, PhoneDto> {
    PhoneMapper INSTANCE= Mappers.getMapper(PhoneMapper.class);
}
