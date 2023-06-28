import java.util.*;

class Notebook {
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(int ram, int storage, String os, String color) {
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}

public class Main {
    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook(8, 512, "Windows", "Silver"));
        notebooks.add(new Notebook(16, 1024, "MacOS", "Space Gray"));
        notebooks.add(new Notebook(8, 256, "Linux", "Black"));
        notebooks.add(new Notebook(16, 512, "Windows", "White"));
        notebooks.add(new Notebook(8, 512, "Windows", "Silver"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = scanner.nextInt();

        System.out.println("Введите минимальное значение для выбранного критерия:");
        int minValue = scanner.nextInt();

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, criterion, minValue);
        System.out.println("Подходящие ноутбуки:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println("ОЗУ: " + notebook.getRam() +
                    ", Объем ЖД: " + notebook.getStorage() +
                    ", Операционная система: " + notebook.getOs() +
                    ", Цвет: " + notebook.getColor());
        }
    }

    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, int criterion, int minValue) {
        Set<Notebook> filteredNotebooks = new HashSet<>();
        for (Notebook notebook : notebooks) {
            boolean meetsCriteria = false;
            switch (criterion) {
                case 1:
                    meetsCriteria = notebook.getRam() >= minValue;
                    break;
                case 2:
                    meetsCriteria = notebook.getStorage() >= minValue;
                    break;
                case 3:
                    meetsCriteria = notebook.getOs().equalsIgnoreCase(Integer.toString(minValue));
                    break;
                case 4:
                    meetsCriteria = notebook.getColor().equalsIgnoreCase(Integer.toString(minValue));
                    break;
                default:
                    System.out.println("Неверный критерий.");
                    return filteredNotebooks;
            }
            if (meetsCriteria) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}
