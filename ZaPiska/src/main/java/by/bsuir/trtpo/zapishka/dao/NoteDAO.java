package by.bsuir.trtpo.zapishka.dao;

import by.bsuir.trtpo.zapishka.bean.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteDAO extends MongoRepository<Note, String> {

    boolean existsByHeaderAndUserID(String header, Long UserID);

    Note findByHeaderAndUserID(String header, Long UserID);

    void deleteByHeaderAndUserID(String header, Long UserID);

    List<Note> findAllByUserID(Long userID);
}
