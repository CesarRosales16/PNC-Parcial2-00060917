package com.uca.cesar.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.cesar.domain.Categoria;

public interface CategoriaService {

	public List<Categoria> findAll() throws DataAccessException;

	public Categoria findOne(Integer codigo) throws DataAccessException;

	public void save(Categoria categoria) throws DataAccessException;
}
