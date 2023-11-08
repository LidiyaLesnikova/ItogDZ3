package RegistryPets.View;

import RegistryPets.Presenter.Presenter;
import RegistryPets.View.CommandMenu.MainMenu;
import RegistryPets.View.CommandMenu.MenuInterface;
import RegistryPets.View.Printable.PrintInterface;
import RegistryPets.View.Printable.PrintObjectList;
import java.util.*;

public class Console implements View {
    private Scanner scan;
    private Presenter presenter;
    private MenuInterface mainMenu;
    private PrintInterface printable;
    private boolean work = true;

    public Console(String registryPets) {
        presenter = new Presenter(registryPets);
        scan = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        printable = new PrintObjectList();
    }

    /**
     * Вывод основного меню работы с пользователем
     */
    @Override
    public void menuAction() {
        while (work) {
            System.out.println("\nВыберите пункт меню: ");
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu(1,mainMenu.size())-1;
            mainMenu.execute(choice);
        }
    }

    /**
     * Показать весь реестр животных
     */
    public void ViewRegistry() {
        System.out.println(printable.output(presenter.getRegistry()));
        work = true;
    }

    /**
     * Поиск животного в реестре
     */
    public void findAnimal() {
        if (presenter.getListAnimals().isEmpty()) {
            System.out.println("Реестр с животными пуст, найти ничего невозможно");
        } else {
            System.out.print("Введите строку поиска: ");
            String findLine = scan.nextLine();
            System.out.println(printable.output(presenter.findAnimals(findLine)));
        }
        work = true;
    }

    /**
     * Добавить в реестр новое животное
     */
    public void addRecord() {
        work = true;
        List<String> objectList;
        while (work) {
            System.out.println("Выберите животное, которое необходимо добавить в реестр: ");
            objectList = presenter.getListObject();
            System.out.println(printable.output(objectList));
            int typeAnimal = inputNumMenu(1, objectList.size()) - 1;
            String name = getText("Введите кличку животного: ");
            String birthday = getBirthday("Введите дату рождения животного формата гггг-мм-дд: ");
            ArrayList<String> commands = getCommandsAnimal("Введите команду, которую может выполнять добавленное животное: ", 0);
            System.out.println(presenter.addAnimal(typeAnimal, name, birthday, commands));
        }
        work = true;
    }

    /**
     * Изменение реквизитов животного в реестре
     */
    public void modifyRecord() {
        int idFind = findAnimalOfID("Введите ID животного, запись которого надо исправить");
        if (idFind!=-1) {
            System.out.println("Выберите какой реквизит надо исправить:\n"+
                    "1. Name\n"+
                    "2. Birthday\n"+
                    "3. Commands");
            int selectedProps = inputNumMenu(1, 3);
            String newProps = "";
            switch (selectedProps) {
                case 1:
                    newProps = getText("Введите новое имя");
                    break;
                case 2:
                    newProps = getBirthday("Введите новую дату рождения");
                    break;
                case 3:
                    newProps = getText("Введите новую команду");
                    break;
            }
            System.out.println(presenter.modifyRecord(idFind, selectedProps, newProps));
        }
        work = true;
    }

    /**
     * Удалить животное по ID
     */
    public void deleteRecord() {
        int idFind = findAnimalOfID("Введите ID животного, запись которого надо удалить");
        if (idFind!=-1) {
            System.out.println(presenter.deleteRecord(idFind));
        }
        work = true;
    }

    /**
     * Конец работы - прерывание работы программы
     */
    public void quit() {
        System.out.println("До свидания)");
        work = false;
    }


    /**
     * Ввод номера из предлагаемого списка
     * @param from - начало отсчета
     * @param to - конец отсчета
     * @return - введенный пользователем номер, соответствующий пределам
     */
    private int inputNumMenu(int from, int to) {
        work = true;
        String line = "";
        while (work) {
            line = scan.nextLine();
            if (!checkLine(line, from, to)) {
                System.out.println("Ошибка ввода, еще раз");
                continue;
            }
            work = false;
        }
        return Integer.parseInt(line);
    }

    /**
     * Проверка введенного номера на соответствие пределов
     * @param line введенная пользователем строка
     * @param from - начало предела
     * @param to - конец предела
     * @return - соответсвует/не соответствует
     */
    private boolean checkLine(String line, int from, int to) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice >= from && choice <= to;
    }

    /**
     * Ввод текстовой строки
     * @param message сообщение пользователю
     * @return введенная строка
     */
    private String getText(String message) {
        System.out.println(message);
        return scan.nextLine();
    }

    /**
     * Ввод даты рождения животного
     * @param message сообщение пользователю
     * @return строка с датой рождения
     */
    private String getBirthday(String message) {
        String birthday = "";
        work = true;
        while (work) {
            birthday = getText(message);
            if (!birthday.matches("[1-2][0-9][0-9][0-9][-](0[0-9]|1[0-2])[-](0[0-9]|1[0-9]|2[0-9]|3[0-1])")) {
                System.out.println("Ошибка ввода, еще раз");
                continue;
            }
            work = false;
        }
        return birthday;
    }

    /**
     * Ввод списка команд, которые выполняет животное
     * @return список команд
     */
    private ArrayList<String> getCommandsAnimal(String message, int flag) {
        work = true;
        String command = "";
        ArrayList<String> commandsList = new ArrayList<>();
        System.out.println(message);
        while (work) {
            command = scan.nextLine();
            if (command.isEmpty()) {
                System.out.println("Ошибка ввода, еще раз");
                continue;
            }
            if (command.equals("0")) {
                work = false;
            } else {
                commandsList.add(command);
                System.out.println("Введите еще одну команду (0 - закончить ввод): ");
            }
        }
        return commandsList;
    }

    /**
     * Найти животное в реестре по ID
     * @param message сообщение пользователю
     * @return ID животного
     */
    private int findAnimalOfID(String message) {
        int idFind = -1;
        if (presenter.getListAnimals().isEmpty()) {
            System.out.println("Реестр с животными пуст, исправить ничего невозможно");
        } else {
            int count = presenter.getCount();
            System.out.print(message+" (число от 1 до "+count+"): ");
            idFind = inputNumMenu(1, count);
            if (!presenter.isNull(idFind)) {
                System.out.println("Животного в реестре с ID = "+idFind+" нет");
                idFind = -1;
            }
        }
        return idFind;
    }
}