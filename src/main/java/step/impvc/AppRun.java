package step.impvc;

import step.impvc.controllers.Controller;
import step.impvc.views.DefaultView;

/**
 *
 * created May 30, 2017
 */
public class AppRun {

    public static void main(String[] args) {
        ClassResolver resolver = new ClassResolver();
        
        
        resolver.warmUp().show();
        
        //Controller controller = resolver.resolveStartController();
        
        //controller.setView(DefaultView.getDefaultView());
    }
    
}
