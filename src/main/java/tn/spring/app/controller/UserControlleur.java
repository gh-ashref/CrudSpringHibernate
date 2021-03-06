package tn.spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.spring.app.dao.ArticleDao;
import tn.spring.app.dao.UserDao;
import tn.spring.app.entities.Article;
import tn.spring.app.entities.User;

@Controller
@RequestMapping("user")
public class UserControlleur {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ArticleDao articleDao;

	@RequestMapping("list")
	public String list(Model model) {
		List<User> listUser = (List<User>) userDao.getAll();
		model.addAttribute("listUser", listUser);

		return "list";
	}

	@RequestMapping("form")
	public ModelAndView newContact(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("form");
		return model;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String add(Model model, @RequestParam(name = "id") Long id,
			@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName,
			@RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {

		User user = new User(id, login, password, firstName, lastName);

		if (login == "") {
			model.addAttribute("user", user);
			model.addAttribute("erreur", "utilisateur vide :p");
			return "form";
		} else {
			if (id == null) {
				if (userDao.getUserByLogin(login).isEmpty()) {

					userDao.add(user);

				} else {
					model.addAttribute("user", user);
					model.addAttribute("erreur", "utilisateur " + user.getLogin() + " existe d�ja :p");
					return "form";
				}
			} else {
				if (userDao.getUserByLogin(login).size() > 0) {

					model.addAttribute("user", user);
					model.addAttribute("erreur", "utilisateur " + user.getLogin() + " existe d�ja :p");
					return "form";
				} else {
					userDao.update(user);
				}
			}
			return "redirect:/user/list";
		}
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String remove(@RequestParam(name = "id") Long id) {

		userDao.remove(id);

		return "redirect:/user/list";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam(name = "id") Long id) {

		User user = userDao.getUserById(id);
		model.addAttribute("user", user);

		return "form";
	}

	@RequestMapping("addArticlef")
	public String addArticlef(Model model) {
		List<User> listUser = (List<User>) userDao.getAll();
		model.addAttribute("listUser", listUser);
		List<Article> listArticle = (List<Article>) articleDao.getAll();
		model.addAttribute("listArticle", listArticle);
		return "article";
	}

	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String addArticle(Model model, @RequestParam(name = "content") String content,
			@RequestParam(name = "description") String description, @RequestParam(name = "keywords") String keywords,
			@RequestParam(name = "title") String title, @RequestParam(name = "user_id") String user_id) {
		List<User> u = userDao.getUserByLogin(user_id);
		User uu = u.get(0);
		Article a = new Article(content, description, keywords, title, uu);
		articleDao.add(a);

		return "redirect:/user/addArticlef";
	}

	@ResponseBody
	@RequestMapping(value = "/Alluserjson")
	private String findAll() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(userDao.getAll());

		return jsonInString;

	}

}
