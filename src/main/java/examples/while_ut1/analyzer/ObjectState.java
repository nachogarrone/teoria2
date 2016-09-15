package examples.while_ut1.analyzer;

/**
 * Created by nachogarrone on 7/9/16.
 */
public class ObjectState {
    Types variable;
    Boolean initialized;
    String error;

    public ObjectState(Types variable, Boolean initialized) {
        this.variable = variable;
        this.initialized = initialized;
    }

    public ObjectState(Types variable, Boolean initialized, String error) {
        this.variable = variable;
        this.initialized = initialized;
        this.error = error;
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

    public Boolean isInitialized() {
        return this.initialized;
    }

    public Boolean getInitialized() {
        return initialized;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}