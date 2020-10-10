package com.jyinfo.jy_domain.mapper.mybatisMapper;

import com.jyinfo.jy_domain.Entity.mybatisEntity.UserEntity;

public interface UserMapper {

    UserEntity UserNameExist(String fName);


}
