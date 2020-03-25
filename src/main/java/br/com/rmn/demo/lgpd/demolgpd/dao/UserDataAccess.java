package br.com.rmn.demo.lgpd.demolgpd.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.rmn.demo.lgpd.demolgpd.model.User;

/**
 * UserDataAccess
 */
@Repository("sqlerver")
public class UserDataAccess implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccess(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int deleteUser(final int id, final User user) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertUser(final String name, final String password, final String email, final String phone) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<User> selectAllUser() {
        final String sql = "SELECT userId, userName, userPassword, email, phone FROM tb_user";
        return jdbcTemplate.query(sql, (resultSet, rows) ->
                new User(resultSet.getInt("userId"), 
                        resultSet.getString("userName"),
                        resultSet.getString("userPassword"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")));
    }

    @Override
    public Optional<User> selectUser(final int id) {
        final String sql = "SELECT userId, userName, userPassword, email, phone FROM tb_user WHERE userId = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, row) ->
            new User(resultSet.getInt("userId"), 
                    resultSet.getString("userName"),
                    resultSet.getString("userPassword"),
                    resultSet.getString("email"),
                    resultSet.getString("phone")));
        } catch (DataAccessException e) {
            //...
        }
        return Optional.ofNullable(user);
    }

    @Override
    public int updateUser(final int id, final User user) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}