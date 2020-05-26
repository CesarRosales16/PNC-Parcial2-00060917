package com.uca.cesar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.cesar.dao.LibroDAO;
import com.uca.cesar.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroDAO libroDAO;

	@Autowired
	CategoriaService categoriaService;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		return libroDAO.findAll();
	}

	@Override
	public void save(Libro libro) throws DataAccessException {
		libro.setFechaIngreso(new Date());
		libro.setCategoria(categoriaService.findOne(libro.getCodigoCategoria()));
		libroDAO.save(libro);

	}

}