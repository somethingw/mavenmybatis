import com.week.mybatis.dao.UserDao;
import com.week.mybatis.dao.UserDaoImpl;
import com.week.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author week
 * @Title: UserDaoImplTest
 * @ProjectName mavenmybatis
 * @Description: 测试用例
 * @date 2019/1/139:11
 */
public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception{
        String resource="SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    }
    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user.getUsername());
    }
}
