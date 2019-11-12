package by.bsuir.trtpo.zapishka.service;

import by.bsuir.trtpo.zapishka.bean.Note;
import by.bsuir.trtpo.zapishka.dao.NoteDAO;

import java.util.List;

public interface NoteService {

    boolean addNote(Note note) throws ServiceException;

    Note getNote(String header) throws ServiceException;

    boolean updateNote(Note note) throws ServiceException;

    boolean deleteNote(String header) throws ServiceException;

    List<Note> getAllNotesByUserID(Long userID) throws ServiceException;

    NoteDAO getRepository();
}
