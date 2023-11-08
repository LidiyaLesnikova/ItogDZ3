package RegistryPets.Model.FileHandler;

import RegistryPets.Model.DataBase.AnimalInterface;
import RegistryPets.Model.DataBase.AnimalList;
import RegistryPets.Model.DataBase.Counter;

import java.io.Serializable;

public class SaveList implements Serializable {
    private static final long serialVersionUID = 1L;
    private AnimalList<AnimalInterface> animalList;
    private Counter counter;

    public SaveList(AnimalList<AnimalInterface> animalList, Counter counter) {
        this.animalList = animalList;
        this.counter = counter;
    }

    public SaveList() {
        this(new AnimalList<AnimalInterface>(), new Counter());
    }

    public AnimalList<AnimalInterface> getAnimalList() {
        return animalList;
    }

    public Counter getCounter() {
        return counter;
    }
}
