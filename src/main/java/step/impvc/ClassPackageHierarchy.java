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

    private Map<String, List<Class>> resourceMap;
    private String domainName;
    
    ClassPackageHierarchy(){
        resourceMap = new HashMap<>();
    }
    
    
    public void addClass(String packageName, final Class className){
        if(resourceMap.containsKey(packageName)){
            resourceMap.get(packageName).add(className);
        }else{
            resourceMap.put(packageName, new ArrayList(){{add(className);}});
        }
    }
    
    public void setDomainName(String domainName){
        this.domainName = domainName;
    }
    
    public String getDomainName(){
        return this.domainName;
    }
    
    public List<Class> getClassesInPackage(String packageName){
        return resourceMap.get(packageName);
    }
    
    public Map<String, List<Class>> getClassHierarchy(){
        return resourceMap;
    }
    
   
    @Deprecated
    public void show(){
        Iterator<Map.Entry<String, List<Class>>> iterator = resourceMap.entrySet().iterator();
        
        while(iterator.hasNext()){
            Map.Entry<String, List<Class>> next = iterator.next();
            System.out.println(next.getKey());
            //System.out.println(next.getValue());
            System.out.print("[ ");
            for(Class elClasso : next.getValue()){
                System.out.print(elClasso.getName() + " ");
            }
            System.out.print("]");
            System.out.println("");
        }
    }
    
}
