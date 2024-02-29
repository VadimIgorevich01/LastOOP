package org.example.GBrains.Model;

public class FractionComNum extends ComplexNumber{
    NumbersPool comNumber = new ComplexNumber();
    public FractionComNum(NumbersPool comNum, int down) {
        this.down = down;
        comNumber = comNum;
    }

    @Override
    public String toString() {
        if (down == 1) {
            return String.valueOf(comNumber.getNumberA()) + " "
                    + ((ComplexNumber) comNumber).getMathOperation() +
                    " " + ((ComplexNumber) comNumber).getImaginaryPartWArg();
        } else if (down == - 1){
            return String.valueOf("-(" + comNumber.getNumberA()) + " "
                    + ((ComplexNumber) comNumber).getMathOperation() +
                    " " + ((ComplexNumber) comNumber).getImaginaryPartWArg() + ")";
        } else {
            return String.valueOf("(" + comNumber.getNumberA()) + " "
                    + ((ComplexNumber) comNumber).getMathOperation() +
                    " " + ((ComplexNumber) comNumber).getImaginaryPartWArg() + ")"
                    + " / " + down;
        }
    }

    public FractionComNum() {
        super();
        this.down = 0;
    }

    @Override
    String getNumberType() {
        return "Абстрактная дробь";
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    private int down;
}
