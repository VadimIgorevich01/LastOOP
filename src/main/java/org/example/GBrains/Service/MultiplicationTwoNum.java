package org.example.GBrains.Service;

import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.NumbersPool;

public class MultiplicationTwoNum extends AdditionTwoNum implements OperableTwoNum {
    ApplicableFunctionsComNum functions = new FunctionComNum();
    @Override
    public NumbersPool operate(NumbersPool num1, NumbersPool num2) throws Exception {
        if (num1 instanceof ComplexNumber && num2 instanceof ComplexNumber) {
            int realPartInt = num1.getNumberA() * num2.getNumberA();
            int imaginaryPartInt = functions.MultiplyImagAndRealParts(num1, num2.getNumberA());
            NumbersPool firstComNum = functions.FrIntRealImagToComNum(realPartInt, imaginaryPartInt);

            int realPartInt2NotFinal = functions.MultiplyTwoImagParts(num1, num2);
            int realPartInt2Final = -1 * realPartInt2NotFinal;
            int imaginaryPartInt2 = functions.MultiplyImagAndRealParts(num2, num1.getNumberA());
            NumbersPool secondComNum = functions.FrIntRealImagToComNum(realPartInt2Final, imaginaryPartInt2);

            return super.operate(firstComNum, secondComNum);
        } else {
            throw new Exception("На данный момент калькулятор работает только с комплексными числами");
        }
    }
}
