package examples.while_ut1.ast;

import examples.while_ut1.analyzer.CheckState;

import java.util.HashMap;

/**
 * Categoría sintáctica de las expresiones aritméticas de While, las
 * construcciones del lenguaje que evalúan a un número.
 */
public abstract class Exp {

    abstract public String unparse();

    @Override
    public abstract String toString();

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    public abstract Object evaluate(HashMap<String,Object> state)throws RuntimeException;

    public abstract  Object check(CheckState state);

//	public static Exp generate(Random random, int min, int max) {
//		final int TERMINAL_COUNT = 2;
//		final int NONTERMINAL_COUNT = 4;
//		int i = min > 0 ? random.nextInt(NONTERMINAL_COUNT) + TERMINAL_COUNT
//			: random.nextInt(max > 0 ? NONTERMINAL_COUNT + TERMINAL_COUNT: TERMINAL_COUNT);
//		switch (i) {
//		//Terminals
//			case 0: return Numeral.generate(random, min-1, max-1);
//			case 1: return Variable.generate(random, min-1, max-1);
//		//Non terminals
//			case 2: return Multiplication.generate(random, min-1, max-1);
//			case 3: return Division.generate(random, min-1, max-1);
//			case 4: return Addition.generate(random, min-1, max-1);
//			case 5: return Subtraction.generate(random, min-1, max-1);
//			default: throw new Error("Unexpected error at AExp.generate()!");
//		}
//	}
}
