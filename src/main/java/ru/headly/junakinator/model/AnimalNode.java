package ru.headly.junakinator.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimalNode implements Node {


    private String animal;

    private String question;

    private AnimalNode no;

    private AnimalNode yes;

    public AnimalNode(String animal) {
        this.animal = animal;
    }

    public boolean isEndOfTree() {
        return no == null && yes == null;
    }

}
