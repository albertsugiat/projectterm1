package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class FileUtil {
    
    // instance variable: formatter
    private Formatter formatter;
    
    // instance variable: scanner;
    private Scanner scanner;

    // to check if the given path file/directory is exists
    public String checkFileDirExist(String path) {
        File x = new File(path);
        String s = "Error File/Directory Check!";
        if (x.exists()) {
            if (x.isFile()) {
                s = "'" + x.getName() + "' is a File and Exist.";
            } else if (x.isDirectory()) {
                s = "'" + x.getName() + "' is a Directory and Exist.";
            }
        } else {
            s = "This File/Directory does not exist!";
        }
        return s;
    }

    // to create a new emtpy file by given path
    public String createNewEmptyFile(String path) {
        Formatter x;
        String s = "";
        try {
            x = new Formatter(path);
            s = "File '" + path + "' created.";
        } catch (FileNotFoundException e) {
            s = "Error Creating File '" + path + "' : " + e;
        }
        return s;
    }

    // to open the file
    public String openWriteFile(String path) {
        String s = "";
        try {
            formatter = new Formatter(path);
            s = "File '" + path + "' is opening.";
        } catch (FileNotFoundException e) {
            s = "Error Opening File '" + path + "' : " + e;
        }
        return s;
    }

    // to add record/data to opening file
    public String addWriteRecord(String format, Object... objs) {        
        formatter.format(format, objs);        
        return "Record added to file.";
    }

    // to close opening file
    public String closeWriteFile() {        
        formatter.close();        
        return "File closed.";
    }
    
    // to open read file
    public String openReadFile(String path) {
        String s = "";
        try {
            scanner = new Scanner(new File(path));
            s = "File '" + path + "' is opening to read.";
        } catch (FileNotFoundException e) {
            s = "Error Opening Read File '" + path + "' : " + e;
        }
        return s;
    }
    
    // to read opening file
    public Scanner getReadScanner() {
        return this.scanner;
    }
    
    // to close reading file
    public String closeReadFile() {
        scanner.close();
        return "Read file closed.";
    }
    
    // to view basic file properties from given path
    public void fileProperties(String path) {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            System.out.println("File Name\t: " +file.getName());
            System.out.println("File Path\t: " +file.getPath());
            System.out.println("Absoulte Path\t: " +file.getAbsolutePath());
            System.out.println("Parent\t\t: " +file.getParent());
            System.out.println("Last Modified\t: " 
                    +new Date(file.lastModified()));
            System.out.println("File Size\t: " +file.length()+" bytes");
            System.out.println("Readable\t: " +file.canRead());            
            System.out.println("Writable\t: " +file.canWrite());
            System.out.println("Executable\t: " +file.canExecute());            
        }else {
            System.out.println("'"+path+"' file does not exist or directory!");
        }
    }
    
    // to rename file1 to file2
    public void fileRename(String path1, String path2) {
        File file1 = new File(path1);
        if (file1.exists()) {
            File file2 = new File(path2);
            if (file1.renameTo(file2)) {
                System.out.println("'"+file1+"' renamed to '"+file2+"'.");
            }
        }else {
            System.out.println("'"+path1+"' file does not exist or directory!");
        }
    }
    
    // to delete given file path
    public void fileDelete(String path) {
        File file = new File(path);
        if (file.exists() ) {            
            if (file.delete()) {
                System.out.println("'"+file+"' deleted.");
            }
        }else {
            System.out.println("'"+path+"' file does not exist or directory!");
        }
    }
    
    // to list file/directory by given directory path
    public String[] listDirectory(String path) {
        String[] list = null;
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            list = file.list();
        }        
        return list;
    }
    
    // to create a new directory by given directory path
    public void createDirectory(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            if (file.mkdir()) {
                System.out.println("'"+path+"' created.");
            }
        }else {
            System.out.println("'"+path+"' directory exist!");
        }
    }
    
}
