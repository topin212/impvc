package step.impvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * created May 31, 2017
 * 
 */
public class ClassPackageHierarchy {

    private Map<String, List<String>> map;
    
    ClassPackageHierarchy(){
    map = new HashMap<>();
    }
    
    
    public void addClass(String packageName, final String className){
        if(map.containsKey(packageName)){
            map.get(packageName).add(className);
        }else{
            map.put(packageName, new ArrayList(){{add(className);}});
        }
    }
    
    public List<String> getClassesInPackage(String packageName){
        return map.get(packageName);
    }
    
    public Map<String, List<String>> getClassHierarchy(){
        return map;
    }
    
    @Deprecated
    public void show(){
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        
        while(iterator.hasNext()){
            Map.Entry<String, List<String>> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }
    
}
