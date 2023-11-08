package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Camel extends PackAnimals implements Serializable {
    public Camel(Boolean flag, int id, String name, String birthdate, ArrayList<String> commands) {
        super(flag, id, name, birthdate, commands);
    }

    public Camel() {
        this(false, 0, "", "", new ArrayList<String>());
    }

    @Override
    public Camel getNewAnimal(int id, String name, String birthdate, ArrayList commands) {
        return new Camel(true, id, name, birthdate, commands);
    }
}
