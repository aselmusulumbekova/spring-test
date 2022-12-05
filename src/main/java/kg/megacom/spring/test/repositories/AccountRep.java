package kg.megacom.spring.test.repositories;

import kg.megacom.spring.test.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRep extends JpaRepository<Account,Long> {



    Optional<Account> findByLogin(String login);
}
