package io.github.Si1kn.Event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EventProcess {
    boolean ignoreCanceled() default true;
}
