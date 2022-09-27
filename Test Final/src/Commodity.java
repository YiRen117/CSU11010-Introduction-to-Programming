public class Commodity extends MyAssets{
    public int totalShares;

    Commodity(String symbol, double value) {
        super(symbol, value);
    }

    public void purchase(int shares, double cost){
        this.totalShares = shares;
        this.totalCost = totalShares * cost;
    }

    public void setCurrentPrice(double curPrice){
        this.curPrice = curPrice;
    }

    @Override
    public String toString() {
        return symbol + " ( " + totalShares + " shares, $ " + String.format("%.2f", totalCost) + " total cost )";
    }

    @Override
    public double marketVal() {
        marketValue = totalShares * curPrice;
        return marketValue;
    }
}
