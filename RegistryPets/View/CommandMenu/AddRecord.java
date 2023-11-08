package RegistryPets.View.CommandMenu;

import RegistryPets.View.Console;

public class AddRecord implements Command{
    private Console console;
    public AddRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Добавить в реестр новое животное";
    }

    @Override
    public void execute() {
        console.addRecord();
    }
}
