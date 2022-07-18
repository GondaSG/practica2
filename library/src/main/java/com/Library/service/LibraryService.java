package com.Library.service;
import com.Library.model.Library;
import java.util.List;

public interface LibraryService {

    List<Library> findAll();

    Library findById(long id);

    Library create(Library library);

    Library update(Library library);

    void delete(long id);

    void deleteById(long id);

    Library save(Library library);
}