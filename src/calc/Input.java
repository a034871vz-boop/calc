package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Input {

    Out out = null;

    public void init() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputStr = reader.readLine();
            inputStr = inputStr.replaceAll("\\s+", "");

            out = prov1(inputStr);
            out.init();
            out.print();
        } catch (IOException | MyException e) {
            System.err.println(e + " : " + e.getMessage());
            System.exit(0);
        }
    }

    private Out prov1(String inputStr) throws MyException {

        int index = 0;
        int numOperators = 0;
        String operator = null;

        String[] operators = {"+", "-", "*", "/"};
        char[] symbols = inputStr.toCharArray();

        for (String op : operators) {
            for (int i = 0; i < inputStr.length(); i++) {
                String symbol = String.valueOf(symbols[i]);
                if (op.equals(symbol)) {
                    numOperators ++;
                    index = i;
                    operator = symbol;
                }
            }
        }

        if (numOperators == 1 && index != 0) return prov2(inputStr, index, operator);
        else throw new MyException("Отсутствует оператор или операторов больше одного.");
    }


    private Out prov2(String str, int index,String operator) throws MyException {
        String firstOperand;
        String secondOperand;
        StringBuilder stringBuilder = new StringBuilder(str);
        firstOperand = stringBuilder.substring(0,index);
        secondOperand = stringBuilder.substring(index+1);

        return prov3(firstOperand,operator,secondOperand);
    }

    private Out prov3(String firstOperand, String operator, String secondOperand) throws MyException {
        boolean isRim;
        boolean isGrec;

        isGrec = provGrec(firstOperand,secondOperand);

        if (isGrec) return new Grec(Integer.parseInt(firstOperand),operator,Integer.parseInt(secondOperand));
        else isRim = provRim(firstOperand,secondOperand);

        if (isRim) return new Rim(firstOperand,operator,secondOperand);
        else throw new MyException("Операнды не соответствуют условию.");

    }

    private boolean provGrec(String firstOperand, String secondOperand) {
        int firstNum;
        int secondNum;

        if(isDigit(firstOperand) && isDigit(secondOperand)) {
            firstNum = Integer.parseInt(firstOperand);
            secondNum = Integer.parseInt(secondOperand);
            return 0 < firstNum && firstNum <= 10 && 0 < secondNum && secondNum <= 10;
        }
        else return false;
    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean provRim(String firstOperand, String secondOperand) {
        int countRim = 0;
        List<String> listRim = Arrays.asList("I","II","III",
                "IV","V","VI","VII","VIII","IX","X");
        for(String str : listRim) {
            if (str.equals(firstOperand)){
                countRim ++;
            }
        }
        for(String str : listRim) {
            if (str.equals(secondOperand)){
                countRim ++;
            }
        }
        return countRim == 2;
    }
}
