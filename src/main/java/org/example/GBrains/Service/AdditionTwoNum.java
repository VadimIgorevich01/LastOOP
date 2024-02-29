package org.example.GBrains.Service;

import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.NumbersPool;

public class AdditionTwoNum implements OperableTwoNum {
    ApplicableFunctionsComNum functionComNum = new FunctionComNum();

    @Override
    public NumbersPool operate(NumbersPool num1, NumbersPool num2) throws Exception {
        if (num1 instanceof ComplexNumber && num2 instanceof ComplexNumber) {
            int realPartSum = num1.getNumberA() + num2.getNumberA();
            int imaginaryPartSum = functionComNum.ImagPartFrStrToInt(num1)
                    + functionComNum.ImagPartFrStrToInt(num2);
            return functionComNum.FrIntRealImagToComNum(realPartSum, imaginaryPartSum);
        } else {
            throw new Exception("На данный момент калькулятор работает " +
                    "только с комплексными числами");
        }
    }
}
