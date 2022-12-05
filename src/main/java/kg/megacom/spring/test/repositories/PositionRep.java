package kg.megacom.spring.test.repositories;

import kg.megacom.spring.test.models.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRep extends JpaRepository<Positions,Long> {
}
