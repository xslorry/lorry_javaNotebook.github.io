package com.lorry.mapper;

import com.lorry.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserById(@Param("user_id") int id);

    int updateUser(User user);


}
