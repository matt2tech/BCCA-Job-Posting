package com.bcca.app.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> findAll();

    List<T> oldest();

    List<T> findByDate(String date);

    Optional<T> findById(Integer id);

    void save(T t);

}
