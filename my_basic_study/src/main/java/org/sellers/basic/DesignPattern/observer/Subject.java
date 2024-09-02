package org.sellers.basic.DesignPattern.observer;

public interface Subject {
    void registerObserver(Observer o);

    void removerObserver(Observer o);

    void notifyObservers();
}
