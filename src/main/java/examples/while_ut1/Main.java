package examples.while_ut1;

import java.io.*;
import java.util.HashMap;

import examples.while_ut1.ast.*;
import examples.while_ut1.parser.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> ");
		HashMap<String,Object> state = new HashMap<String,Object>();
		for (String line; (line = in.readLine()) != null ;) {
			line = line.trim();
			try {
				if (line.length() > 0) {
					Stmt prog = (Stmt)(Parser.parse(line).value);
					System.out.print("\t"+ prog +"\n");
					System.out.print("\t Evaluate \n");
					state = prog.evaluate(state);
					System.out.println("\t"+ state+"\n>");
				}
			} catch (Exception err) {
				System.err.print(err);
				err.printStackTrace();
			}
		}
	}
}

