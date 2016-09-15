package examples.while_ut1.ast;

import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;
import examples.while_ut1.analyzer.Types;

import java.util.HashMap;

public class Defined extends Exp {

    public final String var;

    public Defined(String var) {
        super();
        this.var = var;
    }

    @Override
    public String unparse() {
        // TODO Auto-generated method stub
        return "defined ( " + var + ")";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "defined ( " + var + ")";
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        int result = 1;
        result = result * 31 + (this.var == null ? 0 : this.var.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Defined other = (Defined) obj;
        return (this.var == null ? other.var == null : this.var.equals(other.var));
    }

    @Override
    public Object evaluate(HashMap<String, Object> state)
            throws RuntimeException {
        return state.containsKey(var);
        // TODO Auto-generated method stub
    }

    public Object check(CheckState state) {
        if (state.getStateHashMap().containsKey(var)) {
            return state.getStateHashMap().get(var);
        } else {
            return new ObjectState(Types.STRING, false);
        }
    }


}
