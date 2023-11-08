package RegistryPets.View.CommandMenu;

import RegistryPets.View.Console;

public class ModifyRecord implements Command{
    private Console console;
    public ModifyRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Изменить данные животного в реестре";
    }

    @Override
    public void execute() {
        console.modifyRecord();
    }
}
