package by.bsuir.trtpo.zapishka.service.impl;

import by.bsuir.trtpo.zapishka.bean.Note;
import by.bsuir.trtpo.zapishka.dao.NoteDAO;
import by.bsuir.trtpo.zapishka.service.NoteService;
import by.bsuir.trtpo.zapishka.service.exception.AlreadyHadSuchNoteException;
import by.bsuir.trtpo.zapishka.service.exception.IllegalDataInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO repository;

    @Override
    public boolean addNote(Note note, Long userID) throws AlreadyHadSuchNoteException, IllegalDataInputException {
        checkNote(note);

        if (repository.existsByHeaderAndUserID(note.getHeader(), userID)) {
            throw new AlreadyHadSuchNoteException(String.valueOf(repository.findByHeaderAndUserID(note.getHeader(), userID).getId()));
        }

        repository.save(note);
        return true;
    }

    @Override
    public Note getNote(String header, Long userID) throws IllegalDataInputException {
        if (header == null || header.isEmpty()) {
            throw new IllegalDataInputException("no header");
        }

        return repository.findByHeaderAndUserID(header, userID);
    }

    @Override
    public boolean updateNote(Note note) throws IllegalDataInputException {
        checkNote(note);

        repository.save(note);

        return true;
    }

    private void checkNote(Note note) throws IllegalDataInputException {
        if (note == null) {
            throw new IllegalDataInputException("no note");
        }
        if (note.getHeader() == null || note.getHeader().isEmpty() || note.getData() == null || note.getUserID() == null) {
            throw new IllegalDataInputException("Something is empty");
        }
    }

    @Override
    public boolean deleteNote(String header, Long userID) throws IllegalDataInputException {
        if (header == null || header.isEmpty()) {
            throw new IllegalDataInputException("no header");
        }

        repository.deleteByHeaderAndUserID(header, userID);

        return true;
    }

    @Override
    public List<Note> getAllNotesByUserID(Long userID) throws IllegalDataInputException {
        if (userID == null) {
            throw new IllegalDataInputException("no UserID");
        }

        return repository.findAllByUserID(userID);
    }

    public NoteDAO getRepository() {
        return repository;
    }
}
