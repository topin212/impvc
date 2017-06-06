package step.impvc.controllers;

import step.impvc.annotations.Controller;
import step.impvc.models.DefaultModel;
import step.impvc.models.Model;
import step.impvc.observing.Actions;

/**
 *
 * created May 30, 2017
 */

@Controller
public class DefaultController implements step.impvc.controllers.Controller{
    
    public void userAction(/*Actions userAction?
                            *String methodName, Object[] args?
                            */){
        //User logic here, if inherited from DefaultController
        
        //for this example - user interaction with a model;
        
        DefaultModel model = getControllerRelatedModel();
        
        int a = 1;
        int b = 2;
        
        int result = a+b;
        
        
        updateField("moneyBalance", result);
        
    }
    
    @Override
    public void updateModel(Model model, Actions action, Object[] args) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //TODO replace stub with actual model
    public DefaultModel getControllerRelatedModel(){
        return new DefaultModel();
    }
    
    public void updateField(String fieldName, Object value){
        //Fire event
    }
}
