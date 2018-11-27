package com.saber.credit.dao;

import com.saber.credit.bean.UserInfo;

import java.util.List;

/**
 * Created by saber on 2018/11/22.
 */
public interface UserInfoDao {
    List<UserInfo> queryList();
}
