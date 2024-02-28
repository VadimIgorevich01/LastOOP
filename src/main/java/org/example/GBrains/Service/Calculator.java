package org.example.GBrains.Service;

import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.NumbersPool;

public class Calculator {
    OperableTwoNum addition = new AdditionTwoNum();

    NumbersPool addition(NumbersPool comNum1, NumbersPool comNum2) throws Exception {
        return addition.operate(comNum1, comNum2);
    }
}
