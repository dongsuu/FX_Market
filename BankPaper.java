import java.time.LocalDate;

public class BankPaper {
    int payAmount;
    String payTo;
    String payFrom;
    LocalDate payDate;
    LocalDate DealDate;


    public void writeBankPaper(Settlement settlement){
        this.payAmount = settlement.dealList.get(settlement.dealList.size()-1).amount;
        this.payDate = LocalDate.now();
        this.DealDate = settlement.dealList.get(settlement.dealList.size()-1).dealDate;
        this.payTo = settlement.dealList.get(settlement.dealList.size()-1).dealFrom;
        this.payFrom = settlement.dealList.get(settlement.dealList.size()-1).dealTo;
    }

    public String toString(){
        return "BankPaper: [payAmount: "+this.payAmount+", payDate: "+this.payDate
                +", DealDate: "+this.DealDate + ", payTo: "+this.payTo+", payFrom: "+this.payFrom+"]";
    }
}
