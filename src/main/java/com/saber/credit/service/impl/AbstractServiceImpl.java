package com.saber.credit.service.impl;

import com.saber.credit.bean.AbstractBean;
import com.saber.credit.bean.SecureUser;
import com.saber.credit.dao.AbstractDao;
import com.saber.credit.service.AbstractService;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * DAO抽象基类，提供CRUD的接口，供其他继承类扩展
 * @param <T>
 */
public abstract class AbstractServiceImpl<T extends AbstractBean> implements AbstractService<T> {


    protected AbstractDao<T> dao;
    protected AbstractService<T> selfService = this;

    public AbstractServiceImpl() {
    }

    protected void setDao(AbstractDao<T> dao) {
        this.dao = dao;
    }

    public void setSelfService(AbstractService<T> selfService) throws Exception {
        this.selfService = selfService;
    }

    public Integer insert(T bean, SecureUser operator) throws Exception {
        Integer result = this.dao.insert(bean);
        if(result.intValue() > 0) {
            this.selfService.saveItem(bean, operator);
        }
        return result;
    }

    public Integer update(T bean,SecureUser operator) throws Exception {
        Integer result = this.dao.update(bean);
        if(result.intValue() > 0) {
            this.selfService.saveItem(bean, operator);
        }
        return result;
    }

    public Integer delete(String id,SecureUser operator) throws Exception {
        return this.dao.delete(id, operator.getId(), new Date());
    }


    public Integer insertOrUpdate(T bean, SecureUser operator) throws Exception {
        Integer result = null;
        if(StringUtils.isBlank(bean.getId())) {
            result = this.selfService.insert(bean, operator);
        } else {
            result = this.selfService.update(bean, operator);
        }

        return result;
    }

    public T queryByNo(String no) throws Exception {
        return this.dao.queryByNo(no);
    }


    public T queryById(String id) throws Exception {
        return this.dao.queryById(id);
    }

    public List<T> queryList() throws Exception {
        return this.dao.queryList();
    }

    public T queryDetail(T bean, SecureUser operator) throws Exception {
        if(bean != null) {
            this.selfService.setItem(bean, operator);
        }
        return bean;
    }

    public Class<T> getClassType() throws Exception {
        Class<?> superClass = this.getClass();

        for(Class objClass = Object.class; superClass != objClass; superClass = superClass.getSuperclass()) {
            Type type = superClass.getGenericSuperclass();
            if(type instanceof ParameterizedType) {
                Type[] args = ((ParameterizedType)type).getActualTypeArguments();
                if(args != null && args.length > 0 && args[0] instanceof Class) {
                    return (Class)args[0];
                }
            }
        }

        return null;
    }


    public void setItem(T bean, SecureUser operator) throws Exception {
    }

    @Transactional(
            propagation = Propagation.REQUIRED
    )
    public void saveItem(T bean,SecureUser operator) throws Exception {
    }

}