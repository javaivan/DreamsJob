package com.ivanmix.service;

import com.ivanmix.config.SpringConfig;
import com.ivanmix.entity.Reply;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ReplyServiceTest {


    @Autowired
    ReplyService replyService;

    @Test
    public void findByIdTest() {
        Reply reply = replyService.findById((long) 1);
        assertNotNull(reply);
    }

    @Test
    public void findByUserIdTest() {
        List<Reply> replies = replyService.findByUserId((long) 1);
        assertNotNull(replies);
    }

    @Test
    public void findByProjectIdTest() {
        List<Reply> replies = replyService.findByProjectId((long) 1);
        assertNotNull(replies);
    }

    @Test
    public void createTest(){
        Reply replyParent = replyService.create("TestCreateReplyReplyParent",(long)1, null,(long)1);
        assertNotNull(replyParent);

        Reply replyChildren = replyService  .create("TestCreateReplyReplyChildren",(long)1, replyParent.getId(),(long)1);
        assertNotNull(replyChildren);
    }

    @Test
    public void findByReplyTest(){
        List<Reply> replies = replyService.findByReply("TestFindByReply");
        assertNotNull(replies);
    }

    @Test
    @Ignore
    public void updateProjectReplyTest(){

    }


}
