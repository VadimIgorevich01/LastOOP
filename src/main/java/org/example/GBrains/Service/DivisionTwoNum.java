package org.example.GBrains.Service;

import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.MathOpForCompNum;
import org.example.GBrains.Model.NumbersPool;

public class DivisionTwoNum extends MultiplicationTwoNum implements OperableTwoNum {
    @Override
    public NumbersPool operate(NumbersPool num1, NumbersPool num2) throws Exception {
        if (num1 instanceof ComplexNumber && num2 instanceof ComplexNumber) {
            int downReal = (int) Math.pow(num2.getNumberA(), 2);
            int downImag = (int) Math.pow(functionComNum.ImagPartFrStrToInt(num2), 2);
            int down = downReal + downImag;

            if (((ComplexNumber) num2).getMathOperation() == "+") {
                ((ComplexNumber) num2).setMathOperation(MathOpForCompNum.SUBTRACTION);
            } else {
                ((ComplexNumber) num2).setMathOperation(MathOpForCompNum.ADDITION);
            }
            NumbersPool up = super.operate(num1, num2);

            return functionComNum.reduction (up, down);
        } else {
            throw new Exception("На данный момент калькулятор работает только " +
                    "с комплексными числами");
        }
    }
}
