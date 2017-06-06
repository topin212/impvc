package step.impvc;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import step.impvc.controllers.Controller;
import step.impvc.models.Model;
import step.impvc.reflection.Reflector;
import step.impvc.views.View;

/**
 *
 * created May 30, 2017
 */
public class ClassResolver {
    
    ClassPathScanner scanner;
    Reflector reflector;
    String controllerPackageName;
    
    public  ClassResolver() {
        try {
            this.scanner = new ClassPathScanner(this.getClass().getClassLoader().getResources(""));
        } catch (IOException ex) {
            Logger.getLogger(ClassResolver.class.getName()).log(Level.SEVERE, "ClassResolver constructor failed." , ex);
        }
    }
    
    public ClassPackageHierarchy warmUp(){
        try {
            return scanner.getClassPathFileNames();
        } catch (IOException ex) {
            Logger.getLogger(ClassResolver.class.getName()).log(Level.SEVERE, "exception during class resolver warm up.", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClassResolver.class.getName()).log(Level.SEVERE, "className was not valid", ex);
        }
        return null;
    }
    
    //TODO fill methods
    public List<Class> resolveControllers(String targetPackage){
        return scanner.getClassNames().getClassesInPackage(targetPackage);
    }
    
    public Controller resolveStartController(){
        return null;
    }
    
    public View[] resolveViews(String targetPackage){
        return null;
    }

    
    public View resolveView(String className){
        return null;
    }
    
    public Model[] resolveModels(String targetPackage){
        return null;
    }
    
    
    public Model resolveModel(String className){
        return null;
    }
    
    public void setControllerPackage(String packageName){
        this.controllerPackageName = packageName;
    }
}
