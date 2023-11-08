package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Cat extends Pets implements Serializable {
    public Cat(Boolean flag, int id, String name, String birthdate, ArrayList<String> commands) {
        super(flag, id, name, birthdate, commands);
    }

    public Cat() {
        this(false, 0, "", "",new ArrayList<String>());
    }

    @Override
    public Cat getNewAnimal(int id, String name, String birthdate, ArrayList commands) {
        return new Cat(true, id, name, birthdate, commands);
    }
}
