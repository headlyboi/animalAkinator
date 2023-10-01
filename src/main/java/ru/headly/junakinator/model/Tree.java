package ru.headly.junakinator.model;

public interface Tree<T> {

    void createTree(T t);

    T getTree();

    boolean containsNode(String animal);
}
