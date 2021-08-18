import com.lorry.mapper.BlogMapper;
import com.lorry.pojo.Blog;
import com.lorry.utils.IDutils;
import com.lorry.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class test {
    @Test
    public void Test(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId(IDutils.getId());
            blog.setTitle("Mybatis如此简单");
            blog.setAuthor("狂神说");
            blog.setCreateTime(new Date());
            blog.setViews(9999);
            mapper.addBook(blog);

            blog.setId(IDutils.getId());
            blog.setTitle("Java如此简单");
            mapper.addBook(blog);

            blog.setId(IDutils.getId());
            blog.setTitle("Spring如此简单");
            mapper.addBook(blog);

            blog.setId(IDutils.getId());
            blog.setTitle("微服务如此简单");
            mapper.addBook(blog);
        }
    }
    @Test
    public void queryBlogIFTest(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap map = new HashMap();
//            map.put("title","Java如此简单");
            map.put("author","骆海瑞");
            map.put("id","1");
            List<Blog> blogList = mapper.queryBlogIF(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }
//            mapper.updateBlog(map);
        }
    }
    
    @Test
    public void queryBlogForeach(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap map = new HashMap();
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(4);
            map.put("ids",ids);
            List<Blog> blogList = mapper.queryBlogForeach(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }
        }
    }
}
