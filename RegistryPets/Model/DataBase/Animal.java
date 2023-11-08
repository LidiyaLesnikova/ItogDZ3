package RegistryPets.Model.DataBase;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Animal implements Serializable, AnimalInterface {
    protected int id;
    protected String name;
    protected Date birthdate;
    protected ArrayList<String> commands;

    public Animal(Boolean flag, int id, String name, String birthdate, ArrayList<String> commands) {
        if (flag) {
            setID(id);
            setName(name);
            setBirthdate(birthdate);
            this.commands = commands;
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    private void setID(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String newName){
        this.name = newName;
    }

    @Override
    public Date getBirthdate() {
        return this.birthdate;
    }

    @Override
    public void setBirthdate(String newBirthdate) {
        this.birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(newBirthdate, new ParsePosition(0));
    }

    @Override
    public ArrayList<String> getCommands() {
        return this.commands;
    }

    @Override
    public void setCommands(String command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        SimpleDateFormat simpDateForm = new SimpleDateFormat("dd MMM yyyy");
        return this.getClass().getSimpleName()+" \"" + this.name + "\" (id - " + this.id + ", birthday - " + simpDateForm.format(this.birthdate) + "). Commands: " + this.commands;
    }
}
