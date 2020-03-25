package br.com.rmn.demo.lgpd.demolgpd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rmn.demo.lgpd.demolgpd.dao.UserDao;
import br.com.rmn.demo.lgpd.demolgpd.model.User;

/**
 * UserService
 */
@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> listAllUser() {
        return userDao.selectAllUser();
    }

	public User getUserById(int id) {
		return userDao.selectUser(id).orElse(null);
    }
    
    public void addUser(User user) {
        userDao.insertUser(user);
    }
}