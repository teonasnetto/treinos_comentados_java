package entities;

//adicionando o final para poder impedir da classe de ser herdada
public final class SavingsAccount extends Account {
    
    private Double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    //sobrescrevendo o saque da Account para nao cobrar juros
    @Override
    public void withdraw (double amount) {
        balance -= amount;
    }

}
