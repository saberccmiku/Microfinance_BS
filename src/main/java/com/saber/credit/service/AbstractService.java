package com.saber.credit.service;

import com.saber.credit.bean.AbstractBean;
import com.saber.credit.bean.SecureUser;

import java.util.List;

/**
        * 无工作流的通用service接口，提供基本的CRUD接口
        * @param <T>
 */
public interface AbstractService<T extends AbstractBean> {
    /**
     * 新建
     *
     * @param bean
     * @param operator
     * @return
     * @author 890147 2017年8月4日
     */
    Integer insert(T bean, SecureUser operator) throws Exception;

    /**
     * 编辑
     *
     * @param bean
     * @param operator
     * @return
     * @throws Exception
     * @author 890147 2017年8月8日
     */
    Integer update(T bean, SecureUser operator) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @param operator
     * @return
     * @throws Exception
     * @author 890147 2017年8月8日
     */
    Integer delete(String id, SecureUser operator) throws Exception;

    /**
     * 插入或更新，只是一个分发入口，不做真正操作
     *
     * @param bean
     * @param operator
     * @return
     * @throws Exception
     * @author 890147 2017年8月8日
     */
    Integer insertOrUpdate(T bean, SecureUser operator) throws Exception;

    /**
     * @param id
     * @return
     * @description 查询一条数据
     * @author ahua
     * @date 2017-8-2  下午3:58:01
     */
    T queryById(String id) throws Exception;

    /**
     * 根据流水号查询业务数据
     *
     * @param no
     * @return
     * @throws Exception
     * @author 890147 2017年9月21日
     */
    T queryByNo(String no) throws Exception;

    /**
     * 给bean赋值各种详情
     *
     * @param bean
     * @param operator
     * @return
     * @throws Exception
     * @author 890147 2017年9月6日
     */
    T queryDetail(T bean, SecureUser operator) throws Exception;

    /**
     * 查询列表
     */
    List<T> queryList() throws Exception;

    /**
     * 获取泛型类的具体类型
     *
     * @return
     * @author 890147 2017年8月8日
     */
    Class<T> getClassType() throws Exception;

    /**
     * 对自己service注入的方法，继承类调用并传入具体的service实现类，用于获取service的代理，再通过代理调用方法触发拦截器或分站点
     *
     * @param selfService
     * @author 890147 2017年8月21日
     */
    void setSelfService(AbstractService<T> selfService) throws Exception;


    /**
     * 获取子表信息到bean
     * @author 890147 2017年10月18日
     * @param bean
     * @param operator
     * @throws Exception
     */
    void setItem(T bean, SecureUser operator)throws Exception;
    /**
     * 保存子表信息
     * @author 890147 2017年10月18日
     * @param bean
     * @param operator
     * @throws Exception
     */
    void saveItem(T bean, SecureUser operator)throws Exception;
}
