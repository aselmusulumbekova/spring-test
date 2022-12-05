package kg.megacom.spring.test.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "tb_phone")
@Getter
@Setter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String number;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employeeId;
}
