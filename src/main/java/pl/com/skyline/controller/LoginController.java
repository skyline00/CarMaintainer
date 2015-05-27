package pl.com.skyline.controller;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.com.skyline.dao.UserDao;
import pl.com.skyline.entity.User;
 
@Controller
public class LoginController {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User u) {
		
		UserDao userDao = context.getBean(UserDao.class);
		System.out.println(userDao.getUserByLogin(u.getLogin()));
		
		
		if ("dupa".equals(u.getLogin())) {
			String message = "dupa";
			System.out.println(u.getLogin());
			return new ModelAndView("welcome", "message", message);
		} else {
			return new ModelAndView("index", "message", "login failed!");
		}
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        UserDao userDao = context.getBean(UserDao.class);
         
        User user = new User();
        user.setLogin("Patryk");
         
        userDao.save(user);
         
        System.out.println("User: " + user);
         
        List<User> list = userDao.list();
         
        for(User u : list){
            System.out.println("User List: " + u);
        }
        
        context.close();    */
 
		
	}
	
	@RequestMapping("/")
	public ModelAndView index() {		
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("user", new User());
		return model;
		
	}
}