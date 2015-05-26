package pl.com.skyline.dao;

import java.util.List;

import pl.com.skyline.entity.User;

public interface UserDao {
 
    public void save(User p);
     
    public List<User> list();
     
}