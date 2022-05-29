package context;

import project.Project;

public class ProjectContext {
    private static ProjectContext instance;
    private Project project;
    private ProjectContext(){}
    public static ProjectContext getInstance()
    {
        if(instance == null)
        {
            instance = new ProjectContext();
        }
        return instance;
    }
    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
