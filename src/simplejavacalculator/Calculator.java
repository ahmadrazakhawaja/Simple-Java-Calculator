/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        Main.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import static java.lang.Double.NaN;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        NORMAL, ADD, MINUS, MULTIPLY, DIVIDE , XPOWEROFY
    }

    public enum MonoOperatorModes {
        SQUARE, SQUAREROOT, ONEDIVIDEDBY, COS, SIN, TAN, LOG, RATE, ABS, LN,
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.NORMAL;

    private Double calculateBiImpl() {
        if (mode.equals(BiOperatorModes.NORMAL)) {
            return num2;
        }
        if (mode.equals(BiOperatorModes.ADD)) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode.equals(BiOperatorModes.MINUS)) {
            return num1 - num2;
        }
        if (mode.equals(BiOperatorModes.MULTIPLY)) {
            return num1 * num2;
        }
        if (mode.equals(BiOperatorModes.DIVIDE)) {
            return num1 / num2;
        }
        if (mode.equals(BiOperatorModes.XPOWEROFY)) {
            return pow(num1,num2);
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode.equals(BiOperatorModes.NORMAL)) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.NORMAL, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.NORMAL;

        return NaN;
    }

    
    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        return switch (newMode) {
            case SQUARE       -> num * num;
            case SQUAREROOT   -> Math.sqrt(num);
            case ONEDIVIDEDBY -> 1.0 / num;
            case COS          -> Math.cos(Math.toRadians(num));
            case SIN          -> Math.sin(Math.toRadians(num));
            case TAN          -> tanDeg(num);
            case LOG          -> Math.log10(num);
            case LN           -> Math.log(num);
            case RATE         -> num / 100.0;
            case ABS          -> Math.abs(num);
        };
    }

    private static double tanDeg(double degrees) {
        if (degrees == 0 || degrees % 180 == 0 ) {
            return 0.0;
        }
        if (degrees % 90 == 0.0 && degrees % 180 != 0.0) {
            return NaN;
        }

        return Math.tan(Math.toRadians(degrees));
    }

}

