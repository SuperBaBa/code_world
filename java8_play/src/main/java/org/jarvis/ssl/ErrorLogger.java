package org.jarvis.ssl;

public class ErrorLogger extends AbstractLogger {
    @Override
    void write(String message) {
        System.out.println("Error::Logger"+message);
    }
    public ErrorLogger(int level){
        this.level = level;
    }
}
