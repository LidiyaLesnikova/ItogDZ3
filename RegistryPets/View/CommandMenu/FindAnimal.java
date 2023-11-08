package RegistryPets.View.CommandMenu;

import RegistryPets.View.Console;

public class FindAnimal implements Command{
    private Console console;
    public FindAnimal(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Поиск животного в реестре";
    }

    @Override
    public void execute() {
        console.findAnimal();
    }
}
