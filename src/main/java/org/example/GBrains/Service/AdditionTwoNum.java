package org.example.GBrains.Service;

import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.MathOpForCompNum;
import org.example.GBrains.Model.NumbersPool;

import java.util.LinkedList;

public class AdditionTwoNum implements OperableTwoNum {



    @Override
    public NumbersPool operate(NumbersPool num1, NumbersPool num2) throws Exception {
        if (num1 instanceof ComplexNumber) {
            int realPartSum = num1.getNumberA() + num2.getNumberA();
            int imaginaryPartSum = getImaginaryPart(num1) + getImaginaryPart(num2);
            String imaginaryPartSumStr = Integer.toString(imaginaryPartSum);
            imaginaryPartSumStr += "i";
            if (imaginaryPartSum < 0) {
                imaginaryPartSum *= -1;
                imaginaryPartSumStr = Integer.toString(imaginaryPartSum);
                imaginaryPartSumStr += "i";
                NumbersPool additionResult = new ComplexNumber(realPartSum,
                        MathOpForCompNum.SUBTRACTION, imaginaryPartSumStr);
                return additionResult;
            } else {
                NumbersPool additionResult = new ComplexNumber(realPartSum,
                        MathOpForCompNum.ADDITION, imaginaryPartSumStr);
                return additionResult;
            }
        } else {
            return null;
        }
    }

    private int getImaginaryPart(NumbersPool num1) throws Exception {
        String imaginaryPartFirst = ((ComplexNumber) num1).getImaginaryPartWArg();
        char [] charArray = imaginaryPartFirst.toCharArray();
        LinkedList <Character> chArrIntOnly = new LinkedList<>();
        char[] chIntegersCheck = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int noArg = 0;
        boolean wasArg = true;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < chIntegersCheck.length; j++) {
                if (chIntegersCheck [j] == charArray [i]) {
                    chArrIntOnly.add(chIntegersCheck [j]);
                    j = chIntegersCheck.length;
                    wasArg = true;
                } else {
                    wasArg = false;
                }
            }
            if (wasArg) {
                ++noArg;
            }
        }
        if (noArg == charArray.length) {
            throw new Exception("Введите мнимую часть комплексного числа в формате число, буква. Например 3i");
        } else if (chArrIntOnly.isEmpty()) {
            int oneArg = 1;
            return applySignComNum(num1, oneArg);
        } else {
            String imaginaryNumberString = "";
            for (int i = 0; i < chArrIntOnly.size(); i++) {
                int a = Character.getNumericValue(chArrIntOnly.get(i));
                imaginaryNumberString = imaginaryNumberString + chArrIntOnly.get(i);
            }
            int imaginaryNumber = Integer.parseInt (imaginaryNumberString);
            return applySignComNum(num1, imaginaryNumber);
        }
    }
    private int applySignComNum (NumbersPool num, int imaginaryNumber) {
        if (((ComplexNumber) num).getMathOperation() == "-") {
            int result = imaginaryNumber * -1;
            return result;
        } else {
            return imaginaryNumber;
        }
    }
}
