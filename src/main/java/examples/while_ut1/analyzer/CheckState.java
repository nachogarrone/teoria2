package examples.while_ut1.analyzer;

import java.util.HashMap;

/**
 * Created by nachogarrone on 7/9/16.
 */
public class CheckState {
    HashMap<String, ObjectState> stateHashMap;

    public HashMap<String, ObjectState> getStateHashMap() {
        return stateHashMap;
    }

    public void setStateHashMap(HashMap<String, ObjectState> stateHashMap) {
        this.stateHashMap = stateHashMap;
    }
}
