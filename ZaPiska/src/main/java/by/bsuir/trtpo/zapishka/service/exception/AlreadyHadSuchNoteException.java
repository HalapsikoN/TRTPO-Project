package by.bsuir.trtpo.zapishka.service.exception;

public class AlreadyHadSuchNoteException extends Exception {

    public AlreadyHadSuchNoteException() {
        super();
    }

    public AlreadyHadSuchNoteException(String message) {
        super(message);
    }

    public AlreadyHadSuchNoteException(Exception e) {
        super(e);
    }

    public AlreadyHadSuchNoteException(String message, Exception e) {
        super(message, e);
    }
}
