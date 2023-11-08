package RegistryPets.Model.DataBase;

import java.util.ArrayList;
import java.util.Date;

public interface AnimalInterface<T> {
    int getId();
    String getName();
    void setName(String newName);
    Date getBirthdate();
    void setBirthdate(String newBirthdate);
    ArrayList<String> getCommands();
    void setCommands(String command);
    AnimalInterface getNewAnimal(int id, String name, String birthdate, ArrayList<String> commands);
}
