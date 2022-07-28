import java.time.LocalDate;

import static java.lang.Math.min;

public class Dealer {
    String name;
    int positionLimit;
    boolean condition; // condition은 편의상 true false로만 표현
    double rate;
    Deal deal;
    Counterparty counterparty;
    Settlement settlement;

    Dealer(String name, int positionLimit, boolean condition, double rate, Settlement settlement){
        this.name = name;
        this.positionLimit = positionLimit;
        this.condition = condition;
        this.settlement = settlement;
        this.rate = rate;
    }

    // counterparty와 조건, 시세율 check
    public boolean beforeRegister(Counterparty c){
        counterparty = c;
        if(c.checkCondition(this.condition, this.rate)){
            return true;
        }
        else{
            return false;
        }
    }

    // Deal 등록 시작
    public void registerNewDeal(){

        int amount = min(positionLimit, counterparty.positionLimit);
        double value = Math.random();

        Deal deal = new Deal((int)(value*amount+1),2.3,LocalDate.now(), false,false,"","");

        this.deal = deal;

        if(counterparty.checkLimit(this) && deal.amount < this.positionLimit){
            System.out.println("동의된 Condition & position Limit에 맞게 거래가 생성되었습니다.");
            settlement.getDeal(deal,this);
        }
        else{
            deal = null;
            System.out.println("동의된 Condition 또는 position limit을 초과하여 거래 실패하였습니다.");
        }
    }

    public void adjustPositionLimit(){
        this.positionLimit *= 1.5;
        System.out.println("Dealer "+this.name+"의 position Limit이 " +this.positionLimit+ "으로 재조정 되었습니다.");
    }

}
