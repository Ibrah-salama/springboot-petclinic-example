package guru.springframework.sfgpetclinicv2.services;

import java.util.Set;

public interface CrudService<T,ID> {
    Set<T> findAll();
    T fndById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
