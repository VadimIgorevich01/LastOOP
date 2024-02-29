package org.example.GBrains.Controller;


import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.NumbersPool;
import org.example.GBrains.Service.CalculatorType1;
import org.example.GBrains.Service.CompNumberData;
import org.example.GBrains.Service.DataSourceMarker;
import org.example.GBrains.Service.SuitableCalculators;

public class Controller {
    private DataSourceMarker dataSource1 = new CompNumberData();
    private SuitableCalculators calculatorType1 = new CalculatorType1();
    private NumbersPool result = new ComplexNumber();


    public void run () throws Exception {
        result = calculatorType1.addition(dataSource1.getData().get(0),
                dataSource1.getData().get(1));
        System.out.println("result1 = " + result);

        result = calculatorType1.multiplication(dataSource1.getData().get(0),
                dataSource1.getData().get(1));
        System.out.println("result2 = " + result);

    }

}
