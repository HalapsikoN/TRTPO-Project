package by.bsuir.trtpo.zapishka.service;

import by.bsuir.trtpo.zapishka.bean.Note;
import by.bsuir.trtpo.zapishka.dao.NoteDAO;
import by.bsuir.trtpo.zapishka.service.exception.AlreadyHadSuchNoteException;
import by.bsuir.trtpo.zapishka.service.exception.IllegalDataInputException;

import java.util.List;

public interface NoteService {

    boolean addNote(Note note) throws AlreadyHadSuchNoteException, IllegalDataInputException;

    Note getNote(String header) throws IllegalDataInputException;

    boolean updateNote(Note note) throws IllegalDataInputException;

    boolean deleteNote(String header) throws IllegalDataInputException;

    List<Note> getAllNotesByUserID(Long userID) throws IllegalDataInputException;

    NoteDAO getRepository();
}
