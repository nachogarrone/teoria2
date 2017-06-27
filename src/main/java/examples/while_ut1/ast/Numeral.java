package examples.while_ut1.ast;

/**
 * Created by nachogarrone on 6/20/17.
 */
public class Numeral extends Exp {
    public final Double number;

    public Numeral(Double number) {
        this.number = number;
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
        return unparse();
//        return "Numeral(" + number + ")";
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
}