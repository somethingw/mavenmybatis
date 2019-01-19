package com.week.mybatis.first;

import com.week.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author week
 * @Title: MybatisFirst
 * @ProjectName mavenmybatis
 * @Description: 入门程序
 * @date 2019/1/1214:54
 */
public class MybatisFirst {
    /**
    * @Description: 根据id查询用户
    * @date 2019/1/12 14:55
    */
    @Test
    public  void  findUserByIdTest(){
        //mybatis配置文件
        String resource="SqlMapConfig.xml";
        try {
            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到SqlSession
            SqlSession sqlSession= sqlSessionFactory.openSession();

            //第一个参数：映射statement的id，等于namespace+"."+statement的id
            //第二个参数：指定映射文件中的所匹配的parameterType类型的参数
            //sqlSession.selectOne结果始于映射文件中所匹配的resultType类型对象
            User user= sqlSession.selectOne("test.findUserById",1);
            System.out.println(user);

            //释放资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
    * @Description: 根据用户名模糊查询
    * @date 2019/1/12 15:34
    */
    @Test
    public  void  findUserByNameTest(){
        //mybatis配置文件
        String resource="SqlMapConfig.xml";
        try {
            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到SqlSession
            SqlSession sqlSession= sqlSessionFactory.openSession();

            //第一个参数：映射statement的id，等于namespace+"."+statement的id
            //第二个参数：指定映射文件中的所匹配的parameterType类型的参数
            //sqlSession.selectOne结果始于映射文件中所匹配的resultType类型对象
            List<User> users= sqlSession.selectList("test.findUserByName","小明");
            System.out.println(users);

            //释放资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
    * @Description: 添加用户
    * @date 2019/1/12 15:58
    */
    @Test
    public  void  insertUserTest(){
        //mybatis配置文件
        String resource="SqlMapConfig.xml";
        try {
            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到SqlSession
            SqlSession sqlSession= sqlSessionFactory.openSession();

            //第一个参数：映射statement的id，等于namespace+"."+statement的id
            //第二个参数：指定映射文件中的所匹配的parameterType类型的参数
            //sqlSession.selectOne结果始于映射文件中所匹配的resultType类型对象
            User user = new User();
            user.setUsername("测试一下下下下");
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("意大利");
            sqlSession.insert("test.insertUser",user);
            //提交事务
            sqlSession.commit();
            System.out.println(user.getId());
            //释放资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
    * @Description: 删除
    * @date 2019/1/12 16:30
    */
    @Test
    public  void  deleteUserTest(){
        //mybatis配置文件
        String resource="SqlMapConfig.xml";
        try {
            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到SqlSession
            SqlSession sqlSession= sqlSessionFactory.openSession();

            //第一个参数：映射statement的id，等于namespace+"."+statement的id
            //第二个参数：指定映射文件中的所匹配的parameterType类型的参数
            //sqlSession.selectOne结果始于映射文件中所匹配的resultType类型对象


            sqlSession.delete("test.deleteUser",27);
            //提交事务
            sqlSession.commit();

            //释放资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * @Description: 更新
    * @date 2019/1/12 16:32
    */
    @Test
    public  void  updateUserTest(){
        //mybatis配置文件
        String resource="SqlMapConfig.xml";
        try {
            //得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);

            //创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到SqlSession
            SqlSession sqlSession= sqlSessionFactory.openSession();

            //第一个参数：映射statement的id，等于namespace+"."+statement的id
            //第二个参数：指定映射文件中的所匹配的parameterType类型的参数
            //sqlSession.selectOne结果始于映射文件中所匹配的resultType类型对象
            User user = new User();
            user.setId(1);
            user.setUsername("更改");
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("意大利");
            sqlSession.update("test.updateUser",user);
            //提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
