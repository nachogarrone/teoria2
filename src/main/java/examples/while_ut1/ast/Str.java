package examples.while_ut1.ast;

import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;
import examples.while_ut1.analyzer.Types;

import java.util.HashMap;

/** Representación de cadenas de caracteres
 */
public class Str extends Exp {
	public final String string;

	public Str(String string) {
		this.string = string;
	}

	@Override public String unparse() {
		return string;
	}

	@Override public String toString() {
		return "Str("+ string +")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Str str = (Str) o;

		return string != null ? string.equals(str.string) : str.string == null;
	}

	@Override
	public int hashCode() {
		return string != null ? string.hashCode() : 0;
	}

	public Object evaluate(HashMap<String,Object> state){
		return this.string;
	}

	public Object check(CheckState state) {
		return new ObjectState(Types.STRING, false);
	}
}
