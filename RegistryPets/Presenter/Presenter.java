package RegistryPets.Presenter;

import RegistryPets.Model.Model;

import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private Model model;

    public Presenter(String registryPets){
        model = new Model(registryPets);
    }

    public List<Object> getRegistry() {
        return model.getRegistry();
    }

    public List<String> getListObject() {
        return model.getListObject();
    }

    public String addAnimal(int typeAnimal, String name, String birthday, ArrayList<String> commands) {
        return model.addAnimal(typeAnimal, name, birthday, commands);
    }

    public List getListAnimals() {
        return model.animals;
    }

    public List findAnimals(String findLine) {
        return model.findAnimals(findLine);
    }

    public String modifyRecord(int idFind, int selectedProps, String newProps) {
        return model.modifyRecord(idFind, selectedProps, newProps);
    }

    public String deleteRecord(int idFind) {
        return model.deleteRecord(idFind);
    }

    public int getCount() {
        return model.getCount();
    }

    public boolean isNull(int idFind) {
        return model.isNull(idFind);
    }
}