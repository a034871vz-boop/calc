package calc;

public class Grec implements Out {

    private int intRez;

    private final int firstNum;
    private final int secondNum;
    private final String operator;

    public Grec(int firstNum, String operator,int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
    }


    @Override
    public void init() {

        if(operator.equals("+")) intRez = plus(firstNum, secondNum);
        if(operator.equals("-")) intRez = minus(firstNum, secondNum);
        if(operator.equals("*")) intRez = umn(firstNum, secondNum);
        if(operator.equals("/")) intRez = del(firstNum, secondNum);
    }

    @Override
    public void print() {
        System.out.println(intRez);
    }

    @Override
    public int plus(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }

    @Override
    public int del(int a, int b) {
        return a/b;
    }

    @Override
    public int umn(int a, int b) {
        return a*b;
    }
}
