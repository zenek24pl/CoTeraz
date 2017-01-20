package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Response;
import model.Whatsnow_en;

@RestController
public class WhatsnowEngController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	

	@RequestMapping(path="/ang/nuda", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow_en> getNudaEng() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow_en> wynik = entityManager.createNamedQuery("Whatsnow_en.findByType").setParameter("type", "nuda").getResultList();
		
		entityManager.close();
		
		return wynik;		
	}

	@RequestMapping(path="/ang/zmeczenie", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow_en> getZmeczenieEng() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow_en> wynik = entityManager.createNamedQuery("Whatsnow_en.findByType").setParameter("type", "zmeczenie").getResultList();
		
		entityManager.close();
		
		return wynik;
	}

	@RequestMapping(path="/ang/glod", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow_en> getGlodEng() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow_en> wynik = entityManager.createNamedQuery("Whatsnow_en.findByType").setParameter("type", "glod").getResultList();	
		
		entityManager.close();
		
		return wynik;
	}

	@RequestMapping(path="/ang/zakupy", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow_en> getZakupyEng() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow_en> wynik = entityManager.createNamedQuery("Whatsnow_en.findByType").setParameter("type", "zakupy").getResultList();
		
		entityManager.close();
		
		return wynik;
	}
	
	// =======================================
	
	@RequestMapping(path="/ang/all", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow_en> getAllEng() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow_en> wynik = entityManager.createNamedQuery("Whatsnow_en.findAll").getResultList();
		
		entityManager.close();
		
		
		return wynik;
	}
	
	
	
	@RequestMapping(path="/ang/changeRating/{id}/{newRating}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.POST)
	public Response changeParameterEng(@PathVariable int id, @PathVariable int newRating) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Response response = new Response();
				
		List<Whatsnow_en> wynik = entityManager.createNamedQuery("Whatsnow_en.findById").setParameter("id", id).getResultList();

		
		
		for(Whatsnow_en d : wynik) {
			if (id == d.getId()) {
				
				Whatsnow_en whatsnow_en = entityManager.find(Whatsnow_en.class, 1);
				entityManager.getTransaction().begin();
				d.setRating(newRating);
				
				entityManager.getTransaction().commit();
				response.setResponse("Succes");
				
			}
			else {
				response.setResponse("Failed");
			}
		}
		entityManager.close();
		
		
		return response;
	}	
}
