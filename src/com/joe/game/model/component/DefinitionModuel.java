package com.joe.game.model.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This component will be the default value for all components.
 * Components such as position that are different for the parent containing the
 * component are not valid in the definition.
 */
@Retention(RetentionPolicy.RUNTIME) public @interface DefinitionModuel {

}
