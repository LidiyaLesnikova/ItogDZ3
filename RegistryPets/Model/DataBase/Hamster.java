package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Hamster extends Pets implements Serializable {
    public Hamster(Boolean flag, int id, String name, String birthdate, ArrayList<String> commands) {
        super(flag, id, name, birthdate, commands);
    }

    public Hamster() {
        this(false, 0, "", "",new ArrayList<String>());
    }

    @Override
    public Hamster getNewAnimal(int id, String name, String birthdate, ArrayList commands) {
        return new Hamster(true, id, name, birthdate, commands);
    }
}
