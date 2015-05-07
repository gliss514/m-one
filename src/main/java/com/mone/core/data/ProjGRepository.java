package com.mone.core.data;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface ProjGRepository<T> extends PagingAndSortingRepository<T, String> {
	
}
