package article;

import com.mvc.commons.paging.Criteria;
import com.mvc.dao.ArticleDAO;
import com.mvc.domain.ArticleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ArticleDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Inject
    private ArticleDAO articleDAO;

    @Test
    public void testCreate() throws Exception{
        ArticleVO article = new ArticleVO();
        article.setTitle("새로운 글 작성 테스트 제목");
        article.setContent("새로운 글 작성 테스트 내용");
        article.setWriter("새로운 글 작성자");
        articleDAO.create(article);
    }

    @Test
    public void testRead() throws Exception{
        logger.info(articleDAO.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        ArticleVO article = new ArticleVO();
        article.setArticleNo(1);
        article.setTitle("글 수정 테스트 제목");
        article.setContent("글 수정 테스트 내용");
        articleDAO.update(article);
    }

    @Test
    public void testDelete() throws Exception{
        articleDAO.delete(1);
    }

    @Test
    public void testCreate2() throws Exception{

        for(int i=0; i<=1000; i++){

            ArticleVO articleVO = new ArticleVO();
            articleVO.setTitle(i+"번째 글 제목입니다");
            articleVO.setContent(i+"번째 글 내용입니다");
            articleVO.setWriter("user0"+(i%10));

            articleDAO.create(articleVO);

        }
    }

    @Test
    public void testListPaging() throws Exception{

        int page = 5;

        List<ArticleVO> articles = articleDAO.listPaging(page);

        for(ArticleVO article : articles){
            logger.info(article.getArticleNo() + ":" + article.getTitle());
        }
    }

    @Test
    public void testListCriteria() throws Exception {

        Criteria criteria = new Criteria();
        criteria.setPage(3);
        criteria.setPerPageNum(20);

        List<ArticleVO> articles = articleDAO.listCriteria(criteria);

        for(ArticleVO article : articles){
            logger.info(article.getArticleNo() + " : " + article.getTitle());
        }
    }
}
