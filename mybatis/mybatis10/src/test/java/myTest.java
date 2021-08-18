import com.lorry.mapper.UserMapper;
import com.lorry.pojo.User;
import com.lorry.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class myTest {
    @Test
    public void testSelect(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.queryUserById(1);
            System.out.println(user);
//            mapper.updateUser(new User(2,"周星星","23344"));
            sqlSession.clearCache();//手动清理缓存
            System.out.println("============================");
            User user2 = mapper.queryUserById(1);
            System.out.println(user2);
        }
    }
    @Test
    public void testCache(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }
}
