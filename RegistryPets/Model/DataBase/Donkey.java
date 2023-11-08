package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Donkey extends PackAnimals implements Serializable {
    public Donkey(Boolean flag, int id, String name, String birthdate, ArrayList<String> commands) {
        super(flag, id, name, birthdate, commands);
    }

    public Donkey() {
        this(false, 0, "", "", new ArrayList<String>());
    }

    @Override
    public Donkey getNewAnimal(int id, String name, String birthdate, ArrayList commands) {
        return new Donkey(true, id, name, birthdate, commands);
    }
}
