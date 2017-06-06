package step.impvc.observing;

import java.util.HashMap;
import java.util.Map;

/**
 * created Jun 3, 2017
 * 
 */
public class ActionArgs {
    private Map<String, Object> args;
    
    public  ActionArgs() {
        this.args = new HashMap();
    }
    
    public ActionArgs add(String name, Object value){
        args.put(name, value);
        return this;
    }
    
    public ActionArgs remove(String name){
        args.remove(name);
        return this;
    }
}
