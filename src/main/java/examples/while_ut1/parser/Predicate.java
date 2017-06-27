package examples.while_ut1.parser;

import java.util.List;

/**
 * Created by nachogarrone on 6/12/17.
 */
public interface Predicate {
    boolean eval(List<?> args);
}
