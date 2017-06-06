package step.impvc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * created May 30, 2017
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface View {
    
}
