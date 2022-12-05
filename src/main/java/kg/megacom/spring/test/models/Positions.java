package kg.megacom.spring.test.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name = "tb_position")
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String def;
}
