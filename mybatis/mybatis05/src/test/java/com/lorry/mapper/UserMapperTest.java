package com.lorry.mapper;

import com.lorry.pojo.User;
import com.lorry.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            List<User> users = mapper.getUsers();
//            for (User user : users) {
//                System.out.println(user);
//            }
//        }
//            User user = mapper.getUserByID(1);
//            System.out.println(user);
              mapper.addUser(new User(8,"222","2222"));

        }
    }
}
