package com.lorry.mapper;

import com.lorry.pojo.User;
import com.lorry.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){

        /*
        * 从SqlSession执行sql
        * 先拿到sql
        * UserMapper是UserDao的实现类
        *面向接口编程所以我们们拿到接口“UserDao.class”就可以
        * 返回后就可以执行接口的方法了
        * */
        //第一步获得SqlSession对象
        //这里使用了try-with-resources不必写sqlSession.close();
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            //方式1：执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            //方式2：不推荐使用
//        List<User> userList = sqlSession.selectList("com.lorry.dao.UserDao.getUserList");
            for (User user : userList) {
                //输出的是地址原因是没写toString
                System.out.println(user);
            }
        }
    }
    @Test
    public void getUserById(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        }
    }
    //增删改需要提交事务
    @Test
    public void getUserById2(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("id",2);
            map.put("name","梅世杰");
            User user = mapper.getUserById2(map);
            System.out.println(user);
        }
    }

    @Test
    public void addUser(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper =sqlSession.getMapper(UserMapper.class);
            int rest = mapper.addUser(new User(5,"李俊柒","222222"));
            if(rest>0){
                System.out.println("插入成功！");
            }
            //提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void updateUser(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(5,"汤姆猫","333333333333"));
            //提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void deleteUser(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser(5);
            //提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void addUser2(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String,Object>();
            //跟#{}里面的一一对应
            map.put("id",5);
            map.put("name","李俊柒");
            map.put("pwd","88888888");
            mapper.addUser2(map);
            //提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void getUserLike(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.getUserLike("梅");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}

