package org.example.yerin.tdd.acount;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void join(Account account) {
        repository.insert(account);
    }

    public Account getAccount(Long id) {
        return repository.findById(id);
    }

    public Account login(String username, String password) {
        if(username == null)
            throw new IllegalArgumentException("null");
        Account account = repository.findByUsername(username);

        if(account == null) return null;

        if(!matchPassword(password, account)) {
            account.increaseWrongCount();
            if(account.getLock()) {
                throw new AccountLockedException(username);
            }
            throw new LoginFailedException(username);
        }
        account.initWrongCount();
        return account;
    }
    public Account refactoredLogin(String username, String password) {
        if(username == null)
            throw new IllegalArgumentException("null");
        Account account = repository.findByUsername(username);

        if(account == null)
            return null;

        refactoredCheckPassword(username, password, account);
        account.successLogin();
        return account;
    }
    public void refactoredCheckPassword(String username, String password, Account account) {
        if(!matchPassword(password, account)) {
            account.failLogin();
            refactoredCheckLockAccount(username, account);
            throw new LoginFailedException(username);
        }
    }
    public void refactoredCheckLockAccount(String username, Account account) {
        if(account.isLocked()) {
            throw new AccountLockedException(username);
        }
    }


    //refactoring
    private boolean matchPassword(String password, Account account) {
         return account.getPassword().equals(password);
//        return account.matchPassword(password);
    }
}
