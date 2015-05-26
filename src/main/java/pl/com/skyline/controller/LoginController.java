package pl.com.skyline.controller;
 
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.com.skyline.dao.UserDao;
import pl.com.skyline.entity.User;
 
@Controller
public class LoginController {
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        UserDao userDao = context.getBean(UserDao.class);
         
        User user = new User();
        user.setLogin("Patryk");
         
        userDao.save(user);
         
        System.out.println("User: " + user);
         
        List<User> list = userDao.list();
         
        for(User u : list){
            System.out.println("User List: " + u);
        }
        
        context.close();    
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}