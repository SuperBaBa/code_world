package org.jarvis.java8.prototype.example.shape;

public interface Shape extends Cloneable {
    double calculateArea();

    Shape clone();
}
