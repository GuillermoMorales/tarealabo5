package com.uca.capas.tarea5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(generator="estudiante_c_usuario_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "estudiante_c_usuario_seq", sequenceName = "public.estudiante_c_usuario_seq", allocationSize = 1)
	@Column(name = "c_usuario")
	private Integer cusuario;
	
	@Size(max=50, message="El nombre no puede tener más de 50 caracteres")
	@NotEmpty(message="Este campo no puede estar vacío")
	@Pattern(regexp="^\\S.*$",message="Nombre no puede estar vacío")
	@Column(name="nombre")
	private String nombre;
	
	@Pattern(regexp="^\\S.*$",message="Apellido no puede estar vacío")
	@Size(max=50, message="El apellido no puede tener más de 50 caracteres")
	@NotEmpty(message="Este campo no puede estar vacío")
	@Column(name="apellido")
	private String apellido;
	
	@Pattern(regexp="\\d{10}", message="Debe ser 10 digitos exactos")
	@NotEmpty(message="Este campo no puede estar vacío")
	@Column(name="carne")
	private String carne;
	
	@Pattern(regexp="^\\S.*$",message="Carrera no puede estar vacío")
	@Size(max=100, message="La carrera no puede tener más de 100 caracteres")
	@NotEmpty(message="Este campo no puede estar vacío")
	@Column(name="carrera")
	private String carrera;

	public Integer getCusuario() {
		return cusuario;
	}

	public void setCusuario(Integer cusuario) {
		this.cusuario = cusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
	
	
}
