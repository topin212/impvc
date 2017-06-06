package step.impvc.models;

import java.util.logging.Level;
import java.util.logging.Logger;
import step.impvc.annotations.method.Update;

/**
 *
 * created May 30, 2017
 */
public class DefaultModel implements Model{

    //?
    @Update
    private int moneyBalance;
    
    
    public void updateField(String fieldName, Object arg) {
        try {
            getClass().getDeclaredField(fieldName).set(this, arg);
        } catch (NoSuchFieldException | SecurityException | 
                 IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(DefaultModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
