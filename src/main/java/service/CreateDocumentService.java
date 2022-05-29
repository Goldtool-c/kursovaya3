package service;

public class CreateDocumentService {
    private static CreateDocumentService instance;
    private CreateDocumentService(){}
    public static CreateDocumentService getInstance()
    {
        if(instance==null)
        {
            instance = new CreateDocumentService();
        }
        return instance;
    }
}
