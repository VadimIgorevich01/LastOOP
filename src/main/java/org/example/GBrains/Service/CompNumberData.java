package org.example.GBrains.Service;

import org.example.GBrains.Model.NumbersPool;
import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.MathOpForCompNum;

import java.util.ArrayList;
import java.util.List;

public class CompNumberData implements DataSourceMarker {
    public NumbersPool complexNum1 = new ComplexNumber
            (13, MathOpForCompNum.ADDITION, "i");
    public NumbersPool complexNum2 = new ComplexNumber
            (7, MathOpForCompNum.SUBTRACTION, "6i");
    List<NumbersPool> dataNumbers = new ArrayList<>();


    @Override
    public List <NumbersPool> getData() {
        dataNumbers.add(complexNum1);
        dataNumbers.add(complexNum2);
        return dataNumbers;
    }
}
