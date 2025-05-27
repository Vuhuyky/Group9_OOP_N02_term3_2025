import java.util.*;

public abstract class GenericService<T, ID> implements GenericCRUD<T, ID> {
    protected Map<ID, T> data = new HashMap<>();

    @Override
    public void create(T obj) {
        data.put(getId(obj), obj);
    }

    @Override
    public void update(T obj) {
        data.put(getId(obj), obj);
    }

    @Override
    public void delete(ID id) {
        data.remove(id);
    }

    @Override
    public T getById(ID id) {
        return data.get(id);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(data.values());
    }

    protected abstract ID getId(T obj);
}