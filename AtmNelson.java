/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmnelson;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class AtmNelson {
    private static Scanner in; 
    private static float balance = 0; // initial balance to 0 for everyone
    private static int anotherTransaction;
    private static int confirmQuit;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        in = new Scanner(System.in);
 
        // call our transaction method here 
        transaction();
    }
 
    private static void transaction(){
        // here is where most of the work is
 
        int choice; 
 
        System.out.println("Please select an option"); 
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Balance");
        System.out.println("4. Quit");
        System.out.println("");
 
        choice = in.nextInt();
 
        switch(choice){
            case 2:
                float amount; 
                float max_daily_withdrawal=40000;
                
                System.out.println("Please enter amount to withdraw: "); 
                amount = in.nextFloat();
                if(amount > balance || amount == 0){
                    System.out.println("You have insufficient funds\n\n"); 
                    anotherTransaction(); // ask if they want another transaction
                } 
                if(amount>max_daily_withdrawal){
                    System.out.println("You have exceeded the daily withdrawable amount");
                }else {
                    // they have some cash
                    // update balance 
                    balance = balance - amount; 
                    System.out.println("You have withdrawn "+amount+" and your new balance is "+balance+"\n");
                    anotherTransaction(); 
                }
            break; 
 
            case 1:
                // option number 2 is depositing 
                float deposit; 
                float max_daily_deposit=150000;
                
                System.out.println("Please enter amount you would wish to deposit: "); 
                deposit = in.nextFloat();
                // update balance 
                if(deposit>max_daily_deposit){
                    System.out.print("You have reached the maximum daily deposit,please try again tommorow");
                }
                else{
                balance = deposit + balance;
                System.out.println("You have deposited "+deposit+" new balance is "+balance+"\n");
            }
                anotherTransaction();
            
            break; 
 
            case 3:
                // this option is to check balance 
                System.out.println("Your balance is "+balance+"\n");
                anotherTransaction(); 
            break;
            case 4:
                confirmQuit();

 
            default:
                System.out.println("Invalid option:\n\n"); 
                anotherTransaction();
            break;
        }
 
    }
 
    private static void anotherTransaction(){
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction(); // call transaction method
        } else if(anotherTransaction == 2){
            System.out.println("Thank you for banking with  us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
       private static void confirmQuit(){
        System.out.println("Do you really want to quit?\n\nPress 1 to quit \n press 2 to cancel");
        confirmQuit = in.nextInt();
        if(confirmQuit == 1){
             System.out.println("Thankyou for banking with Us.Good bye");
                System.exit(0);
        } else if(confirmQuit == 2){
           transaction();
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
    
}
