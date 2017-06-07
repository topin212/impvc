package step.impvc;


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
        
        container.setController(resolver.resolveStartController());
        
        //TODO use some sort of app run
        
        
        //Controller controller = resolver.resolveStartController();
        //controller.setView(DefaultView.getDefaultView());
    }
    
}
