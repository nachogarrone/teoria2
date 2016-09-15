package examples.while_ut1.analyzer;

/**
 * Created by nachogarrone on 7/9/16.
 */
public class ObjectState {
    Types variable;
    Boolean initialized;

    public ObjectState(Types variable, Boolean initialized) {
        this.variable = variable;
        this.initialized = initialized;
    }

    public ObjectState() {
        this.initialized = false;
    }

    public Types getVariable() {
        return variable;
    }

    public void setVariable(Types variable) {
        this.variable = variable;
    }

    public void setInitialized(Boolean initialized) {
        this.initialized = initialized;
    }

    public Boolean isInitialized(){
        return this.initialized;
    }
}