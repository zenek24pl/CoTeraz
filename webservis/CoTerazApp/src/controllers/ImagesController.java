package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;

@RestController
public class ImagesController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoTerazJPA");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	@RequestMapping(path="/images", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> getAllImages() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<User> images = entityManager.createNamedQuery("Images.findAll").getResultList();		
		
		entityManager.close();
		
		return images;		
	}
	
}
