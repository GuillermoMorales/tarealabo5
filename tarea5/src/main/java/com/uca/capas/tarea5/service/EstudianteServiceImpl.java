package com.uca.capas.tarea5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.tarea5.dao.EstudianteDAO;
import com.uca.capas.tarea5.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	EstudianteDAO estudianteDao;

	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteDao.findAll();
	}

	public Estudiante findOne(Integer codigo) throws DataAccessException {
		return estudianteDao.findOne(codigo);
	}
	
	@Transactional
	public void save(Estudiante c) throws DataAccessException {
		estudianteDao.save(c);
	}


	

}
