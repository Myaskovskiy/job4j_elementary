package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
          this.users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
         User user = findByPassport(passport);
         List<Account> accountList = users.get(user);
         if (!accountList.contains(account)) {
             accountList.add(account);
         }
    }

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean res = true;

        User userOne = findByPassport(srcPassport);
        User userTwo = findByPassport(destPassport);

        Account accOne = this.findByRequisite(srcPassport, srcRequisite);
        Account accTwo = this.findByRequisite(destPassport, destRequisite);
        if (userOne == null || userTwo == null || accOne == null || accTwo == null) {
            return false;
        }
        double amountAccOne = accOne.getBalance();
        if (amountAccOne < amount) {
            return false;
        }
        double amountAccTwo = accTwo.getBalance();
        this.findByRequisite(srcPassport, srcRequisite).setBalance(amountAccOne - amount);
        this.findByRequisite(destPassport, destRequisite).setBalance(amountAccTwo + amount);
        return res;
    }
}
