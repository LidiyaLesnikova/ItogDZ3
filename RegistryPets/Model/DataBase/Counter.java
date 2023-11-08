package RegistryPets.Model.DataBase;

import java.io.Serializable;

public class Counter implements Serializable {
    private int count;

    public int getCount() {
        return count;
    }

    public void add() {
        count++;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
