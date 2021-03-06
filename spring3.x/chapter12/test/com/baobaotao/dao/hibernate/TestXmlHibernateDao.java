package com.baobaotao.dao.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import com.baobaotao.domain.Forum;
import com.baobaotao.domain.Post;
import com.baobaotao.domain.Topic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-hbt.xml" })
@TransactionConfiguration
@Transactional
public class TestXmlHibernateDao {

	@Autowired
	private ForumHibernateDao forumDao;
	
	@Autowired
	private PostHibernateDao postDao;
	
	@Test
	public void testAddPost() throws Throwable{
        Topic topic = new Topic();
        topic.setTopicId(1);
        Post post = new Post();
        post.setPostId(10);
        post.setPostText("post text...");
        
        Resource resource = new ClassPathResource("temp.jpg");
        byte[] imgFile =FileCopyUtils.copyToByteArray(resource.getFile());
        post.setPostAttach(imgFile);    
        post.setTopic(topic);  
        postDao.addPost(post);
        
	}	
	
	@Test
	public void testFindForumByName() {
       List<Forum> forums = forumDao.findForumByName("forum");
       Assert.assertTrue(forums.size() > 0);
	}	
	
	
		
}
