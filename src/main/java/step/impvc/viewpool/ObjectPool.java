package step.impvc.viewpool;

import java.util.List;

/**
 *
 * created May 30, 2017
 */
//Not actually a pool, though
//Not actually needed here, though
public abstract class ObjectPool<T>{
    
    List<T> pool;
    
    public abstract T getObject(int id);
    public abstract void addObject(T object);
}
