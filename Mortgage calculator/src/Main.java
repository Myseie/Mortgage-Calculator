import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float monthlyRate = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Hur stort lån vill du ta?(mellan 1k-1m): ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1_000_000){
                break;
            }
            System.out.println("Vill ha ett värde mellan 1k till 1m");

        }
        

        while(true) {
            System.out.print("Års Ränta: ");
            float annualRate = scanner.nextFloat();
            if(annualRate >= 1 && annualRate <= 30) {
                monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Bra eller för dåligt skriv in igen(mellan 1-30)");

        }
        while (true) {
            System.out.print("Period(År): ");
            byte years = scanner.nextByte();
            if(years >= 1 && years <= 30) {
                numberOfPayments = years * 12;
                break;
            }
            System.out.println("Skriv in ett år mellan 1-30");
        }

        scanner.close();

        double mathPower = Math.pow(1 + monthlyRate, numberOfPayments);

        double monthlyPayment = principal * (monthlyRate * mathPower / (mathPower -1));
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Du ska betala i månaden: " + monthlyPaymentFormatted);
    }
}