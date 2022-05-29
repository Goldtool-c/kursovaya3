package service;

import project.Project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SaveService {
    private static SaveService instance;
    private String directory = "projects/";
    private SaveService() { }
    public static SaveService getInstance()
    {
        if(instance==null)
        {
            instance = new SaveService();
        }
        return instance;
    }
    public void save(Project project)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("cn|"); sb.append(project.getCompanyName()); sb.append('\n');
        sb.append("pn|"); sb.append(project.getProjectName()); sb.append('\n');
        sb.append("cs|"); sb.append(project.getChecksum()); sb.append('\n');
        sb.append("v|"); sb.append(project.getVersion()); sb.append('\n');
        File dir = new File(directory+project.getCompanyName());
        dir.mkdir();
        File file = new File(directory+project.getCompanyName()+"/"+project.getProjectName()+".prj");
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(project.getDocuments().size()!=0)
        {
            sb.append(project.getDocuments().toString());
            sb.append('\n');
        }
        log(sb.toString(), file);

    }
    private void log(String message, File file)
    {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, false);
            Writer writer = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            writer.write(message);
            writer.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
