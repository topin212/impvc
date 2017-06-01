package step.impvc;

import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created May 30, 2017
 * 
 */
public class ClassPathScanner {
    
    private Enumeration<URL> resourceRoots;
    private ClassPackageHierarchy classNames;
    
    public ClassPathScanner() {
    }
    
    public ClassPathScanner(Enumeration<URL> resources){
        this.resourceRoots = resources;
        this.classNames = new ClassPackageHierarchy();
    }
    
    public ClassPackageHierarchy getClassPathFileNames() throws IOException{
        
        while(resourceRoots.hasMoreElements()){
            URL resource = resourceRoots.nextElement();
            Path localPath = fixPath(resource.toString());
            getFolderContents(localPath);
        }
        return classNames;
    }
    
    public void getFolderContents(Path folder) throws IOException{
        DirectoryStream<Path> stream = Files.newDirectoryStream(folder);
        for(Path file: stream){
            classNames.addClass(pathToPackageName(folder.toString()),file.getFileName().toString());
            if(file.toFile().isDirectory()){
                getFolderContents(file);
            }
        }
    }
    
    public Path fixPath(String classPath){
        String parsedPath;
        Pattern pattern = Pattern.compile("[A-Z]:\\/[^$]+$");
        Matcher m = pattern.matcher(classPath);
        if(m.find()){
            parsedPath = m.group();
        }else{
            parsedPath = null;
        }
        return Paths.get(parsedPath);
    }
    
    public String pathToPackageName(String path){
        Pattern p = Pattern.compile("\\\\classes\\\\([^$]+)$");
        Matcher m = p.matcher(path);
        if(m.find()){
            return m.group(1).replace("\\", ".");
        }
        return "";
    }
}
