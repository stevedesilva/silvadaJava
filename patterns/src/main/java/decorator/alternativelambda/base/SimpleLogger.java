package decorator.alternativelambda.base;


import decorator.alternativelambda.Logger;

public class SimpleLogger implements Logger {

    @Override
    public String log(String message) {
        System.out.println(message);
        return message;
    }

}
