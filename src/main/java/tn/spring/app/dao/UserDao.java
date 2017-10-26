package tn.spring.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import tn.spring.app.entities.User;

@Component
@EnableTransactionManagement

public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * methode ajoute utilisateur
	 * 
	 * @param user
	 *            to add
	 */
	@Transactional
	public void add(User u) {

		// Category category = new Category("Hibernate Framework");
		//
		// Article articleOne = new Article("One-to-One Mapping", "One-to-One
		// XML Mapping Tutorial",
		// "Hibernate,One-to-One", "Content of One-to-One XML Mapping
		// Tutorial");
		// Article articleTwo = new Article("One-to-Many Mapping", "One-to-Many
		// XML Mapping Tutorial",
		// "Hibernate,One-to-Many", "Content of One-to-Many XML Mapping
		// Tutorial");
		// Article articleThree = new Article("Many-to-Many Mapping",
		// "Many-to-Many XML Mapping Tutorial",
		// "Hibernate,Many-to-Many", "Content of Many-to-Many XML Mapping
		// Tutorial");
		//
		// Set<Article> articles = new HashSet<Article>();
		// articles.add(articleOne);
		// articles.add(articleTwo);
		// articles.add(articleThree);
		//
		// category.setArticles(articles);
		//
		// entityManager.persist(category);

		//List<Category> a = entityManager.createQuery("SELECT u FROM Category u", Category.class).getResultList();
		//System.out.println(a.size());
		entityManager.persist(u);
	}

	/**
	 * Methode supprimer utilisateur
	 * 
	 * @param id
	 */
	@Transactional
	public void remove(Long id) {

		entityManager.remove(entityManager.getReference(User.class, id));

	}

	/**
	 * methode Ajout Utilisateur
	 * 
	 * @param user
	 */
	@Transactional
	public void update(User user) {
		entityManager.merge(user);

	}

	/**
	 * Fonction retourne tous les utilisateurs
	 * 
	 * @return
	 */
	public List<User> getAll() {
		return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();

	}

	/**
	 * Methode retourne utilisateur par Id
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(Long id) {

		return entityManager.createQuery("SELECT u FROM User u WHERE u.id=" + String.valueOf(id) + "", User.class)
				.getSingleResult();

	}

	/**
	 * Methode retourne Utilisateur par Login
	 * 
	 * @param login
	 * @return
	 */
	public List<User> getUserByLogin(String login) {

		return entityManager.createQuery("SELECT u FROM User u WHERE u.login='" + login + "'", User.class)
				.getResultList();

	}

}
