package com.week.mybatis.dao;

import com.week.mybatis.po.User;

/**
 * @author week
 * @Title: UserDao
 * @ProjectName mavenmybatis
 * @Description: dao接口，用户管理
 * @date 2019/1/138:42
 */
public interface UserDao {
    /**
    * @Description: 根据id查询用户信息
    * @date 2019/1/13 8:51
    */
    public User  findUserById(int id) throws Exception;

    /**
    * @Description: 添加用户信息
    * @date 2019/1/13 8:52
    */
    public void insertUser(User user) throws Exception;
    /**
    * @Description: 删除用户的信息
    * @date 2019/1/13 8:52
    */
    public void deleteUser(int id) throws Exception;

}
