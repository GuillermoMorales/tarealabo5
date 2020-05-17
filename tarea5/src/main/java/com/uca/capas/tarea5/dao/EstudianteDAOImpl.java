package com.uca.capas.tarea5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.tarea5.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {
	@PersistenceContext (unitName="modelo-persistence")
	EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException
	{
		//Creamos un objeto StringBuffer para definir la consulta a ejecutar
		StringBuffer sb = new StringBuffer();
		//Definimos la consulta con el método append
		sb.append("select * from public.estudiante");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		
		List<Estudiante> res = query.getResultList();
		
		return res;
	}
	
	public Estudiante findOne(Integer codigo) throws DataAccessException 
	{
		Estudiante c = entityManager.find(Estudiante.class, codigo);
		return c;
	}
	
public void save(Estudiante c) throws DataAccessException {
		
		if(c.getCusuario() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}

}
	

}
