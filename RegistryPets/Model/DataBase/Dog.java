package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Dog extends Pets implements Serializable {
    public Dog(Boolean flag, int id, String name, String birthdate, ArrayList<String> commands) {
        super(flag, id, name, birthdate, commands);
    }

    public Dog() {
        this(false, 0, "", "",new ArrayList<String>());
    }

    @Override
    public Dog getNewAnimal(int id, String name, String birthdate, ArrayList commands) {
        return new Dog(true, id, name, birthdate, commands);
    }
}
