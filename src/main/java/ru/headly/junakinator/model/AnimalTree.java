package ru.headly.junakinator.model;


import java.util.Objects;
import java.util.Optional;

public class AnimalTree<T extends Node> implements Tree<T> {

    private T root;

    public void createTree(T root) {
        this.root = root;
    }

    @Override
    public T getTree() {
        return root;
    }

    private Node searchedNode;

    /**
     * recursive alg. recommended to use with not large tree
     *
     * @return true if contains node, false - if not
     */
    @Override
    public boolean containsNode(String animal) {
        containsNodeInRoot(root, animal);
        Optional<Node> node = Optional.ofNullable(searchedNode);
        if (node.isPresent()) {
            return Objects.equals(searchedNode.getAnimal(), animal);
        }
        return false;
    }

    private void containsNodeInRoot(Node node, String animal) {
        if (root == null) {
            throw new RuntimeException("AnimalTree is empty!");
        }
        if (animal.equals(node.getAnimal())) {
            searchedNode = node;
        }
        if (node.getNo() != null) {
            containsNodeInRoot(node.getNo(), animal);
        }
        if (node.getYes() != null) {
            containsNodeInRoot(node.getYes(), animal);
        }
    }
}