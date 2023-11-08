package RegistryPets;
import RegistryPets.View.Console;
import RegistryPets.View.View;

public class Main {
    public static void main(String[] args) {
        String registryPets = "./RegistryPets/Model/DataBase/RegistryPets.txt";
        View start = new Console(registryPets);
        start.menuAction();
    }
}

