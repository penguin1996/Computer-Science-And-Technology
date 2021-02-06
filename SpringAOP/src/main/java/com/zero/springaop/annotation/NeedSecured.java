package com.zero.springaop.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@Inherited
public @interface NeedSecured {
}
