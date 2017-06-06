package step.impvc;

import step.impvc.observing.Actions;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import step.impvc.controllers.Controller;
import step.impvc.models.Model;
import step.impvc.observing.MVCActionObserver;
import step.impvc.views.View;

/**
 * created Jun 2, 2017
 * 
 */
public class ControllerContainer {
    private Controller controller;
    private View view;
    private Model model;
    
    private HashMap<String, MVCActionObserver> events;

    public Controller getController() {
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public View getView() {
        return view;
    }
    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    

    //Array of three elements? will work for a single-threaded implementation 
    private List<MVCActionObserver> listener;
    
    private Actions action;
    
    //TODO finish eventLoop
    public void eventLoop(){
        //get action here
        while(action != Actions.QUIT){
            switch(action){
                case TRIGGER_VIEW_UPDATE :
                    break;
                case TRIGGER_MODEL_UPDATE :
                    break;
                case SET_VIEW :
                    break;
                case NOTIFY_USER_INTERACTION :
                    break;
                case GET_MODEL_STATE :
                    break;
                default: 
                    throw new IllegalArgumentException("unknown value at event loop" + action);
            }
        }
    }
}
