public class MyAssets implements Portfolio{
    public String symbol;
    public double totalCost;
    public double marketValue;
    public double curPrice;

    MyAssets(String symbol, double value){
        this.symbol = symbol;
    }

    @Override
    public double marketVal() {
        return marketValue;
    }

    @Override
    public double profit() {
        return marketValue - totalCost;
    }
}
