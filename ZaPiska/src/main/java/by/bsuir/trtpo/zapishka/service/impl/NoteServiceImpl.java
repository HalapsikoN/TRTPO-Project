package by.bsuir.trtpo.zapishka.service.impl;

import by.bsuir.trtpo.zapishka.bean.Note;
import by.bsuir.trtpo.zapishka.dao.NoteDAO;
import by.bsuir.trtpo.zapishka.service.NoteService;
import by.bsuir.trtpo.zapishka.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO repository;

    @Override
    public boolean addNote(Note note) throws ServiceException {
        checkNote(note);

        if(repository.existsByHeader(note.getHeader())){
            throw new ServiceException("There is such note");
        }

        repository.save(note);
        return true;
    }

    @Override
    public Note getNote(String header) throws ServiceException {
        if(header==null || header.isEmpty()){
            throw new ServiceException("no header");
        }

        return repository.findByHeader(header);
    }

    @Override
    public boolean updateNote(Note note) throws ServiceException {
        checkNote(note);

        Note updateNote=repository.findByHeader(note.getHeader());

        if(updateNote==null){
            throw new ServiceException("no such note");
        }

        repository.deleteByHeader(updateNote.getHeader());

        updateNote.setData(note.getData());

        repository.save(updateNote);

        return true;
    }

    private void checkNote(Note note) throws ServiceException {
        if(note==null){
            throw new ServiceException("no note");
        }
        if(note.getHeader()==null || note.getHeader().isEmpty() || note.getData()==null || note.getUserID()==null){
            throw new ServiceException("Something is empty");
        }
    }

    @Override
    public boolean deleteNote(String header) throws ServiceException {
        if(header==null || header.isEmpty()){
            throw new ServiceException("no header");
        }

        repository.deleteByHeader(header);

        return true;
    }

    @Override
    public List<Note> getAllNotesByUserID(Long userID) throws ServiceException {
        if(userID==null){
            throw new ServiceException("no UserID");
        }

        return repository.findAllByUserID(userID);
    }

    public NoteDAO getRepository(){
        return repository;
    }
}
