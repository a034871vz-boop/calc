package calc;

public interface Out {
    void init() throws MyException;
    void print();

    int plus(int a, int b);
    int minus(int a, int b);
    int del(int a, int b);
    int umn(int a, int b);
}
