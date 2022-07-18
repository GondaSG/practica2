package com.reception.service;
import com.reception.model.Reception;
import java.util.List;

public interface ReceptionService {

    List<Reception> findAll();
    Reception findById(long id);
    Reception create(Reception reception);
    Reception update(Reception reception);
    void delete(long id);

    void deleteById(long id);

    Reception save(Reception reception);
}
