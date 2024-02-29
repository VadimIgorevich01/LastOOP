package org.example.GBrains.Model;

public class ComplexNumber extends NumbersPool {
    private MathOpForCompNum mathOperation;
    private String imaginaryPart;

    public ComplexNumber(int realPart, MathOpForCompNum mathOp, String imaginaryPart) {
        setNumberA(realPart);
        this.imaginaryPart = imaginaryPart;
        this.mathOperation = mathOp;
    }
    public ComplexNumber () {
        setNumberA(0);
        this.imaginaryPart = "i";
        this.mathOperation = MathOpForCompNum.ADDITION;
    }


    public String getImaginaryPartWArg() {
        return imaginaryPart;
    }

    public String getMathOperation() {
        if (mathOperation == MathOpForCompNum.ADDITION) {
            return "+";
        } else {
            return "-";
        }
    }

    public void setMathOperation(MathOpForCompNum mathOperation) {
        this.mathOperation = mathOperation;
    }

    @Override
    String getNumberType() {
        return "Абстрактный";
    }

    @Override
    public String toString() {
        return String.valueOf(getNumberA()) + " " + getMathOperation() + " " + getImaginaryPartWArg();
    }
}
