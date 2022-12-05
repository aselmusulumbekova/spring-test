package kg.megacom.spring.test.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "tb_employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    Account accountId;

    @OneToOne
    @JoinColumn(name = "position_id")
    Positions positions;
}
