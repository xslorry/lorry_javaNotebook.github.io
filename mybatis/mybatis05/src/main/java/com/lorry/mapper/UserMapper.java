package com.lorry.mapper;

import com.lorry.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数前面必须加上@param（“id”）注解
    //根据注解指定的变量名去查
    @Select("select * from user where user_id = #{id}")
    User getUserByID(@Param("id") int id);

    @Insert("insert into mybatis.user(user_id, user_name, user_pwd) value (#{user_id}, #{user_name}, #{user_password});")
    int addUser(User user);
}
