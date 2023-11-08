package RegistryPets.Model.FileHandler;

import java.io.Serializable;

public interface FileProcessing {
    void save(Serializable object);
    SaveList read();
}
