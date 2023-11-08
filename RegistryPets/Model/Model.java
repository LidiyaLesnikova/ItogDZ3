package RegistryPets.Model;

import RegistryPets.Model.DataBase.AnimalInterface;
import RegistryPets.Model.DataBase.AnimalList;
import RegistryPets.Model.DataBase.Counter;
import RegistryPets.Model.DataBase.Pets;
import RegistryPets.Model.FileHandler.FileHandler;
import RegistryPets.Model.FileHandler.SaveList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Model {
    private AnimalList animalList = new AnimalList();
    private static Counter counter = new Counter();
    public List<AnimalInterface> animals;
    private FileHandler fileHandler;
    private SaveList saveList;


    public Model(String registryPets) {
        fileHandler = new FileHandler(registryPets);
        fileRead(registryPets);
        animals = animalList.getAnimalList();
    }

    /**
     * Получить реестр животных
     *
     * @return список животных
     */
    public List getRegistry() {
        List newPetsAnimalList = new ArrayList<>();
        newPetsAnimalList.add("     ДОМАШНИЕ ЖИВОТНЫЕ: ");
        List newPackAnimalList = new ArrayList<>();
        newPackAnimalList.add("     ВЬЮЧНЫЕ ЖИВОТНЫЕ: ");
        for (AnimalInterface animal : animals) {
            if (animal instanceof Pets) {
                newPetsAnimalList.add(animal);
            } else {
                newPackAnimalList.add(animal);
            }
        }
        return Stream.concat(newPetsAnimalList.stream(), newPackAnimalList.stream()).toList();
    }

    /**
     * Получить список классов-животных (классов, созданных для каждого типа животных)
     *
     * @return список классов-животных
     */
    public List<String> getListObject() {
        return animalList.getListObject();
    }

    /**
     * Поиск животных в реестре, отвечающих строке поиска
     * @param findLine строка поиска
     * @return список с найденными животными
     */
    public List findAnimals(String findLine) {
        List findAnimals = new ArrayList<>();
        for (AnimalInterface animal : animals) {
            if (animal.toString().toLowerCase().contains(findLine.toLowerCase())) {
                findAnimals.add(animal);
            }
        }
        return findAnimals;
    }

    /**
     * Добавить животное в реестр
     * @param typeAnimal - номер типа животного, из списка типов
     * @param name       - кличка животного, введенная пользователем
     * @param birthday   - день рождения, введенный пользователем
     * @param commands   - список команд животного, введенный пользователем
     * @return текстовое сообщение
     */
    public String addAnimal(int typeAnimal, String name, String birthday, ArrayList<String> commands) {
        counter.add();
        animalList.addAnimal(getCount(), typeAnimal, name, birthday, commands);

        fileSave();
        return "Запись в реестр внесена";
    }

    /**
     * Получить показания счетчика ID реестра
     * @return номер счетчика
     */
    public int getCount() {
        return counter.getCount();
    }

    /**
     * Проверка, есть ли в реестре животное с запрашиваемым ID
     * @param idFind ID поиска
     * @return найденное животное
     */
    private AnimalInterface findAnimalOfID(int idFind) {
        for (AnimalInterface animal : animals) {
            if (animal.getId()==idFind) {
                return animal;
            }
        }
        return null;
    }

    /**
     * Проверка, есть ли в реестре животное с запрашиваемым ID
     * @param idFind ID поиска
     * @return boolean
     */
    public boolean isNull(int idFind){
        if (findAnimalOfID(idFind) == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Изменить имеющуюся запись в реестре по ID
     * @param idFind ID поиска
     * @param selectedProps изменяемый реквизит: 1 - имя, 2 - дата рождения, 3 - новая команда
     * @param newProps новое значение реквизита
     * @return сообщение пользователю
     */
    public String modifyRecord(int idFind, int selectedProps, String newProps) {
        AnimalInterface modifyAnimal = findAnimalOfID(idFind);
        String rez = "не найден реквизит?!?";
        if (selectedProps==1) {
            modifyAnimal.setName(newProps);
            rez = "позиция изменена";
        } else if (selectedProps==2) {
            modifyAnimal.setBirthdate(newProps);
            rez = "позиция изменена";
        } else if (selectedProps==3) {
            modifyAnimal.setCommands(newProps);
            rez = "позиция изменена";
        }
        fileSave();
        return rez;
    }

    /**
     * Удалить животное из реестра
     * @param idFind ID поиска
     * @return сообщение пользователю
     */
    public String deleteRecord(int idFind) {
        animalList.deleteAnimal(findAnimalOfID(idFind));
        fileSave();
        return "позиция удалена";
    }

    private void fileRead(String registryPets) {
        File file = new File(registryPets);
        if (file.exists()) {
            saveList = fileHandler.read();
            animalList = saveList.getAnimalList();
            counter = saveList.getCounter();
        }
    }

    private void fileSave(){
        if (!getListObject().isEmpty()) {
            saveList = new SaveList(animalList, counter);
            fileHandler.save(saveList);
        }
    }
}
