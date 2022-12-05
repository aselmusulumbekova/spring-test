package kg.megacom.spring.test.models;

import kg.megacom.spring.test.models.enums.AccountStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_account")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true,name = "login")
    String login;
    String password;
    int count;
    @Enumerated(EnumType.STRING)
    AccountStatus status;
    Date addDate;
    Date updateDate;


    @PrePersist
    protected void onCreate(){
        status=AccountStatus.ACTIVE;
        addDate=new Date();
        updateDate=new Date();
        count=0;
    }

    @PreUpdate
    protected void onUpdate(){
        updateDate=new Date();
    }

}
