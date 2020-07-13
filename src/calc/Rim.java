package calc;

import java.util.*;

public class Rim implements Out{

    private final String firstOperand;
    private final String secondOperand;
    private final String operator;
    private int intRez;
    private String strRez;

    public Rim(String firstOperand,String operator, String secondOperand){
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }
    @Override
    public void init() throws MyException {

        int firstNum = toGrec(firstOperand);
        int secondNum = toGrec(secondOperand);

        if(operator.equals("+")) intRez = plus(firstNum, secondNum);
        if(operator.equals("-")) intRez = minus(firstNum, secondNum);
        if(operator.equals("*")) intRez = umn(firstNum, secondNum);
        if(operator.equals("/")) intRez = del(firstNum, secondNum);

        strRez = toRim(intRez);

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

    private int toGrec(String operand) {
        int x = -1;

        Map<String, Integer> mapRim = new HashMap<>();
        mapRim.put("I",1);
        mapRim.put("II",2);
        mapRim.put("III",3);
        mapRim.put("IV",4);
        mapRim.put("V",5);
        mapRim.put("VI",6);
        mapRim.put("VII",7);
        mapRim.put("VIII",8);
        mapRim.put("IX",9);
        mapRim.put("X",10);

        for(Map.Entry<String,Integer> p : mapRim.entrySet()){
            if(p.getKey().equals(operand)) x = p.getValue();
        }

        return x;
    }

    private String toRim(int intRez) throws MyException {

        if ((intRez <= 0) || (intRez > 100)) {
            throw new MyException("Полученное значение не в диапазоне (0,100)");
        }

        List<RimNum> romanNumerals = RimNum.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((intRez > 0) && (i < romanNumerals.size())) {
            RimNum currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= intRez) {
                sb.append(currentSymbol.name());
                intRez -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    @Override
    public void print() {
        System.out.println(strRez);
    }
}
