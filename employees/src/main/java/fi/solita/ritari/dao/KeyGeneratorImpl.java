package fi.solita.ritari.dao;

import java.util.concurrent.atomic.AtomicLong;

public class KeyGeneratorImpl implements KeyGenerator {

	private AtomicLong keyValue = new AtomicLong();
	
	@Override
	public Long incrementAndGet() {
		return Long.valueOf(keyValue.getAndIncrement());
	}

}
