package com.mvc.dao;


import com.mvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User query(Integer uid){
        String sql = "select * from t_user where id=?";
        Object[] args = {uid};
        User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),args);
        System.out.println("返回数据 User");
        return user;
    }

    public void save(User user){
        String sql = "insert into t_user values(?,?,?)";
        Object[] args = {user.getId(),user.getName(),user.getAddress()};
        int line = jdbcTemplate.update(sql,args);
        System.out.println("Dao save User");
    }

}