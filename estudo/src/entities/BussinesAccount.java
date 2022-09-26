package entities;

public class BussinesAccount extends Account {
    
    private double loanLimit;

    public BussinesAccount() {
        super();
    }

    public BussinesAccount(Integer number, String holder, Double balance, double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if(amount <= loanLimit){
            balance += amount - 10;
        }
    }

    //reutiliza o saque da Account e adiciona na BussinesAccount mais uma taxa de 2
    @Override
    //adiciona o final no método para evitar que ele possa ser sobreposto
    public final void withdraw (double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }

}
