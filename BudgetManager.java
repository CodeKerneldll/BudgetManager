// BudgetManager.java
import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    String desc;
    double amount;

    Transaction(String desc, double amount) {
        this.desc = desc;
        this.amount = amount;
    }
}

public class BudgetManager {
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static double balance = 0;

    public static void addTransaction(String desc, double amount) {
        transactions.add(new Transaction(desc, amount));
        balance += amount;
    }

    public static void printReport() {
        System.out.println("\n=== Relatório Financeiro ===");
        for (Transaction t : transactions) {
            System.out.println(t.desc + " : " + (t.amount >= 0 ? "+" : "") + t.amount);
        }
        System.out.println("Saldo atual: " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1 - Adicionar receita\n2 - Adicionar despesa\n3 - Mostrar relatório\n4 - Sair");
            int choice = sc.nextInt();
            sc.nextLine(); // limpar buffer
            if(choice == 1 || choice == 2){
                System.out.print("Descrição: ");
                String desc = sc.nextLine();
                System.out.print("Valor: ");
                double amount = sc.nextDouble();
                if(choice == 2) amount = -amount;
                addTransaction(desc, amount);
            } else if(choice == 3){
                printReport();
            } else if(choice == 4){
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}
