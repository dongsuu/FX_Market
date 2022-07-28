import java.time.LocalDate;

public class Deal {
    int amount;
    double rate;
    LocalDate dealDate;
    boolean isConfirm;
    boolean bankCheck;
    String dealTo;
    String dealFrom;

    Deal(int amount, double rate, LocalDate date, boolean isConfirm, boolean bankCheck, String dealTo, String dealFrom){
        this.amount = amount;
        this.rate = rate;
        this.dealDate = date;
        this.isConfirm = isConfirm;
        this.bankCheck = bankCheck;
        this.dealTo = dealTo;
        this.dealFrom = dealFrom;
    }

    public boolean updateDealInfo(Dealer d){
        if(d.counterparty.checkConfirmDeal()){
            this.isConfirm =true;
            this.dealTo = d.name;
            this.dealFrom = d.counterparty.name;
            return true;
        }
        return false;
    }


    public String toString(){

        return "deal: "+"[amount: "+this.amount+" ,rate: "+this.rate+" ,dealDate: "
        +this.dealDate+" ,isConfirmed: "+this.isConfirm+" ,bankCheck: "+this.bankCheck+
                " ,Dealer: "+this.dealTo + " ,Counterparty: "+this.dealFrom +"]";
    }
}
