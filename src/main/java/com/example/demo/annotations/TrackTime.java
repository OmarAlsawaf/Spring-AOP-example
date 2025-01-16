package com.example.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//we need to clearify that this annotation will be used on methods
@Retention(RetentionPolicy.RUNTIME)//we need to define when to use this annotation (runtime)
public @interface TrackTime {
}
