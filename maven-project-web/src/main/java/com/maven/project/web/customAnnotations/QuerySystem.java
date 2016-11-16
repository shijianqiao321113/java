package com.maven.project.web.customAnnotations;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface QuerySystem {
	String description() default "";
}
