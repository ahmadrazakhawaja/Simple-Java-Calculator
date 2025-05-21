package simplejavacalculatorTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static java.lang.Double.NaN;
import java.lang.Math;


import simplejavacalculator.Calculator;

class CalculatorTest {
	
	@Test
	void calculateBiNormalTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.NORMAL, 2.0);
		Assertions.assertEquals(NaN, calculator.calculateBi(Calculator.BiOperatorModes.NORMAL, 3.0));
    }
	
	@Test
	void calculateBiAddTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.ADD, 3.0);
		Assertions.assertEquals(5.5, calculator.calculateBi(Calculator.BiOperatorModes.NORMAL, 2.5));
	}
	
	@Test
	void calculateBiMinusTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.MINUS, 3.1415);
		Assertions.assertEquals(2.0415, calculator.calculateBi(Calculator.BiOperatorModes.NORMAL, 1.1));
	}
	
	@Test
	void calculateBiMultiplyTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.MULTIPLY, 3.2);
		Assertions.assertEquals(6.4, calculator.calculateBi(Calculator.BiOperatorModes.NORMAL, 2.0));
	}
	
	@Test
	void calculateBiDivideTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.DIVIDE, 6.4);
		Assertions.assertEquals(3.2, calculator.calculateBi(Calculator.BiOperatorModes.NORMAL, 2.0));
	}
	
	@Test
	void calculateEqualTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.ADD, 6.4);
		calculator.calculateBi(Calculator.BiOperatorModes.ADD, 2.0);
		Assertions.assertEquals(11.4, calculator.calculateEqual(3.0));
	}
	
	@Test
	void resetTest() {
		Calculator calculator = new Calculator();
		calculator.calculateBi(Calculator.BiOperatorModes.ADD, 6.4);
		Assertions.assertEquals(8.4, calculator.calculateBi(Calculator.BiOperatorModes.ADD, 2.0));
		Assertions.assertEquals(NaN, calculator.reset());		
	}
	
	@Test
	void CalculateMonoSquareTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(9.0, calculator.calculateMono(Calculator.MonoOperatorModes.SQUARE, 3.0));
	}
	
	@Test
	void CalculateMonoSquareRootTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(5.0, calculator.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT, 25.0));
	}
	
	@Test
	void CalculateMonoOneDividedByTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0.10, calculator.calculateMono(Calculator.MonoOperatorModes.ONEDIVIDEDBY, 10.0));
	}
	
	@Test
	void CalculateMonoSinTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0.5, calculator.calculateMono(Calculator.MonoOperatorModes.SIN, java.lang.Math.PI / 6), 0.0000000001);
	}
	
	@Test
	void CalculateMonoCosTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0.5, calculator.calculateMono(Calculator.MonoOperatorModes.COS, java.lang.Math.PI / 3), 0.0000000001);
	}
	
	@Test
	void CalculateMonoTanTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(1.0, calculator.calculateMono(Calculator.MonoOperatorModes.TAN, java.lang.Math.PI / 4), 0.0000000001);
	}
	
	@Test
	void CalculateMonoLogTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(2.0, calculator.calculateMono(Calculator.MonoOperatorModes.LOG, 100.0));
	}
	
	@Test
	void CalculateMonoRateTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(.75, calculator.calculateMono(Calculator.MonoOperatorModes.RATE, 75.0));
	}
	
	@Test
	void CalculateMonoAbsTest() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(3.0, calculator.calculateMono(Calculator.MonoOperatorModes.ABS, -3.0));
		Assertions.assertEquals(3.0, calculator.calculateMono(Calculator.MonoOperatorModes.ABS, 3.0));
	}

}
