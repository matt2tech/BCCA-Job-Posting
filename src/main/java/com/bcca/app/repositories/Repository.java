package com.bcca.app.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

}
