package org.example.GBrains.Service;

import org.example.GBrains.Model.ComplexNumber;
import org.example.GBrains.Model.FractionComNum;
import org.example.GBrains.Model.MathOpForCompNum;
import org.example.GBrains.Model.NumbersPool;

import java.lang.reflect.Array;
import java.util.Arrays;
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
            throw new Exception("Введите мнимую часть комплексного числа в формате " +
                    "число, буква. Например 3i");
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
    public NumbersPool FrIntRealImagToComNum(int realPart, int imaginaryPart) {
        String imaginaryPartStr = Integer.toString(Math.abs(imaginaryPart));
        if (imaginaryPart == 1 || imaginaryPart == - 1) {
            imaginaryPartStr = "i";
        } else {
            imaginaryPartStr += "i";
        }
        if (imaginaryPart < 0) {
            NumbersPool createdComNum = new ComplexNumber(realPart,
                    MathOpForCompNum.SUBTRACTION, imaginaryPartStr);
            return createdComNum;
        } else {
            NumbersPool createdComNum = new ComplexNumber(realPart,
                    MathOpForCompNum.ADDITION, imaginaryPartStr);
            return createdComNum;
        }
    }

    @Override
    public int MultiplyImagAndRealParts(NumbersPool ComNumImagPart,
                                        int AnotherComNumRealPart) throws Exception {
        int imagPartFirtstNumInt = ImagPartFrStrToInt(ComNumImagPart);
        int multiplyResult = AnotherComNumRealPart * imagPartFirtstNumInt;
        return multiplyResult;
    }

    @Override
    public int MultiplyTwoImagParts(NumbersPool firstComNum,
                                    NumbersPool secondComNum) throws Exception {
        int imagPartSecNumInt = ImagPartFrStrToInt(firstComNum) *
                ImagPartFrStrToInt(secondComNum);
        return imagPartSecNumInt;
    }

    @Override
    public NumbersPool reduction(NumbersPool up, int down) throws Exception {
        int realPart = up.getNumberA();
        int imaginaryPart = ImagPartFrStrToInt(up);
        int[] array = new int[]{realPart, imaginaryPart, down};
        int max = Arrays.stream(array).max().getAsInt();
        int reductionOk = 0;

        for (int i = max; i > 1 ; i--) {
            for (int j = 0; j < array.length; j++) {
                if (array [j] % i == 0) {
                    ++reductionOk;
                }
            }
            if (reductionOk == 3) {
                realPart /= i;
                imaginaryPart /= i;
                down /= i;
                i = 1;
            } else {
                reductionOk = 0;
            }
        }
        NumbersPool fractionComNum = new FractionComNum(FrIntRealImagToComNum(realPart,
                imaginaryPart), down);
        return fractionComNum;
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
