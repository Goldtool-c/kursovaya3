package context;

import controller.*;

public class ControllerContext {
    private static ControllerContext instance;
    private MainController mainController;
    private DocumentController documentController;
    private ProjectController projectController;
    private AddMethodController addMethodController;
    private EditDocumentController editDocumentController;
    private ControllerContext(){}
    public static ControllerContext getInstance()
    {
        if(instance == null)
        {
            instance = new ControllerContext();
        }
        return instance;
    }

    public DocumentController getDocumentController() {
        return documentController;
    }

    public void setDocumentController(DocumentController documentController) {
        this.documentController = documentController;
    }

    public ProjectController getProjectController() {
        return projectController;
    }

    public void setProjectController(ProjectController projectController) {
        this.projectController = projectController;
    }

    public AddMethodController getAddMethodController() {
        return addMethodController;
    }

    public void setAddMethodController(AddMethodController addMethodController) {
        this.addMethodController = addMethodController;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public EditDocumentController getEditDocumentController() {
        return editDocumentController;
    }

    public void setEditDocumentController(EditDocumentController editDocumentController) {
        this.editDocumentController = editDocumentController;
    }
}
