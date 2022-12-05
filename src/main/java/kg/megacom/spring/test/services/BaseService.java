package kg.megacom.spring.test.services;

import java.util.List;

public interface BaseService <T>{
    T save(T t);
    T findById(Long id);
    List<T> finaAll();
}
