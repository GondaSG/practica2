package com.Editorial.service;
import com.Editorial.model.Editorial;
import java.util.List;

public interface EditorialService {

    List<Editorial> findAll();

    Editorial findById(long id);

    Editorial create(Editorial editorial);

    Editorial update(Editorial editorial);

    void delete(long id);

    void deleteById(long id);

    Editorial save(Editorial editorial);
}