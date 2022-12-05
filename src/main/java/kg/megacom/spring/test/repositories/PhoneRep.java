package kg.megacom.spring.test.repositories;

import kg.megacom.spring.test.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRep extends JpaRepository<Phone,Long> {
}
