package org.example.GBrains;

import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.MathOpForCompNum;
import org.example.GBrains.Model.NumbersPool;
import org.example.GBrains.Service.AdditionTwoNum;
import org.example.GBrains.Service.OperableTwoNum;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        OperableTwoNum operableTwoNum = new AdditionTwoNum();
        NumbersPool test = new ComplexNumber(-1, MathOpForCompNum.SUBTRACTION, "45i");
        NumbersPool test2 = new ComplexNumber(7, MathOpForCompNum.SUBTRACTION, "1i");
        NumbersPool result = new ComplexNumber();
        result = operableTwoNum.operate(test, test2);
        System.out.println(result);
    }
}