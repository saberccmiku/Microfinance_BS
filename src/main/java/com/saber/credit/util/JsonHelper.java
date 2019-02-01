package com.saber.credit.util;

import net.sf.json.JSONArray;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saber on 2019/1/2
 */
public class JsonHelper {

    // private static final Logger log = Logger.getLogger(JsonHelper.class);

    /**
     * JSON转为类
     *
     * @param jsonStr
     * @param clazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     */
    public static <T> T toObject(String jsonStr, Class<T> clazz) throws JsonParseException, JsonMappingException {
        return fromJsonStringToBean(jsonStr, clazz);
    }

    /**
     * 类转为JSON对象<br/>
     * 如果类中有无需转换的属性，使用@JsonIgnore
     *
     * @param o
     * @return
     */
    public static String toJsonString(Object o) {
        return fromBeanToJsonString(o);
    }

    /**
     * 将json字符串转换为List<Bean>的java对象
     *
     * @Title: fromJsonStringToList
     * @Description:
     * @param json
     *            json字符串
     * @param c
     *            解析后， Bean的实际类型
     * @return 返回List<Bean>的java对象
     */
    public static <T> List<T> toList(String json, Class<T> c) {
        // 字符串为空时，返回空对象
        if (json == null || json.equals("")) {
            return null;
        }
        // 将json字符串解析为jsonArray
        JSONArray jsonArray = JSONArray.fromObject(json);
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < jsonArray.size(); i++) {
            // jsonArray的每一项转换为一个bean对象
            T t = (T) JsonHelper.fromJsonStringToBean(jsonArray.getString(i), c);
            list.add(t);
        }
        return list;
    }

    /**
     *
     * @description:bean转json的String，其中Date类型会被转换为long的数值
     * @author: fengzt
     * @createDate: 2014年6月4日
     * @param bean
     *            仅含基本类型
     * @return:json
     */
    public static String fromBeanToJsonString(Object bean) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        // mapper.configure( SerializationConfig.Feature.INDENT_OUTPUT, true );
        String json = null;
        try {
            json = mapper.writeValueAsString(bean);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     *
     * @description:jsonString转bean，如果bean中有Date，则jsonString中对应的应为long型
     * @author: fengzt
     * @createDate: 2014年6月4日
     * @param jsonString
     * @param clazz
     * @return:
     */
    public static <T> T fromJsonStringToBean(String jsonString, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        // 避免json中多余的字段设值时抛异常的问题
        objectMapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T bean = null;
        try {
            objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            bean = objectMapper.readValue(jsonString, clazz);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
