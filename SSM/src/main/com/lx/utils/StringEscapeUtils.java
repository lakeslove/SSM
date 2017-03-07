package com.lx.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.ui.Model;

public class StringEscapeUtils {
	
	public static Object escapeHtmlForBean(Object object) {
		if(object == null) {
			return null;
		}
		Class<?> srcClass = object.getClass();
		Object objNew = BeanUtils.instantiate(srcClass);
		BeanWrapper srcBeanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(object);
		BeanWrapper dstBeanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(objNew);
		Field[] fields = srcClass.getDeclaredFields();
		for (Field field : fields) {
			Type fieldType = field.getGenericType();
			String fieldName = field.getName();
			if( srcBeanWrapper.isReadableProperty(fieldName) == false ||
				srcBeanWrapper.isWritableProperty(fieldName) == false ) {
				continue;
			}
			Object fieldValue = srcBeanWrapper.getPropertyValue(fieldName);
			if(fieldValue!=null) {
				if (fieldType.equals(String.class)) {
					fieldValue = escapeHtml((String)fieldValue);
				} else if(field.isAnnotationPresent((Class<? extends Annotation>) Model.class)) {
					fieldValue = escapeHtmlForBean(fieldValue);
				}
			}
			dstBeanWrapper.setPropertyValue(fieldName, fieldValue);
		}
		return objNew;
	}

	public static String escapeHtml(String string) {
		if (string != null) {
			string = string.replaceAll("&", "&amp;");
			string = string.replaceAll(" ", "&nbsp;");
			string = string.replaceAll("<", "&lt;");
			string = string.replaceAll(">", "&gt;");
			string = string.replaceAll("\"", "&quot;");
			string = string.replaceAll("\\\\", "&#92;");
			string = string.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		}
		return string;
	}
}
