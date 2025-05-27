import java.util.List;

public interface GenericCRUD<T, ID> {
    void create(T obj);
    void update(T obj);
    void delete(ID id);
    T getById(ID id);
    List<T> getAll();
}
