package step.impvc;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    Map<String, Controller> controllers;
    Map<String, View> views;
    Map<String, Model> models;
    
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
    
    //TODO fill ClassResolver methods
    //TODO write exceptionWrapper
    public Map<String, Controller> resolveControllers(){
        List<Class> classList = scanner.getClassNames().getClassesInPackage(controllerPackageName);
//        classList.forEach((Object x) -> {
//            try {
//                Class.forName(x.getClass().getName());
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(ClassResolver.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        
        //TODO fix this lame solution
        Iterator<Class> it = classList.iterator();
        while(it.hasNext()){
            Class elClasso = it.next();
            try {
                this.controllers.put(elClasso.getName(), (Controller) elClasso.newInstance());
            } catch (IllegalAccessException | InstantiationException ex) {
                Logger.getLogger(ClassResolver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return this.controllers;
    }
    public Controller resolveController(String controllerName){
        return this.controllers.get(controllerName);
    }
    public Controller resolveStartController(){
        Controller result = null;
        List<Class> controllerList = scanner.getClassNames().getClassesInPackage(controllerPackageName);
        
        //TODO change annotation to actual start controller annotation
        for(Class elClasso : controllerList){
            if(elClasso.getAnnotation(elClasso)!=null){
                try {
                    return (Controller) elClasso.newInstance();
                } catch (IllegalAccessException | InstantiationException ex) {
                    Logger.getLogger(ClassResolver.class.getName()).log(Level.SEVERE, "start controller was not resolved", ex);
                }
            }
        }
        return result;
    }
    
    public Map<String, View> resolveViews(String targetPackage){
        List<Class> viewList = scanner.getClassNames().getClassesInPackage(targetPackage);
        
        Iterator<Class> it = viewList.iterator();
        
        while(it.hasNext()){
            Class view = it.next();
            try {
                this.views.put(view.getName(), (View) view.newInstance());
            } catch (IllegalAccessException | InstantiationException ex) {
                Logger.getLogger(ClassResolver.class.getName()).log(Level.SEVERE, "views were not resolved properly. Do you have your @View annotation set up correctly, or maybe the view package was not set correctly", ex);
            }
        }
        return this.views;
    }
    public View resolveView(String viewName){
        return this.views.get(viewName);
    }
    
    public View resolveViewForController(String controllerName){
        String escapedControllerPackageName = this.controllerPackageName;
        
        Pattern p = Pattern.compile(this.controllerPackageName + "." + controllerName);
        Matcher m = p.matcher(controllerName);
        
        if(m.find()){
            return (View) Class.forName(m.group(1));
        }
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
