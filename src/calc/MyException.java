package calc;

public class MyException extends Exception {

    private String ex = "Ошибка введенных данных";

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString(){
        return "calc.MyException[" + ex + "]";
    }
}
