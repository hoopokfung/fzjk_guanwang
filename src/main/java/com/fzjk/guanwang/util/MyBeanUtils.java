package com.fzjk.guanwang.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class MyBeanUtils {

    /**
     * 获取所有的属性值为空的属性名数组
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source){
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);//Bean的包装，BeanWrapperImpl是BeanWrapper接口的默认实现
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();//获取被包装bean的属性描述器
        List<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd : pds){
            String propertyName = pd.getName();//获取属性名称
            if (beanWrapper.getPropertyValue(propertyName) == null) { //如果该属性值为空，则加入到数组中
                nullPropertyNames.add(propertyName);
            }
        }

        return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
    }

}
