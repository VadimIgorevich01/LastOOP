package org.example.GBrains.Service;

import org.example.GBrains.Model.NumbersPool;

public interface ApplicableFunctionsComNum {
    int ImagPartFrStrToInt(NumbersPool num) throws Exception;
    NumbersPool FrIntRealImagToComNum(int realPartSum, int imaginaryPartSum);
    int MultiplyImagAndRealParts(NumbersPool SecondNum, int realPartSecNum) throws Exception;

    int MultiplyTwoImagParts (NumbersPool firstComNum, NumbersPool secondComNum) throws Exception;
}
