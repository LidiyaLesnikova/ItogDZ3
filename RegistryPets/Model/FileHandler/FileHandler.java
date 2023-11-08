package RegistryPets.Model.FileHandler;

import java.io.*;

public class FileHandler implements FileProcessing {
    String path;

    public FileHandler(String registryPets) {
        this.path = registryPets;
    }

    /**
     * Записать передаваемый список животных в файл
     * @param object - список животных
    */
    @Override
    public void save(Serializable object) {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(object);
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Читать список животных из файла
     * @return
     */
    @Override
    public SaveList read() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            SaveList ft = (SaveList) in.readObject();
            in.close();
            return ft;
        } catch (Exception e) {
            System.err.println(e);
            return new SaveList();
        }
    }
}
