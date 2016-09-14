package examples.while_ut1.ast;

import examples.while_ut1.analyzer.CheckState;

import java.util.HashMap;

public class Length extends Exp {
	
	public final Exp expresion;
	
	public Length(Exp expresion) {
		super();
		this.expresion = expresion;
	}

	@Override
	public String unparse() {
		return "length (" + expresion.unparse() + ")";
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "length ( " + expresion + ")";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int result = 1;
		result = result * 31 + (this.expresion == null ? 0 : this.expresion.hashCode());
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Length other = (Length)obj;
		return (this.expresion == null ? other.expresion == null : this.expresion.equals(other.expresion));
		
	}

	@Override
	public Object evaluate(HashMap<String, Object> state)
			throws RuntimeException {
			 return expresion.evaluate(state).toString().length();
			//return (double) ((String)expresion.evaluate(state)).length();
		// TODO Auto-generated method stub
		
	}

	public Object check(CheckState state) {
		return state.getStateHashMap().get(expresion);
	}

}
