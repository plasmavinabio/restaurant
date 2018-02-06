package restaurant.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public @Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TranslableMessage {
	Message[] messages();
}
