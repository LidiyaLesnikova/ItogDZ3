package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimalList <T extends AnimalInterface> implements Serializable, Iterable<AnimalInterface> {
    private static final long serialVersionUID = 1L;
    private List<AnimalInterface> object; //перечень (список) возможных классов - животных для реестра
    private List<AnimalInterface> animalList; //список всех животных в реестре

    public AnimalList() {
        animalList = new ArrayList<>();

        object = new ArrayList<>();
        object.add(new Cat());
        object.add(new Dog());
        object.add(new Hamster());
        object.add(new Horse());
        object.add(new Camel());
        object.add(new Donkey());
    }

    /**
     * Получить список классов-животных, которые возможно добавить в реестр
     * @return список классов-животных
     */
    public List<String> getListObject() {
        return object.stream().map(o -> o.getClass().getSimpleName()).toList();
    }

    public List getAnimalList() {
        return this.animalList;
    }

    public void addAnimal(int id, int typeAnimal, String name, String birthday, ArrayList<String> commands) {
        AnimalInterface animal = object.get(typeAnimal);
        AnimalInterface newAnimal = animal.getNewAnimal(id, name, birthday, commands);
        animalList.add(newAnimal);
    }

    public void deleteAnimal(AnimalInterface deleteAnimal) {
        animalList.remove(deleteAnimal);
    }

    @Override
    public Iterator<AnimalInterface> iterator() {
        return animalList.iterator();
    }
}

