package com.hcl.dao.impl;

import com.hcl.dao.UserDao;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepo;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public void insertUser(User user) {
        userRepo.save(user);
    }

    public void insertUsers(List<User> users){
        userRepo.saveAll(users);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(Long userId){
        return userRepo.findById(userId).orElse(null);
    }

    public void updateUser(User user){
        userRepo.save(user);
    }

    public User getUserByUsername(String username){
        return userRepo.getUserByUsername(username);
    }

    public void deleteUserById(long userId) {
        userRepo.deleteById(userId);
    }
}
