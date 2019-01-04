package com.saber.credit.util.UUIDGen;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class UUIDInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object[] args = invocation.getArgs();
        if (args == null || args.length != 2 || !(args[0] instanceof MappedStatement) || (args[1] instanceof Map)) {
            return invocation.proceed();
        }
        MappedStatement mappedStatement = (MappedStatement) args[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        if (!SqlCommandType.INSERT.equals(sqlCommandType)) {
            return invocation.proceed();
        }
        setDefultProperty(args[1]);
        return invocation.proceed();
    }

    public void setDefultProperty(Object obj) {

        PropertySet propertySet = new PropertySet(obj.getClass());
        Set<ProPertyStrategyMapper> propers = propertySet.getPropertys();
        if (propers == null || propers.isEmpty())
            return;
        for (ProPertyStrategyMapper pro : propers) {
            try {
                BeanUtils.setProperty(obj, pro.getPropertyName(), pro.getGenerator().generator());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("init UUIDInterceptor");
    }

}