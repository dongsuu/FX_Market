
public class Account {
    BankPaper bankpaper;
    Bank bank;

    Account(){
        bank = new Bank();
    }

    public void createBankPaper(Settlement settlement){
        bankpaper = new BankPaper();
        bankpaper.writeBankPaper(settlement);

        if(bank.sendBankPaper(bankpaper)){
            settlement.updateDealList(bankpaper);
        }
    }

}
