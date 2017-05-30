package step.impvc;

import java.net.URL;
import step.impvc.controllers.Controller;
import step.impvc.models.Model;
import step.impvc.views.View;

/**
 *
 * created May 30, 2017
 */
public class ClassResolver {
    
    
    
    public String[] warmUp(){
        URL resource = this.getClass().getClassLoader().getResource("");
        
        
        return null;
    }
    
    //TODO fill methods
    public Controller[] resolveControllers(String targetPackage){
        
        return null;
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
}
