package com.saber.credit.service.impl;

import com.saber.credit.bean.UserInfo;
import com.saber.credit.dao.UserInfoDao;
import com.saber.credit.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * Created by saber on 2018/11/22
 */
@Service
public class UserInfoServiceImpl extends AbstractServiceImpl<UserInfo> implements UserInfoService {

    private UserInfoDao userInfoDao;

    @Override
    public UserInfo queryByUserId(String userId) throws Exception {
        return userInfoDao.queryByUserId(userId);
    }
}
