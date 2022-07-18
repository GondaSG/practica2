package com.Library.service.impl;
import com.Library.model.Library;
import com.Library.repository.LibraryRepository;
import com.Library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryService libraryRepository;

    @Override
    public List<Library> findAll() {return libraryRepository.findAll();
    }

    @Override
    public Library findById(long id) {
        Optional<Library> op = Optional.ofNullable(libraryRepository.findById(id));
        return op.isPresent() ? op.get() : new Library();
    }

    @Override
    public Library create(Library library) {
        return libraryRepository.save(library);
    }


    @Override
    public Library update(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public void delete(long id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Library save(Library library) {
        return null;
    }
}
