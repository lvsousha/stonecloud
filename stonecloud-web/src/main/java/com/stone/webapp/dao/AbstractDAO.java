package com.stone.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractDAO<T> extends JpaRepository<T, Long> {
	
	public T findById(Long id);
}
