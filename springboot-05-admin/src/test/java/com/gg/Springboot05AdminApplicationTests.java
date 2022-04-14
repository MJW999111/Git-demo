package com.gg;

import com.gg.bean.Student;
import com.gg.bean.User;
import com.gg.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot05AdminApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;


    @Test
    public void contextLoads() {
        String sql = "select * from user";
        //查询多条记录
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }

    @Test
    public void TestUserMapper() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    //redis   测试
/*    @Test
    public void TestRedis() {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","word");
        String hello = operations.get("hello");
        System.out.println(hello);

        System.out.println(redisConnectionFactory.getClass());
    }*/





}
