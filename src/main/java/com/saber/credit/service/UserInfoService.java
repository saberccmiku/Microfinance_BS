package com.saber.credit.service;

import com.saber.credit.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by saber on 2018/11/22
 */
public interface UserInfoService extends AbstractService<UserInfo> {

    /**
     * 根据userId查询
     * @param businessId 用户id
     * @return UserInfo
     */
    UserInfo queryByUserId(@Param("userId")String businessId) throws Exception;

}
