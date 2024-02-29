package org.example.GBrains.Service;

import org.example.GBrains.Model.NumbersPool;

public interface SuitableCalculators {
    NumbersPool addition(NumbersPool comNum1, NumbersPool comNum2) throws Exception;
    NumbersPool multiplication (NumbersPool comNum1, NumbersPool comNum2) throws Exception;


}
