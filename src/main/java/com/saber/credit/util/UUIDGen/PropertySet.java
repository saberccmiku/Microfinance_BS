package com.saber.credit.util.UUIDGen;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class PropertySet {

    private Set<ProPertyStrategyMapper> propertys = new HashSet<ProPertyStrategyMapper>();

    private Class<?> entity;

    @SuppressWarnings("unused")
    private PropertySet() {

    }

    public PropertySet(Class<?> entity) {
        this.entity = entity;
        this.build();
    }

    public Set<ProPertyStrategyMapper> getPropertys() {
        return propertys;
    }

    public void setPropertys(Set<ProPertyStrategyMapper> propertys) {
        this.propertys = propertys;
    }

    public PropertySet build() {
        List<Field> fieldList = new ArrayList<>();
        Class clazz = entity;
        while (null != clazz) {
            Field[] declaredFields = clazz.getDeclaredFields();
            fieldList.addAll(Arrays.asList(declaredFields));
            clazz = clazz.getSuperclass();
        }
        for (Field field : fieldList) {
            if ("serialVersionUID".equals(field.getName()))
                continue;
            field.setAccessible(true);
            PropertyDescriptor propertyDescriptor = null;
            try {
                propertyDescriptor = new PropertyDescriptor(field.getName(), entity);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            if (propertyDescriptor == null)
                continue;
            // 获取类的get方法
            Method method = propertyDescriptor.getReadMethod();
            if (method == null) {
                continue;
            }
            if (field.isAnnotationPresent(Id.class)) {
                Id id = field.getAnnotation(Id.class);
                if (null == id.strategy()) {
                    continue;
                }
                Class<?> strategy = id.strategy();
                Object newInstance = null;
                try {
                    newInstance = strategy.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (!(newInstance instanceof IdGenerator)) {
                    continue;
                }
                IdGenerator idGenerator = (IdGenerator) newInstance;
                ProPertyStrategyMapper proPertyStrategyMapper = new ProPertyStrategyMapper(field.getName(),
                        idGenerator);
                propertys.add(proPertyStrategyMapper);
            }
            else if (method.isAnnotationPresent(Id.class)) {
                Id id = method.getAnnotation(Id.class);
                if (id.strategy() == null) {
                    continue;
                }
                Class<?> generator = id.strategy();
                Object object = null;
                try {
                    object = generator.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (!(object instanceof IdGenerator)) {
                    continue;
                }
                IdGenerator idGenerator = (IdGenerator) object;
                ProPertyStrategyMapper proPertyStrategyMapper = new ProPertyStrategyMapper(field.getName(),
                        idGenerator);
                propertys.add(proPertyStrategyMapper);
                break;
            } else if (String.class.equals(field.getType()) && "id".equalsIgnoreCase(field.getName())) {
                IdGenerator idGenerator = new UUIDGenerator();
                ProPertyStrategyMapper proPertyStrategyMapper = new ProPertyStrategyMapper(field.getName(),
                        idGenerator);
                propertys.add(proPertyStrategyMapper);
            }
        }
        return this;
    }
}
