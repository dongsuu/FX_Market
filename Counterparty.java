public class Counterparty {
    String name;
    int positionLimit;
    boolean condition;
    double rate;
    String phoneNumber;
    boolean isConfirm;

    Counterparty(String name, int positionLimit, String phoneNumber, boolean isConfirm, boolean condition, double rate){
        this.name = name;
        this.positionLimit = positionLimit;
        this.phoneNumber = phoneNumber;
        this.isConfirm = isConfirm;
        this.condition = condition;
        this.rate = rate;
    }

    public boolean checkCondition(Boolean condition, double rate){
        if(condition == this.condition && rate == this.rate)
            return true;
        else
            return false;
    }

    public boolean checkLimit(Dealer d){
        if(d.deal.amount > positionLimit)
            return false;
        this.isConfirm = true;
        return true;
    }

    public boolean checkConfirmDeal(){
        if(this.isConfirm)
            return true;
        else
            return false;
    }
}
