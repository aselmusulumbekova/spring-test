package kg.megacom.spring.test.services.impl;

import kg.megacom.spring.test.mapper.AccountMapper;
import kg.megacom.spring.test.models.Account;
import kg.megacom.spring.test.models.Employee;
import kg.megacom.spring.test.models.dtos.AccountDto;
import kg.megacom.spring.test.models.enums.AccountStatus;
import kg.megacom.spring.test.models.requests.AuthRequest;
import kg.megacom.spring.test.models.responses.Response;
import kg.megacom.spring.test.repositories.AccountRep;
import kg.megacom.spring.test.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRep rep;

    AccountMapper mapper =AccountMapper.INSTANCE;


    @Override
    public AccountDto save(AccountDto dto) {
        Account account= AccountMapper.INSTANCE.toEntity(dto);
        Account account1 =rep.save(account);
        AccountDto accountDto=AccountMapper.INSTANCE.toDto(account1);
        return accountDto;
    }

    @Override

    public  AccountDto findById(Long id) {
        AccountDto accountDto=AccountMapper.INSTANCE.toDto
                (rep.findById(id).orElseThrow(()->new RuntimeException("Не найден аккаунт с таким id")));
        return accountDto;
    }

    @Override

    public List<AccountDto> finaAll() {
        return AccountMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public Response auth(AuthRequest authRequest) {
//        Account account=rep

        //code
        AccountDto accountDto=getByLogin(authRequest.getLogin());
        switch (accountDto.getStatus()){
            case DELETED:
                throw new RuntimeException("Аккаунт удален");
            case BLOCKED:
                if (checkDate(accountDto.getUpdateDate())){
                    accountDto.setCount(0);
                    accountDto.setStatus(AccountStatus.ACTIVE);
                    break;
                }
                throw new RuntimeException("Аккаунт заблокирован");
            case ACTIVE:
                break;
            default:
                throw new RuntimeException("Произошла ошибка");
        }

        if (!accountDto.getPassword().equals(authRequest.getPassword())){
            if (accountDto.getCount()>=3){
                accountDto.setStatus(AccountStatus.BLOCKED);
                save(accountDto);
                throw new RuntimeException("Пароль неверный.Ваш аккаунт заблокирован.Попробуйте через час");
            }
           accountDto.setCount(accountDto.getCount()+1);
           save(accountDto);
           throw new RuntimeException("Пароль неверный");
        }


        Response response=new Response("Успешно","Token");

        return response;
    }

    private boolean checkDate(Date updateDate) {
        Calendar checkDate=Calendar.getInstance();
        checkDate.setTime(updateDate);
        checkDate.add(Calendar.HOUR,1);

        return new Date().after(checkDate.getTime());
    }

    @Override
    public AccountDto getByLogin(String login) {
        return mapper.toDto(rep.findByLogin(login).
                orElseThrow(()->new RuntimeException("Пользователь не найден")));
    }
}
