package entity;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandle {
    private String path;
    private String fileName;
    private final String PREFIX = "\\.";
    private final String SLASH = "/";
    private final String FILETYPE = ".bmp";
    private File file;
    private DataOutputStream out;

    public FileHandle(String path, String fileName) throws IllegalArgumentException, IOException {
        this.path = path;
        this.fileName = fileName;
        validation();
        cleanParameters();
        initialization();
    }

    private void validation(){
        if(path == null || fileName == null || path.isEmpty() || fileName.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    public static FileHandle getInstance(String path, String fileName) throws IllegalArgumentException, IOException{
        return new FileHandle(path, fileName);
    }

    private void cleanParameters(){
        path = path.trim();

        if (!path.endsWith("/")){
           path = path.concat("/");
        }

        if(fileName.contains(PREFIX)){
            String[] split = fileName.split(PREFIX);
            fileName = split[0].trim();
        }

    }

    public DataOutputStream getOut() {
        return out;
    }

    private void initialization() throws IOException {
        File file = new File(path + fileName + FILETYPE);
        this.file = file;

        try {
          file.createNewFile();

          out = new DataOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
