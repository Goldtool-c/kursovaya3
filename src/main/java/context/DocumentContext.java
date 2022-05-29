package context;

import entity.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentContext {
    private static DocumentContext instance;
    private Document document;
    private List<Document> documents = new ArrayList<>();
    private DocumentContext(){}
    public static DocumentContext getInstance()
    {
        if(instance == null)
        {
            instance = new DocumentContext();
        }
        return instance;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    public void addDocument(Document doc)
    {
        documents.add(doc);
    }
    public Document get(int id)
    {
        return documents.get(id);
    }
}
