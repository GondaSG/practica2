package com.Editorial.service.impl;
import com.Editorial.model.Editorial;
import com.Editorial.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    EditorialService editorialRepository;

    @Override
    public List<Editorial> findAll() {return editorialRepository.findAll();
    }

    @Override
    public Editorial findById(long id) {
        Optional<Editorial> op = Optional.ofNullable(editorialRepository.findById(id));
        return op.isPresent() ? op.get() : new Editorial();
    }

    @Override
    public Editorial create(Editorial editorial) {
        return editorialRepository.save(editorial);
    }


    @Override
    public Editorial update(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public void delete(long id) {
        editorialRepository.deleteById(id);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Editorial save(Editorial editorial) {
        return null;
    }
}
