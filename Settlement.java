import java.util.ArrayList;

public class Settlement {

    ArrayList<Deal> dealList;
    Account account;
    Dealer d;

    Settlement(Account account){
        this.dealList = new ArrayList<Deal>();
        this.account = account;
    }

    public void getDeal(Deal deal,Dealer d){
        this.d = d;
        if(deal.updateDealInfo(d))
            setDealList(deal);
    }

    public void setDealList(Deal deal){
        dealList.add(deal);
        this.account.createBankPaper(this);
    }

    public void updateDealList(BankPaper bankpaper){
        for(int i=0; i<dealList.size(); i++){
            if(dealList.get(i).dealFrom == bankpaper.payTo){
                dealList.get(i).bankCheck = true;
                System.out.println("최종 거래가 완료되었습니다.");
            }
        }
        d.adjustPositionLimit();
    }

    public String toString(){
        for(int i=0; i<dealList.size(); i++){
            System.out.println("dealList"+(i+1)+" -> " +dealList.get(i).toString()+"], ");
        }
        return null;
    }

}
