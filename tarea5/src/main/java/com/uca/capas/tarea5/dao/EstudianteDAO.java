package com.uca.capas.tarea5.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.tarea5.domain.Estudiante;

public interface EstudianteDAO {
	
	public List<Estudiante> findAll() throws DataAccessException;
	public  Estudiante findOne(Integer codigo) throws DataAccessException;
	public void save(Estudiante c) throws DataAccessException;

}
