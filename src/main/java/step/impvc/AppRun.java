package step.impvc;

import java.util.logging.Level;
import java.util.logging.Logger;
import step.impvc.controllers.Controller;
import step.impvc.reflection.Reflector;


/**
 *
 * created May 30, 2017
 */
public class AppRun {

    public static void main(String[] args) {
        ClassResolver resolver = new ClassResolver();
        resolver.setControllerPackage("step.impvc.controllers");
        
        resolver.warmUp().show();
        
        ControllerContainer container = new ControllerContainer();
        
        
       
        
        
        //Controller controller = resolver.resolveStartController();
        //controller.setView(DefaultView.getDefaultView());
        
        
        
            //Controller controller = resolver.resolveStartController();
            
            //controller.setView(DefaultView.getDefaultView());
    }
    
}
