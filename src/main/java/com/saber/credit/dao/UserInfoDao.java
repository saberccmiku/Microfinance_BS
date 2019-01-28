package com.saber.credit.dao;

import com.saber.credit.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by saber on 2018/11/22
 */
public interface UserInfoDao extends AbstractDao<UserInfo> {

    /**
     * 根据userId查询
     * @param userId 用户id
     * @return UserInfo
     */
    UserInfo queryByUserId(@Param("userId")String userId) throws Exception;
}
