package examples.while_ut1.ast;

import examples.while_ut1.analyzer.CheckState;

import java.util.HashMap;

public class Print extends Stmt {
	
	public final Exp expresion;
	
	
	public Print(Exp expresion) {
		super();
		this.expresion = expresion;
	}

	@Override
	public String unparse() {
		// TODO Auto-generated method stub
		return "print ( " + expresion.unparse() + ")";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "print ( " + expresion + ")";
		
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
		Print other = (Print)obj;
		return (this.expresion == null ? other.expresion == null : this.expresion.equals(other.expresion));
	}

	@Override
	public HashMap<String, Object> evaluate(HashMap<String, Object> state) {
		System.out.println((this.expresion.evaluate(state)).toString());
		// TODO Auto-generated method stub
		return state;
	}

	public CheckState check(CheckState state) {
		return state;
	}


}
