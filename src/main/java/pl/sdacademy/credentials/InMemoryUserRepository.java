package pl.sdacademy.credentials;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// C3
public class InMemoryUserRepository implements UserRepository {


    private List<User> users = new ArrayList<>();

    //    C5 - modyfikacja metody
    @Override
    public User readById(int id) {
        return users.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    //    C4 - modyfikacja metody
    @Override
    public List<User> readAll() {
        return users;
    }

    //    C6 - modyfikacja metody
    @Override
    public void create(User user) {
        Integer id = users.stream().mapToInt(User::getId).max().orElse(0) + 1;
        user.setId(id);
        users.add(user);
    }
// C7 - modyfikacja metody
    @Override
    public void update(User user) {
        int id = user.getId();
        User userToUpdate = readById(id);
        if (userToUpdate != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj aktualne imię: ");
            String newFirstName = scanner.nextLine();
            userToUpdate.setFirstName(newFirstName);
            System.out.println("Podaj aktualne nazwisko: ");
            String newLastName = scanner.nextLine();
            userToUpdate.setLastName(newLastName);
            System.out.println("Podaj zaktualizowaną datę urodzenia w formacie YYYY-MM-DD : ");
            String newDateOfBirth = scanner.nextLine();
            LocalDate newDateOfBirthLD = LocalDate.parse(newDateOfBirth);
            userToUpdate.setDateOfBirth(newDateOfBirthLD);
            System.out.println("Czy użytkownik jest adminem - wpisz literę T jeśli tak lub N jeśli nie");
            String odp = scanner.nextLine();
            boolean admin;
            switch (odp) {
                case "T":
                    admin = true;
                    userToUpdate.setAdmin(admin);
                    break;
                case "N":
                    admin = false;
                    userToUpdate.setAdmin(admin);
                    break;
                default:
                    System.out.println("Podałeś niewłaściwą literę, spróbuj ponownie");
            }
        }
    }

//    C8 - modyfikacja metody
    @Override
    public void delete(User user) {
        users = users.stream()
                .filter(userInList -> !user.equals(userInList))
                .collect(Collectors.toList());
    }
}
