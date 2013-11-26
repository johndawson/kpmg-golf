package com.kpmg.golf.content;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@Inherited
@Documented
public @interface Component {
}
