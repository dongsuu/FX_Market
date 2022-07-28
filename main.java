
public class main {
    public static void main(String[] args) {
        System.out.println("********** FX SYSTEM **********");
        System.out.println();

        // Account
        Account account1 = new Account();

        // Settlement
        Settlement settlement1 = new Settlement(account1);

        // Dealer
        Dealer lee = new Dealer("lee",2000, true, 2.3,settlement1);
        Dealer suu = new Dealer("suu", 1000, true, 5.3,settlement1);

        // Counterparty
        Counterparty kim = new Counterparty("kim", 1500, "010-1234-5678",false,true,2.3);
        Counterparty park = new Counterparty("park",1800,"010-1934-3842",false,true,2.3);
        Counterparty la = new Counterparty("la",3000, "010-2222-3333",false,true,5.3);

        boolean isCorrectDeal1 = lee.beforeRegister(kim); // lee와 kim간 동일 position에 거래하였는지 조건 확인.
        if(isCorrectDeal1) { // 동의된 조건하에 거래했을 때 거래가 생성된다.
            lee.registerNewDeal();
            try{
                System.out.println("거래 정보입니다. (거래 리스트는 리스트로 관리중입니다.)");
                System.out.println(lee.deal.toString());
                settlement1.toString();
                System.out.println(account1.bankpaper.toString());
            } catch(NullPointerException e){
                System.out.println("거래가 없습니다. ");
            }
        }
        else{
            System.out.println("counterparty와 조건과 시세율이 맞지 않습니다.");
        }
        System.out.println("==============================================");
        System.out.println();


        boolean isCorrectDeal2 = suu.beforeRegister(la);
        if(isCorrectDeal2) { // 동의된 조건하에 거래했을 때 거래가 생성된다.
            suu.registerNewDeal();
            try{
                System.out.println("거래 정보입니다. (거래 리스트는 리스트로 관리중입니다.)");
                System.out.println(suu.deal.toString());
                settlement1.toString();
                System.out.println(account1.bankpaper.toString());
            } catch(NullPointerException e){
                System.out.println("거래가 없습니다. ");
            }
        }
        else{
            System.out.println("counterparty와 조건과 시세율이 맞지 않습니다.");
        }
        System.out.println("=============================");
        System.out.println();


        boolean isCorrectDeal3 = lee.beforeRegister(park);
        if(isCorrectDeal3) { // 동의된 조건하에 거래했을 때 거래가 생성된다.
            lee.registerNewDeal();
            try{
                System.out.println("거래 정보입니다. (거래 리스트는 리스트로 관리중입니다.)");
                System.out.println(lee.deal.toString());
                settlement1.toString();
                System.out.println(account1.bankpaper.toString());
            } catch(NullPointerException e){
                System.out.println("거래가 없습니다. ");
            }
        }
                else{
            System.out.println("counterparty와 조건과 시세율이 맞지 않습니다.");
        }
        System.out.println("=============================");
        System.out.println();


    }
}