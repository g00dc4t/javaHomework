import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Неверный формат. Верный формат:" +
                    " Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!(components[2].matches(".+\\@.+\\.com"))) {
            throw new IllegalArgumentException("Не верный формат email. Верный формат: " +
                    " *****@*****.com");
        }
        if (!(components[3].matches("\\+7921\\d{7}"))) {
            throw new IllegalArgumentException("Не верный формат номера телефона. " +
                    " Верный формат: +7921*******");
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}