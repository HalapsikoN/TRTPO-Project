package by.bsuir.trtpo.zapishka.dao;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

   // private final NoteDAO noteDAOImpl=new NoteDAOImpl();

    public static DAOFactory getInstance(){
        return instance;
    }

  //  public NoteDAO getNoteDAO(){
  //      return noteDAOImpl;
  //  }
}
