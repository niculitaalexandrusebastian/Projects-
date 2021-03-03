package isp.lab5.exercise1;

abstract class Transaction {
    protected Account account; //protected

    public abstract String execute();
}
