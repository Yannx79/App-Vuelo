
package interfaces;

import java.util.List;

public interface ObjectIDAO <T> {

    public abstract boolean create(T t);
    
    public abstract T read(Object key);
    
    public abstract List<T> readAll();
    
    public abstract boolean update(T t);
    
    public abstract boolean delete(Object key);
    
}
