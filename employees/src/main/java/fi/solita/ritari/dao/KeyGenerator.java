package fi.solita.ritari.dao;

public interface KeyGenerator<K> {
	K incrementAndGet();
}
