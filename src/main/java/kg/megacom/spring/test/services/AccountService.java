package kg.megacom.spring.test.services;

import kg.megacom.spring.test.models.Account;
import kg.megacom.spring.test.models.dtos.AccountDto;
import kg.megacom.spring.test.models.requests.AuthRequest;
import kg.megacom.spring.test.models.responses.Response;

public interface AccountService extends BaseService<AccountDto>{
    Response auth(AuthRequest authRequest);
    AccountDto getByLogin(String login);
}
