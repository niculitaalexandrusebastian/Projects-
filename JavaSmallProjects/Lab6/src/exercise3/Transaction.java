package isp.lab6.exercise3;

abstract class Transaction {
    protected Account account; //protected

    public abstract String execute();
}
