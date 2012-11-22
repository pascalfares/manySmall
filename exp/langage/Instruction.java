/*
 * LangageMath.java
 *
 * Created on 19 mars 2002, 12:41
 */

package exp.langage;

import static exp.interprete.NaopTokenizer.Token;
import exp.exceptions.ExpException;
import exp.exceptions.LangageMathException;
import exp.interprete.NaopTokenizer;
import exp.model.*;

/**
 * La grammaire LE Langage -> InstructionMath;* | quit InstructionMath -> AFFECT
 * | EVAL | SHOW | SEND AFFECT -> VAR = EXP EVAL -> !VAR SHOW -> #VAR SEND ->
 * send methode Atome args*
 * 
 * Semanrique: l'ensemble des couples (var,exp) constituent l'environnement
 * d'évaluation var <- exp => definition(var)=exp
 * 
 * @author pfares
 * @version V0.2
 */
public class Instruction {
	/** Creates new LangageMath */
	public Instruction() {

	}

	/**
	 * Parse des évaluation ou show
	 * 
	 * @param mt
	 *            Tokenizer
	 * @param ts
	 *            envronnement
	 * @param b
	 *            Eval ou show
	 * @throws exp.exp.exceptions.LangageMathException
	 *             Exception langage
	 * @throws exp.exceptions.ExpException
	 *             exception expression
	 */
	@SuppressWarnings("unused")
	private static void parseEval(NaopTokenizer mt,
			Environnement ts, boolean... b) throws LangageMathException,
			ExpException {
		Exp e;
		e = exp.model.Exp.parse(mt, ts);
		if (e == null)
			throw new LangageMathException("pas d'expression reconnue");
		if (b.length == 0)
			System.out.println(e.eval());
		else
			System.out.println(e);

	}

	private static Exp nparseEval(NaopTokenizer mt,
			Environnement ts, boolean... b) throws LangageMathException,
			ExpException {
		Exp e;
		e = Exp.parse(mt, ts);
		if (e == null)
			throw new LangageMathException("pas d'expression reconnue");
		if (b.length == 0)
			return (e.eval());
		else
			return (e);
	}

	/**
	 * Le parser des instructions
	 * 
	 * <pre>
	 * x=1;
	 * $> $> {x=[]}
	 * show x;
	 * $> Var:x[Const:1.0]
	 * x=2;
	 * show x;
	 * $> $> Var:x[Const:1.0, Const:2.0]
	 * !x;
	 * $> Const:2.0
	 * quit;
	 * </pre>
	 * 
	 * @param mt
	 *            Tokenizer
	 * @param ts
	 *            Environnement
	 * @throws exp.exp.exceptions.LangageMathException
	 *             Ecxeption lanagage
	 * @throws exp.exceptions.ExpException
	 *             Exception expression
	 * 
	 */
	public static Exp parse(NaopTokenizer mt,
			Environnement ts) throws LangageMathException,
			exp.exceptions.ExpException {
		// System.out.println(mt.getTok());
		if (mt.getTok() == Token.SYMBOL) { // une effectation
			return Affect.parse(mt, ts);
		} else if (mt.getTok() == Token.EVAL) {
			mt.nToken(); // skip !
			return nparseEval(mt, ts);
		} else if (mt.getTok() == Token.SHOW) {
			mt.nToken(); // skip !
			return nparseEval(mt, ts, true);
		} else {
			throw new LangageMathException("pas une instruction du langage");
		}
	}
}
