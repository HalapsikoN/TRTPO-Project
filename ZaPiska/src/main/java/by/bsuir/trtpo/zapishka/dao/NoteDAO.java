package by.bsuir.trtpo.zapishka.dao;

import by.bsuir.trtpo.zapishka.bean.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteDAO extends MongoRepository<Note, String>{

    boolean existsByHeader(String header);
    Note findByHeader(String header);
    void deleteByHeader(String header);
    List<Note> findAllByUserID(Long userID);
}
