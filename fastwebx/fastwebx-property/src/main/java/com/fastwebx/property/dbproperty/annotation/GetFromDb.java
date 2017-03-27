package com.fastwebx.property.dbproperty.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface GetFromDb {
	public String column() default "";
	public String defaultValue() default "";
	public String dateFormat() default "yyyy-MM-dd hh:mm:ss";
}
