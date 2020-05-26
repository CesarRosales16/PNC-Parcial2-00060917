package com.uca.cesar.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.cesar.domain.Libro;

public interface LibroDAO {

	public List<Libro> findAll() throws DataAccessException;

	public void save(Libro libro) throws DataAccessException;

}
