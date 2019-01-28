package com.saber.credit.dao;

import com.saber.credit.bean.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by saber on 2018/11/23
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserInfoDaoTest {

    @Autowired
    private UserInfoDao dao;

    @Test
    public void testSelectUser() throws Exception {
         //List<UserInfo> userInfoList = dao.queryList();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("测试");
        userInfo.setAge(11);
        dao.insert(userInfo);
    }
}
