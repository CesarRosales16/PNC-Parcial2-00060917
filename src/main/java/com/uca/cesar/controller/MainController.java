package com.uca.cesar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cesar.domain.Categoria;
import com.uca.cesar.domain.Libro;
import com.uca.cesar.service.CategoriaService;
import com.uca.cesar.service.LibroService;

@Controller
public class MainController {

	@Autowired
	LibroService libroService;

	@Autowired
	CategoriaService categoriaService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/ingresarCategoria")
	public ModelAndView insertarCategoria() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria", new Categoria());
		mav.setViewName("formCategoria");
		return mav;
	}

	@RequestMapping("/ingresarLibro")
	public ModelAndView insertarLibro() {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorias = null;
		try {
			categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("libro", new Libro());
		mav.addObject("categorias", categorias);
		mav.setViewName("formLibro");
		return mav;
	}

	@RequestMapping("/resultadoCategoria")
	public ModelAndView resultadoCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if (!(result.hasErrors())) {

			try {
				categoriaService.save(categoria);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("resultadoCategoria", 1);
			mav.setViewName("index");
			return mav;
		}
		mav.setViewName("formCategoria");
		return mav;
	}

	@RequestMapping("/resultadoLibro")
	public ModelAndView resultadoLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if (!(result.hasErrors())) {

			try {
				libroService.save(libro);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("resultadoLibro", 1);
			mav.setViewName("index");
			return mav;
		}
		List<Categoria> categorias = null;
		try {
			categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("categorias", categorias);
		mav.setViewName("formLibro");
		return mav;
	}

	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;

		try {
			libros = libroService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("libros", libros);
		mav.setViewName("listado");
		return mav;

	}
}
