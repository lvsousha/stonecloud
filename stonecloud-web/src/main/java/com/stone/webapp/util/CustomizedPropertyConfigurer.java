package com.stone.webapp.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by taomengchun on 2016/12/12.
 */
public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer{


    private static Map<String, String> ctxPropertiesMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,
                                     Properties props)throws BeansException {

        super.processProperties(beanFactory, props);
        //load properties to ctxPropertiesMap
        ctxPropertiesMap = new HashMap<String, String>();
        System.out.println("=="+props.keySet().size());
        for (Object key : props.keySet()) {
        	System.out.println(key);
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    //static method for accessing context properties
    public static String getProperties(String name) {
        return ctxPropertiesMap.get(name);
    }
}
