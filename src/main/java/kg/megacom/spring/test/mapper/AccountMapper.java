package kg.megacom.spring.test.mapper;

import kg.megacom.spring.test.models.Account;
import kg.megacom.spring.test.models.dtos.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends BaseMapper<Account,AccountDto> {

    AccountMapper INSTANCE= Mappers.getMapper(AccountMapper.class);

}
