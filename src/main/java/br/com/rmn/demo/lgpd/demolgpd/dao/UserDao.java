package br.com.rmn.demo.lgpd.demolgpd.dao;

import java.util.List;
import java.util.Optional;

import br.com.rmn.demo.lgpd.demolgpd.model.User;

/**
 * UserDao
 */
public interface UserDao {

    int insertUser(User user);

    int updateUser(int id, User user);

    List<User> selectAllUser();
    
    Optional<User> selectUser(int id);

    int deleteUser(int id, User user);

}