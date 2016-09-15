package examples.while_ut1.ast;

import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;
import examples.while_ut1.analyzer.Types;

import java.util.HashMap;
import java.util.Random;

/**
 * Representación de constantes numéricas o numerales.
 */
public class Numeral extends Exp {
    public final Double number;

    public Numeral(Double number) {
        this.number = number;
    }

    public static Numeral generate(Random random, int min, int max) {
        Double number;
        number = Double.valueOf(random.nextInt(max - min) + min);
        return new Numeral(number);
    }

    public Double getNumber() {
        return number;
    }

    @Override
    public String unparse() {
        return number.toString();
    }

    @Override
    public String toString() {
        return "Numeral(" + number + ")";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.number == null ? 0 : this.number.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Numeral other = (Numeral) obj;
        return (this.number == null ? other.number == null : this.number.equals(other.number));
    }

    @Override
    public Object evaluate(HashMap<String, Object> state) {
        return number;
    }

    public Object check(CheckState state) {
        return new ObjectState(Types.NUMERIC, false);
    }
}
