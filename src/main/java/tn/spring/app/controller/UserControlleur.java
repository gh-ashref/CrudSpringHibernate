package tn.spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tn.spring.app.dao.UserDao;
import tn.spring.app.entities.User;

@Controller
@RequestMapping("user")
public class UserControlleur {

	@Autowired
	private UserDao userDao;

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
					model.addAttribute("erreur", "utilisateur " + user.getLogin() + " existe déja :p");
					return "form";
				}
			} else {
				userDao.update(user);

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

}
