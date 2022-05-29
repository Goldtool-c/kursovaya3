package project;

import entity.Document;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String companyName;
    private String projectName;
    private String version;
    private String checksum;
    private List<Document> documents = new ArrayList<>();

    public Project(String companyName, String projectName, String version, String checksum) {
        this.companyName = companyName;
        this.projectName = projectName;
        this.version = version;
        this.checksum = checksum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public List<Document> getDocuments() {
        return documents;
    }
    public void addDocument(Document doc)
    {
        documents.add(doc);
    }
    public Document getDocument(int id)
    {
        return documents.get(id);
    }
}
