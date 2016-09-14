package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;

import java.util.*;

/**
 * Representación de usos de variable en expresiones.
 */
public class Variable extends Exp {
    public final String id;

    public Variable(String id) {
        this.id = id;
    }

    public static Variable generate(Random random, int min, int max) {
        String id;
        id = "" + "abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26));
        return new Variable(id);
    }

    @Override
    public String unparse() {
        return id;
    }

    @Override
    public String toString() {
        return "Variable(" + id + ")";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.id == null ? 0 : this.id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Variable other = (Variable) obj;
        return (this.id == null ? other.id == null : this.id.equals(other.id));
    }

    @Override
    public Object evaluate(HashMap<String, Object> state) throws RuntimeException {
        if (state.containsKey(id)) {
            Object value = state.get(id);
            return value;
        } else {
            throw new RuntimeException(id + " No está definida en state");
        }

    }

    public Object check(CheckState state) {
        if (state.getStateHashMap().get(id) == null) {
            Logger.log(getClass().getName(), "Variable no definida. El compilador no se puede recuperar!");
        }
        return state.getStateHashMap().get(id);
    }

}
