package RegistryPets.View.CommandMenu;

import RegistryPets.View.Console;

public class ViewRegistry implements Command{
    private Console console;
    public ViewRegistry(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Показать весь реестр животных";
    }

    @Override
    public void execute() {
        console.ViewRegistry();
    }
}
