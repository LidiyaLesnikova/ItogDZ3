package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class PackAnimals extends Animal implements Serializable {
    public PackAnimals(Boolean flag, int id, String name, String birthdate, ArrayList<String> commands) {
        super(flag, id, name, birthdate, commands);
    }
}
