package com.springboot.hello.dao;


import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao {

    private DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    // 이렇게만 해놓으면 SpringBoot가 Factory를 구성 해서 DI를 해줍니다.
    // 대신 꼭 final 붙여주세요.

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int deleteAll() throws ClassNotFoundException, SQLException {
        String sql = "delete from users";
        return jdbcTemplate.update(sql);
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into users(id,name,password) values(?,?,?);";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword());
    }

    public int getCount() throws SQLException, ClassNotFoundException {
        String sql = "select count() from users";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
        }
    };

    public User findById(String id) throws ClassNotFoundException, SQLException {
        String sql = "select from users where id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<User> getAll() {
        String sql = "select * from users order by id";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
