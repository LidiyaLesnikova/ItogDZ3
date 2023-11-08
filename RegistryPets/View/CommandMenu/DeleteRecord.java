package RegistryPets.View.CommandMenu;

import RegistryPets.View.Console;

public class DeleteRecord implements Command{
    private Console console;
    public DeleteRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Удалить животное из реестра";
    }

    @Override
    public void execute() {
        console.deleteRecord();
    }
}
