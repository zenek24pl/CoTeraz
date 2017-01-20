package controllers;

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
import model.Whatsnow;

@RestController
public class WhatsnowController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getDefault() {
		return "Nie poprawna siezka";
	}

	@RequestMapping(path="/nuda", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow> getNuda() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "nuda").getResultList();
		
		entityManager.close();
		
		return wynik;		
	}

	@RequestMapping(path="/zmeczenie", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow> getZmeczenie() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "zmeczenie").getResultList();
		
		entityManager.close();
		
		return wynik;
	}

	@RequestMapping(path="/glod", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow> getGlod() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "glod").getResultList();
		
		entityManager.close();
		
		return wynik;
	}

	@RequestMapping(path="/zakupy", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow> getZakupy() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "zakupy").getResultList();
				
		entityManager.close();
		
		return wynik;
	}
	
	@RequestMapping(path="/repair", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow> getRepair() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "repair").getResultList();
				
		entityManager.close();
		
		return wynik;
	}
	
	@RequestMapping(path="/money", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow> getMoney() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findByType").setParameter("type", "money").getResultList();
				
		entityManager.close();
		
		return wynik;
	}
	
	// =======================================
	
	@RequestMapping(path="/all", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Whatsnow> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findAll").getResultList();
		
		entityManager.close();
		
		return wynik;
	}
	
	
	@RequestMapping(path="/changeRating/{id}/{newRating}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, method=RequestMethod.POST)
	public Response changeParameter(@PathVariable int id, @PathVariable int newRating) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Response response = new Response();
				
		List<Whatsnow> wynik = entityManager.createNamedQuery("Whatsnow.findById").setParameter("id", id).getResultList();

		
		for(Whatsnow d : wynik) {
			if (id == d.getId()) {
				
				Whatsnow whatsnow = entityManager.find(Whatsnow.class, 1);
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
