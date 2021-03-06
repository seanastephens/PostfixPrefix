package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.Token;
import core.TokenException;

public class TokenTest {

	@Test
	public void testConstructorAndToString() {
		Token t = new Token("123");
		assertTrue("123".equals(t.toString()));
	}

	@Test
	public void testIsOperator() {
		Token no1 = new Token("1");
		Token no2 = new Token("111");
		Token no3 = new Token("-12");
		Token no4 = new Token("0");
		Token no5 = new Token(")");
		Token ye1 = new Token("*");
		Token ye2 = new Token("/");
		Token ye3 = new Token("+");
		Token ye4 = new Token("-");

		assertTrue(ye1.isOperator());
		assertTrue(ye2.isOperator());
		assertTrue(ye3.isOperator());
		assertTrue(ye4.isOperator());

		assertFalse(no1.isOperator());
		assertFalse(no2.isOperator());
		assertFalse(no3.isOperator());
		assertFalse(no4.isOperator());
		assertFalse(no5.isOperator());

	}

	@Test
	public void testIsOperand() {
		Token ye1 = new Token("1001");
		Token ye2 = new Token("1");
		Token ye3 = new Token("-12");
		Token ye4 = new Token("-123");

		Token no1 = new Token("*");
		Token no2 = new Token("/");
		Token no3 = new Token("+");
		Token no4 = new Token("-");
		Token no5 = new Token(")");

		assertTrue(ye1.isOperand());
		assertTrue(ye2.isOperand());
		assertTrue(ye3.isOperand());
		assertTrue(ye4.isOperand());

		assertFalse(no1.isOperand());
		assertFalse(no2.isOperand());
		assertFalse(no3.isOperand());
		assertFalse(no4.isOperand());
		assertFalse(no5.isOperand());
	}

	@Test
	public void testIsOpenParenthesis() {
		Token no1 = new Token("*");
		Token no2 = new Token("1");
		Token no3 = new Token("-12");
		Token no4 = new Token("0");
		Token no5 = new Token(")");
		Token yes = new Token("(");

		assertFalse(no1.isOpenParenthesis());
		assertFalse(no2.isOpenParenthesis());
		assertFalse(no3.isOpenParenthesis());
		assertFalse(no4.isOpenParenthesis());
		assertFalse(no5.isOpenParenthesis());
		assertTrue(yes.isOpenParenthesis());

	}

	@Test
	public void testIsCloseParenthesis() {
		Token no1 = new Token("*");
		Token no2 = new Token("1");
		Token no3 = new Token("-123");
		Token no4 = new Token("0");
		Token no5 = new Token("(");
		Token yes = new Token(")");

		assertFalse(no1.isCloseParenthesis());
		assertFalse(no2.isCloseParenthesis());
		assertFalse(no3.isCloseParenthesis());
		assertFalse(no4.isCloseParenthesis());
		assertFalse(no5.isCloseParenthesis());
		assertTrue(yes.isCloseParenthesis());
	}

	@Test
	public void testIsLowPrecedenceOp() {
		Token no1 = new Token("*");
		Token no2 = new Token("/");
		Token ye1 = new Token("+");
		Token ye2 = new Token("-");

		assertFalse(no1.isLowPrecedence());
		assertFalse(no2.isLowPrecedence());
		assertTrue(ye1.isLowPrecedence());
		assertTrue(ye2.isLowPrecedence());
	}

	@Test
	public void testIsHighPrecedenceOp() {
		Token ye1 = new Token("*");
		Token ye2 = new Token("/");
		Token no1 = new Token("+");
		Token no2 = new Token("-");

		assertFalse(no1.isHighPrecedence());
		assertFalse(no2.isHighPrecedence());
		assertTrue(ye1.isHighPrecedence());
		assertTrue(ye2.isHighPrecedence());
	}

	@Test(expected = TokenException.class)
	public void testExceptionOnEmptyString() {
		@SuppressWarnings("unused")
		Token t = new Token("");
	}

	@Test(expected = TokenException.class)
	public void testExceptionOnLetterString() {
		@SuppressWarnings("unused")
		Token t = new Token("A");
	}

	@Test(expected = TokenException.class)
	public void testExceptionOnBadString() {
		@SuppressWarnings("unused")
		Token t = new Token("$");
	}
}
