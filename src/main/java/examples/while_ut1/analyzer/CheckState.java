package examples.while_ut1.analyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nachogarrone on 7/9/16.
 */
public class CheckState {
    HashMap<String, ObjectState> stateHashMap;

    public HashMap<String, ObjectState> getStateHashMap() {
        if (stateHashMap == null) stateHashMap = new HashMap<String, ObjectState>();
        return stateHashMap;
    }

    public void setStateHashMap(HashMap<String, ObjectState> stateHashMap) {
        this.stateHashMap = stateHashMap;
    }

    public boolean hasErrors() {
        for (Map.Entry<String, ObjectState> entry : stateHashMap.entrySet()) {
            if (entry.getValue().getError() != null && entry.getValue().getError() != "") return true;
        }
        return false;
    }
}
