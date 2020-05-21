package com.uca.capas.tarea5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarea5.dao.EstudianteDAO;
import com.uca.capas.tarea5.domain.Estudiante;
import com.uca.capas.tarea5.service.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	EstudianteService estudianteService;
	
	
	@RequestMapping("/inicio")
	public ModelAndView inicio(@ModelAttribute Estudiante estudiante)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("commons/index");
		return mav;
	}
	
	@RequestMapping("/guardar")
	public ModelAndView guardarEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors())
		{
			mav.setViewName("commons/index");
		}
		else
		{
			mav.addObject("estudiante",new Estudiante());
			//Mando a llamar al servicio encargado de guardar a la entidad
			estudianteService.save(estudiante);
			mav.setViewName("commons/index");
			mav.addObject("resultado", 1);
		}
		
		return mav;
	}
	@RequestMapping(value="/borrarEstudiante", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam (value="codigo")int id)
	{
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try
		{
			
			estudianteService.delete(id);
			estudiantes = estudianteService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("commons/listado");
		mav.addObject("resultado2", 2);
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView initMain()
	{
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try
		{
			estudiantes = estudianteService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("commons/listado");
		
		return mav;
	
}
}