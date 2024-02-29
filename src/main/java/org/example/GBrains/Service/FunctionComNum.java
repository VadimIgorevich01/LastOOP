package org.example.GBrains.Service;

import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.MathOpForCompNum;
import org.example.GBrains.Model.NumbersPool;

import java.util.LinkedList;

public class FunctionComNum implements ApplicableFunctionsComNum {

    @Override
    public int ImagPartFrStrToInt(NumbersPool num) throws Exception {
        String imaginaryPartFirst = ((ComplexNumber) num).getImaginaryPartWArg();
        char [] charArray = imaginaryPartFirst.toCharArray();
        LinkedList<Character> chArrIntOnly = new LinkedList<>();
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
            return applySignComNum(num, oneArg);
        } else {
            String imaginaryNumberString = "";
            for (int i = 0; i < chArrIntOnly.size(); i++) {
                int a = Character.getNumericValue(chArrIntOnly.get(i));
                imaginaryNumberString = imaginaryNumberString + chArrIntOnly.get(i);
            }
            int imaginaryNumber = Integer.parseInt (imaginaryNumberString);
            return applySignComNum(num, imaginaryNumber);
        }
    }

    @Override
    public NumbersPool FrIntRealImagToComNum(int realPartSum, int imaginaryPartSum) {
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
    }

    @Override
    public int MultiplyImagAndRealParts(NumbersPool ComNumImagPart, int AnotherComNumRealPart) throws Exception {
        int imagPartFirtstNumInt = ImagPartFrStrToInt(ComNumImagPart);
        int multiplyResult = AnotherComNumRealPart * imagPartFirtstNumInt;
        return multiplyResult;
    }

    @Override
    public int MultiplyTwoImagParts(NumbersPool firstComNum, NumbersPool secondComNum) throws Exception {
        int imagPartSecNumInt = ImagPartFrStrToInt(firstComNum) * ImagPartFrStrToInt(secondComNum);
        return imagPartSecNumInt;
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
