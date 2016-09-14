package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;

import java.util.HashMap;

/** Representación de las iteraciones while-do.
 */
public class WhileDo extends Stmt {
	public final Exp condition;
	public final Stmt body;

	public WhileDo(Exp condition, Stmt body) {
		this.condition = condition;
		this.body = body;
	}

	@Override public String unparse() {
		return "while "+ condition.unparse() +" do { "+ body.unparse() +" }";
	}

	@Override public String toString() {
		return "WhileDo("+ condition +", "+ body +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
		result = result * 31 + (this.body == null ? 0 : this.body.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		WhileDo other = (WhileDo)obj;
		return (this.condition == null ? other.condition == null : this.condition.equals(other.condition))
				&& (this.body == null ? other.body == null : this.body.equals(other.body));
	}

	public HashMap<String, Object> evaluate(HashMap<String,Object> state){
		while((Boolean) condition.evaluate(state)){
			state = body.evaluate(state);
		}
		return state;
	}

	public CheckState check(CheckState state) {
		ObjectState checkCondition = (ObjectState) condition.check(state);
		if (!(checkCondition).getVariable().equals(ObjectState.Types.BOOLEAN)){
			Logger.log(this.getClass().getName(), "While no tiene condición booleana. ");
		}

		CheckState checkBody = body.check(state);
		CheckState result = state;
		result.getStateHashMap().entrySet().retainAll(checkBody.getStateHashMap().entrySet());

		return result;
	}

//	public static WhileDo generate(Random random, int min, int max) {
//		BExp condition; Stmt body;
//		condition = BExp.generate(random, min-1, max-1);
//		body = Stmt.generate(random, min-1, max-1);
//		return new WhileDo(condition, body);
//	}
}
