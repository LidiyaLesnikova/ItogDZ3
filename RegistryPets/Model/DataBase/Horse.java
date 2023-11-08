package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Horse extends PackAnimals implements Serializable {
    public Horse(Boolean flag, int id, String name, String birthdate, ArrayList<String> commands) {
        super(flag, id, name, birthdate, commands);
    }

    public Horse() {
        this(false, 0, "", "", new ArrayList<String>());
    }

    @Override
    public Horse getNewAnimal(int id, String name, String birthdate, ArrayList commands) {
        return new Horse(true, id, name, birthdate, commands);
    }
}
