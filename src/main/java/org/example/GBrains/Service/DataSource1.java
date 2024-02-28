package org.example.GBrains.Service;

import org.example.GBrains.Model.NumbersPool;
import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.MathOpForCompNum;

public class DataSource1 {
    NumbersPool complexNum1 = new ComplexNumber(1, MathOpForCompNum.ADDITION, "3i");
    NumbersPool complexNum2 = new ComplexNumber(4, MathOpForCompNum.SUBTRACTION, "5i");
}
