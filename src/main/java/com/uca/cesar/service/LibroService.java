package com.uca.cesar.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.cesar.domain.Libro;

public interface LibroService {

	public List<Libro> findAll() throws DataAccessException;

	public void save(Libro libro) throws DataAccessException;

}
