

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
public class BankAccounts {
    double balance = 0;
    String name = "";

    //Withdraw function
    public double withdraw (double balance, double withdrawAmt){ 
        if (balance<withdrawAmt) {
            System.out.print("Sorry, you cannot withdraw $"); 
            System.out.printf("%.2f", withdrawAmt);
            System.out.print(" without overdrafting.");
            System.out.println("\n");
            return balance;
        }
        balance-=withdrawAmt;
        System.out.print("You withdrew $");
        System.out.printf("%.2f", withdrawAmt);
        System.out.print(". Your new balance is: $");
        System.out.printf("%.2f", balance);
        System.out.println("\n");
        return balance;
    }

    //Deposit function
    public double deposit (double balance, double depositAmt){
        balance+=depositAmt;
        System.out.print("You deposited $");
        System.out.printf("%.2f", depositAmt);
        System.out.print(". Your new balance is: $");
        System.out.printf("%.2f", balance);
        System.out.println("\n");
       return balance;
    }
    //Checking the balance function
    public double checkBalance (double balance){
        System.out.print("Your current balance: $");
        System.out.printf("%.2f", balance);
        System.out.println("\n");
        return balance;
    }
    
 public static void main(String[] args) {
    Map<String, Double> currentAccounts = new TreeMap<String, Double>();
    BankAccounts myAccount = new BankAccounts();
    Scanner input = new Scanner(System.in);

    int actions = 0;
    while (actions !=  5){
        while (true){
            System.out.print("Hello! What's your name? ");
            myAccount.name = input.next();
            boolean nameFlag = false;
            for (int i = 0; i < myAccount.name.length(); i++){
                char c = myAccount.name.charAt(i);
                if (!Character.isLetter(c)){
                    break;
                }
                if (Character.isLetter(c) && i == myAccount.name.length() - 1){
                    nameFlag = true;
                }
            }
            if (nameFlag) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid name consisting of letters. ");
            }
        }
  
        if (currentAccounts.containsKey(myAccount.name)){
            System.out.println("Welcome back to our bank, " + myAccount.name + "!");
           //Redudancy check to ensure that null is not passed to balance
            try {
                myAccount.balance = currentAccounts.get(myAccount.name);
           } catch (NullPointerException e){
               myAccount.balance = 0.00;
           }

        } else {
            currentAccounts.put(myAccount.name, 0.00);
            myAccount.balance = 0.00;
            System.out.println("Welcome to our bank, " + myAccount.name);
            System.out.println("You are this bank's customer #" + currentAccounts.size());
            System.out.println("Since this is a new account, your current balance is $0.00");
        }
    
    actions = 0;
    while (actions != 4 && actions != 5){
        System.out.println("\n" + "What would you like to do?");
        System.out.println("Type '1' for withdraw, '2' for deposit, '3' for check balance, '4' for quit, and '5' to close the bank: ");
        String actionsStr = input.next();
        //Catches non-numerical inputs
        try {
            actions = Integer.parseInt(actionsStr);
        } catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter either 1,2,3, or 4 please.");
            continue; //re-prompts the user for input
        }

    if (actions == 1){
        System.out.print("Enter amount to withdraw: $");
        //Catches non-numerical inputs
        try {
            String withdraw = input.next();
            double withdrawAmt = Double.parseDouble(withdraw);
            myAccount.balance =  myAccount.withdraw(myAccount.balance, withdrawAmt);
        } catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid number.");
            continue;
        } 
    } else if (actions == 2){
        System.out.print("Enter amount to deposit: $");
        //Catches non-numerical inputs
        try {
            String deposit = input.next();
            double depositAmt = Double.parseDouble(deposit);
            myAccount.balance = myAccount.deposit(myAccount.balance, depositAmt);
        } catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid number.");
            continue;
        } 
    } else if (actions == 3){
        myAccount.balance =  myAccount.checkBalance(myAccount.balance);
    } else if (actions == 4){
        System.out.print("Thanks! Your balance is: $");
        System.out.printf("%.2f", myAccount.balance);
        System.out.println("\nPlease come again!");
        //Update the balance list
        currentAccounts.put(myAccount.name, myAccount.balance);
    } else if (actions == 5){
        System.out.println("The bank has now closed. Come back tomorrow!");
        break;
    } else {
       System.out.println("Invalid operation. Please try again.");
    }
}
   
}
input.close();
}

}

