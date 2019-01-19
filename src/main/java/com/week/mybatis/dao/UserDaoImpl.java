package com.week.mybatis.dao;

import com.week.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * @author week
 * @Title: UserDaoImpl
 * @ProjectName mavenmybatis
 * @Description: 接口实现类
 * @date 2019/1/138:54
 */
public class UserDaoImpl implements UserDao{
    private SqlSessionFactory sqlSessionFactory;
    /**
    * @Description: 需要向dao实现类中注入SqlSessionFactory,这里通过构造方法注入
    * @date 2019/1/13 8:56
    */
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory=sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSeesion=sqlSessionFactory.openSession();
        User user= sqlSeesion.selectOne("test.findUserById",id);
        sqlSeesion.close();
        return user;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSeesion=sqlSessionFactory.openSession();
        sqlSeesion.insert("test.insertUser",user);
        sqlSeesion.commit();
        sqlSeesion.close();
    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSeesion=sqlSessionFactory.openSession();
        sqlSeesion.delete("test.deleteUser",id);
        sqlSeesion.commit();
        sqlSeesion.close();
    }
}
