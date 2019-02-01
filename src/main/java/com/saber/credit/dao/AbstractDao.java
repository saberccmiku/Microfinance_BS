package com.saber.credit.dao;

import com.saber.credit.bean.AbstractBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * DAO抽象基类，提供CRUD的接口，供其他继承类扩展
 * @author 890147 2017年8月11日
 * @param <T>
 */
public interface AbstractDao<T extends AbstractBean> {

    /**
     * 添加
     * @param bean
     * @return
     */
    @Transactional(rollbackFor = { Exception.class })
    Integer insert(T bean) throws Exception;

    /**
     * 编辑
     * @param bean
     * @return
     */
    @Transactional(rollbackFor = { Exception.class })
    Integer update(T bean) throws Exception;

    /**
     * 删除
     * @author 890147 2017年9月21日
     * @param businessId
     * @param modifyuser
     * @param modifyDate
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = { Exception.class })
    Integer delete(@Param("businessId")String businessId, @Param("modifyuser")String modifyuser, @Param("modifydate")Date modifyDate) throws Exception;

    /**
     * 查询一条数据
     * @param businessId
     * @return
     */
    T queryById(@Param("businessId")String businessId) throws Exception;
    /**
     * 根据流水号查询业务数据
     * @param businessNo
     * @return
     */
    T queryByNo(@Param("businessNo")String businessNo) throws Exception;

    /**
     * 查询列表
     */
    List<T> queryList() throws Exception;
}