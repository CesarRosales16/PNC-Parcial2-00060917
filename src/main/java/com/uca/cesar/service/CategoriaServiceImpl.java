package com.uca.cesar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.cesar.dao.CategoriaDAO;
import com.uca.cesar.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDAO.findAll();
	}

	@Override
	public Categoria findOne(Integer codigo) throws DataAccessException {
		return categoriaDAO.findOne(codigo);
	}

	@Override
	public void save(Categoria categoria) throws DataAccessException {
		categoriaDAO.save(categoria);

	}

}
