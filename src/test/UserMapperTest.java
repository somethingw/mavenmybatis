import com.week.mybatis.dao.UserDao;
import com.week.mybatis.dao.UserDaoImpl;
import com.week.mybatis.mapper.UserMapper;
import com.week.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author week
 * @Title: UserDaoImplTest
 * @ProjectName mavenmybatis
 * @Description: 测试用例
 * @date 2019/1/139:11
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception{
        String resource="SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    }
    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        //创建UserMapper对象，这一步是mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);
        System.out.println(user.getUsername());
    }
}
