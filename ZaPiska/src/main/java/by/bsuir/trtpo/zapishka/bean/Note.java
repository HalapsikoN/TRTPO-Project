package by.bsuir.trtpo.zapishka.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "notes")
public class Note {

    @Id
    private String id = UUID.randomUUID().toString();

    private String header;
    private String data;
    private Long userID;

    public Note(Long userID, String header, String data) {
        this.header = header;
        this.data = data;
        this.userID = userID;
    }

    public Note() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id.equals(note.id) &&
                header.equals(note.header) &&
                data.equals(note.data) &&
                userID.equals(note.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, header, data, userID);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", header='" + header + '\'' +
                ", data='" + data + '\'' +
                ", userID=" + userID +
                '}';
    }
}
