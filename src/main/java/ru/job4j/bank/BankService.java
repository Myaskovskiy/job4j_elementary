package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
          this.users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
         Optional<User> user = findByPassport(passport);
         List<Account> accountList = users.get(user.get());
         if (!accountList.contains(account)) {
             accountList.add(account);
         }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return  user.map(value -> users.get(value)
                .stream()
                .filter(e -> e.getRequisite().equals(requisite))
                .findFirst()
                .get());

    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean res = false;
        Optional<Account> accOne = this.findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accTwo = this.findByRequisite(destPassport, destRequisite);
        if (accOne.isPresent() && accTwo.isPresent() && accOne.get().getBalance() >= amount) {
            this.findByRequisite(srcPassport, srcRequisite).get().setBalance(accOne.get().getBalance() - amount);
            this.findByRequisite(destPassport, destRequisite).get().setBalance(accTwo.get().getBalance() + amount);
            res = true;
        }
        return res;
    }
}
