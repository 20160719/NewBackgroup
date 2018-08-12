package com.myself.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhanghong
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@RequestMapping
public @interface CtrlRequestMapping {
	
	/**
	 * Alias for {@link RequestMapping#value}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] value() default {};

}
