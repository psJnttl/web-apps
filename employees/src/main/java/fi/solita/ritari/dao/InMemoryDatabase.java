package fi.solita.ritari.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface InMemoryDatabase<K extends Serializable, E> {

	List<E> getAll();
	
    E get(K key);

    Optional<E> find(K key);

    List<E> find(Predicate<E> predicate);

    void modify(K key, E value);

    void delete(K key);

    K insert(K keyValue, E value);
}
