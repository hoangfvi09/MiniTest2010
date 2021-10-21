package service;

public interface Manageable<T> {
    void add(T t);

    void print();

    T findById(int id);

    void editById(int id, String name, int age, double average);

    void removeById(int id);

    int findIndexById(int id);


}
