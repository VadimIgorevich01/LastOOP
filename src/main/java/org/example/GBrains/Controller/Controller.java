package org.example.GBrains.Controller;


import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.NumbersPool;
import org.example.GBrains.Service.CalculatorType1;
import org.example.GBrains.Service.CompNumberData;
import org.example.GBrains.Service.DataSourceMarker;
import org.example.GBrains.Service.SuitableCalculators;
import org.example.GBrains.View.ToConsole;
import org.example.GBrains.View.Viewable;

public class Controller {
    private DataSourceMarker dataSource1 = new CompNumberData();
    private SuitableCalculators calculatorType1 = new CalculatorType1();
    private NumbersPool result = new ComplexNumber();
    Viewable printToConsole = new ToConsole();


    public void run () throws Exception {
        printToConsole.showInConsole("Используются два комплексных числа:");
        printToConsole.showInConsole(dataSource1.getData().get(0) + " и " + dataSource1.getData().get(1));

        result = calculatorType1.addition(dataSource1.getData().get(0),
                dataSource1.getData().get(1));
        printToConsole.showInConsole("Результат сложения = " + result);

        result = calculatorType1.multiplication(dataSource1.getData().get(0),
                dataSource1.getData().get(1));
        printToConsole.showInConsole("Результат умножения = " + result);

        result = calculatorType1.division (dataSource1.getData().get(0),
                dataSource1.getData().get(1));
        printToConsole.showInConsole("Результат деления = " + result);
    }

}
