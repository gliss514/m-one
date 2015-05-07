package com.mone.core.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public abstract class ProjGService<T> {

	protected abstract ProjGRepository<T> getRepository();

	public Iterable<T> findAll() {
		return getRepository().findAll();
	}

	public Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	public T findOne(String id) {
		return getRepository().findOne(id);
	}

	public void delete(T entities) {
		getRepository().delete(entities);
	}

	public void delete(Iterable<? extends T> entities) {
		getRepository().delete(entities);
	}

	public void delete(String id) {
		getRepository().delete(id);
	}

	public void delete(String[] ids) {
		for (String id : ids) {
			getRepository().delete(id);
		}
	}

	public void deleteAll() {
		getRepository().deleteAll();
	}

	public boolean exists(String id) {
		return getRepository().exists(id);
	}

	public T save(T entity) {
		return getRepository().save(entity);
	}

	public Iterable<T> save(Iterable<T> entities) {
		return getRepository().save(entities);
	}

}
