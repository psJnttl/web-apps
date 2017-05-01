package fi.solita.ritari.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryDatabaseImpl<K extends Serializable, E> implements InMemoryDatabase<K, E> {

	private HashMap<K, E> database = new HashMap<K, E>();

	public InMemoryDatabaseImpl() {
		
	}

	@Override
	public List<E> getAll() {
	    return new ArrayList<E>(database.values());
	}

	@Override
	public E get(K key) {
		return database.get(key);
	}

	@Override
	public Optional<E> find(K key) {
		return Optional.ofNullable(database.get(key));
	}

	@Override
	public List<E> find(Predicate<E> predicate) {
		return database.values().stream().filter(predicate).collect(Collectors.<E>toList());
	}

	@Override
	public void modify(K key, E value) {
		database.put(key, value);
	}

	@Override
	public void delete(K key) {
		database.remove(key);		
	}

	@Override
	public K insert(K keyValue, E value) {
		database.put(keyValue, value);
		return keyValue;
	}

}
