public class Currency implements Portfolio{
    public double amount;
    public double marketVal;

    Currency(double amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cash ( $ " + String.format("%.2f", amount) + " )";
    }

    @Override
    public double marketVal() {
        marketVal = amount;
        return marketVal;
    }

    @Override
    public double profit() {
        return amount - marketVal;
    }
}
