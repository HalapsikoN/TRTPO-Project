package by.bsuir.trtpo.zapishka.service;

import by.bsuir.trtpo.zapishka.service.impl.NoteServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance=new ServiceFactory();

    private final NoteService noteServiceImpl=new NoteServiceImpl();

    public static ServiceFactory getInstance(){
        return instance;
    }

    public NoteService getNoteService() {
        return noteServiceImpl;
    }
}
