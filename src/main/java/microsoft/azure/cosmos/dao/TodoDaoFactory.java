package microsoft.azure.cosmos.dao;

public class TodoDaoFactory {
    private static TodoDao myTodoDao = new DocDbDao();

    public static TodoDao getDao() {
        return myTodoDao;
    }
}