package com.uca.cesar.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {

	@Id
	@GeneratedValue(generator = "cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)
	@Column(name = "c_libro")
	private Integer codigoLibro;

	@Column(name = "s_titulo")
	@Size(message = "El campo sobrepasa la cantidad de 500 caracteres", max = 500)
	@NotEmpty(message = "El campo titulo no puede estar vacío")
	private String titulo;

	@Column(name = "s_autor")
	@Size(message = "El campo sobrepasa la cantidad de 150 caracteres", max = 150)
	@NotEmpty(message = "El campo autor no puede estar vacío")
	private String autor;

	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm a")
	@Column(name = "f_ingreso")
	private Date fechaIngreso;

	@Column(name = "b_estado")
	private Boolean estado;

	@Column(name = "s_isbn")
	@Size(message = "El campo sobrepasa la cantidad de 10 caracteres", max = 10)
	@NotEmpty(message = "El campo ISBN no puede estar vacío")
	private String isbn;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;

	@Transient
	private Integer codigoCategoria;

	public Libro() {
	}

	public Integer getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getBactivoDelegate() {
		if (this.estado == null) {
			return "";
		} else {
			if (this.estado)
				return "ACTIVO";
			else
				return "INACTIVO";
		}
	}
	public String getFechaIngresoDelegate() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		return formato.format(fechaIngreso);
	}
}
