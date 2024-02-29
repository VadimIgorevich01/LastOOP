package org.example.GBrains.Service;

import org.example.GBrains.Model.NumbersPool;

public class CalculatorType1 implements SuitableCalculators {
    OperableTwoNum addition = new AdditionTwoNum();
    OperableTwoNum multiplication = new MultiplicationTwoNum();
    OperableTwoNum division = new DivisionTwoNum();

    public NumbersPool addition(NumbersPool Num1, NumbersPool Num2) throws Exception {
        return addition.operate(Num1, Num2);
    }

    @Override
    public NumbersPool multiplication(NumbersPool Num1, NumbersPool Num2) throws Exception {
        return multiplication.operate(Num1, Num2);
    }

    @Override
    public NumbersPool division(NumbersPool Num1, NumbersPool Num2) throws Exception {
        return division.operate(Num1, Num2);
    }


}
