package tn.spring.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import tn.spring.app.entities.Article;
import tn.spring.app.entities.User;

@Component
@EnableTransactionManagement

public class ArticleDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * methode ajoute Article
	 * 
	 * @param user
	 *            to add
	 */
	@Transactional
	public void add(Article u) {

		entityManager.persist(u);
	}

	/**
	 * Methode supprimer Article
	 * 
	 * @param id
	 */
	@Transactional
	public void remove(Long id) {

		entityManager.remove(entityManager.getReference(Article.class, id));

	}

	/**
	 * methode Ajout Article
	 * 
	 * @param user
	 */
	@Transactional
	public void update(User Article) {
		entityManager.merge(Article);

	}

	/**
	 * Fonction retourne tous les Article
	 * 
	 * @return
	 */
	public List<Article> getAll() {
		return entityManager.createQuery("SELECT u FROM Article u", Article.class).getResultList();

	}

	/**
	 * Methode retourne Article par Id
	 * 
	 * @param id
	 * @return
	 */
	public Article getUserById(Long id) {

		return entityManager.createQuery("SELECT u FROM Article u WHERE u.id=" + String.valueOf(id) + "", Article.class)
				.getSingleResult();

	}

	/**
	 * Methode retourne Article par Login
	 * 
	 * @param login
	 * @return
	 */
	public List<Article> getUserByLogin(String login) {

		return entityManager.createQuery("SELECT u FROM Article u WHERE u.login='" + login + "'", Article.class)
				.getResultList();

	}

}
