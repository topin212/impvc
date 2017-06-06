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

    public ClassPackageHierarchy getClassNames() {
        return classNames;
    }
    
    public ClassPathScanner() {
    }
    
    public ClassPathScanner(Enumeration<URL> resources){
        this.resourceRoots = resources;
        this.classNames = new ClassPackageHierarchy();
    }
    
    public ClassPackageHierarchy getClassPathFileNames() throws IOException, ClassNotFoundException{
        
        URL resource;
        do{
            resource = resourceRoots.nextElement();
            Path localPath = fixPath(resource.toString());
            getFolderContents(localPath);
        }while(resourceRoots.hasMoreElements());
        
        classNames.setDomainName(fixPath(resource.toString()).toString());
        return classNames;
    }
    
    //TODO requires heavy refactor
    public void getFolderContents(Path folder) throws IOException, ClassNotFoundException{
        DirectoryStream<Path> stream = Files.newDirectoryStream(folder);
        String folderPath = folder.toString();
        String packageName = pathToPackageName(folderPath);
        String className;
        
        
        for(Path file: stream){
           className = refineClassName(file.getFileName().toString());
            if(packageNameIsValid(packageName) && classNameIsValid(className)){
                try{
                    if(file.toFile().isFile())
                        classNames.addClass(packageName,Class.forName(packageName + "." + className));
                }catch(ClassNotFoundException ex){
                    System.out.println("SEVERE");
                    System.out.println("========================================");
                    System.out.println("Class " + className + " cannot be found.");
                    System.out.println("Package " + packageName);
                    System.out.println(ex.getMessage());
                    System.out.println("========================================");
                    
                }
            } 
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
    
    public String getInversedDomainNameFromPath(String path){        
        Pattern p = Pattern.compile("\\\\classes\\\\([^\\\\]+\\\\[^\\\\]+)\\\\[^$]+$");
        Matcher m = p.matcher(path);
        
        if(m.find())
            return m.group(1);
        return "";
    }
    
    public String refineClassName(String className){
        Pattern p = Pattern.compile("^([^\\.]+)");
        Matcher m = p.matcher(className);
        
        if(m.find())
            return m.group(1);
        return "";
    }
    
    public boolean classNameIsValid(String className){
        return !className.contains("$");
    }
    public boolean packageNameIsValid(String packageName){
        return !packageName.isEmpty();
    }
}
