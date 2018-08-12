package com.myself.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhanghong
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ResponseBody
@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
public @interface PostMapping {
	
	/**
	 * Alias for {@link RequestMapping#value}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] value() default {};

}
