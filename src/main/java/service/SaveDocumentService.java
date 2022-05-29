package service;

import context.ControllerContext;
import context.ProjectContext;
import entity.Document;
import entity.Method;
import repository.UsedMethodRepository;

import java.util.List;

public class SaveDocumentService {
    private static SaveDocumentService instance;
    private SaveDocumentService() { }
    public static SaveDocumentService getInstance()
    {
        if(instance==null)
        {
            instance = new SaveDocumentService();
        }
        return instance;
    }
    public void save(String docName)
    {
        Document document = new Document(docName);
        List<Method> methods = UsedMethodRepository.getInstance().getAll();
        for (Method method : methods) {
            document.addMethod(method);
        }
        String date = ControllerContext.getInstance().getDocumentController().getDateField().getText();
        document.setDate(date);
        ProjectContext.getInstance().getProject().addDocument(document);
        SaveService.getInstance().save(ProjectContext.getInstance().getProject());
        UsedMethodRepository.getInstance().erase();
        ControllerContext.getInstance().getDocumentController().close();
    }
    public void saveEdited(Document document, String docName)
    {
        List<Method> methods = UsedMethodRepository.getInstance().getAll();
        for (Method method : methods) {
            document.addMethod(method);
        }
        List<Document> documents = ProjectContext.getInstance().getProject().getDocuments();
        for (int i = 0; i < documents.size(); i++) {
            if(documents.get(i).getName().equals(document.getName()))
            {
                document.setName(docName);
                documents.set(i, document);
                break;
            }
        }
        SaveService.getInstance().save(ProjectContext.getInstance().getProject());
        UsedMethodRepository.getInstance().erase();
        ControllerContext.getInstance().getEditDocumentController().close();
    }
}
