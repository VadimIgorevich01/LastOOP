package org.example.GBrains.Service;

import org.example.GBrains.Model.NumbersPool;

public class CalculatorType1 implements SuitableCalculators {
    OperableTwoNum addition = new AdditionTwoNum();
    OperableTwoNum multiplication = new MultiplicationTwoNum();

    public NumbersPool addition(NumbersPool comNum1, NumbersPool comNum2) throws Exception {
        return addition.operate(comNum1, comNum2);
    }

    @Override
    public NumbersPool multiplication(NumbersPool comNum1, NumbersPool comNum2) throws Exception {
        return multiplication.operate(comNum1, comNum2);
    }


}
