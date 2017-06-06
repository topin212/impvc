package step.impvc.reflection;

import java.util.ArrayList;
import java.util.List;
import step.impvc.annotations.Controller;

/**
 * created Jun 1, 2017
 * 
 */
public class Reflector {

    public List<Class> resolveControllers(List<Class> classList){
        List<Class> resultList = new ArrayList<>();
        
        for(Class elClasso : classList)
            if(elClasso.getAnnotation(Controller.class)!=null)
                resultList.add(elClasso);
        
        return resultList;
    }
    
    public List<Class> resolveAnnotation(List<Class> classList, Class annotationClass){
        List<Class> resultList = new ArrayList<>();
        
        for(Class elClasso : classList){
            if(elClasso.getAnnotation(annotationClass)!=null)
                resultList.add(elClasso);
        }
        return resultList;
    }
}
