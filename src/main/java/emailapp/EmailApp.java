package emailapp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user info
        System.out.println("Enter your firstname");
        String first_name=sc.next();
        System.out.println("Enter your last name");
        String last_name=sc.next();
        //creating object for  Email class
        Email email = new Email(first_name,last_name);
        int choice=-1;
        do{
            System.out.println("\n*********\nEnter your choice\n1.Show Info\n2.Change Password\n3.Change mailbox capacity\n4.set Alternate mail\n5.store data into file\n6.display data in file \n7.Exit");
            choice =sc.nextInt();
            switch (choice){
                case 1:
                    email.getUserInfo();
                    break;
                case 2:
                    email.changePassword();
                    break;
                case 3:
                    email.setMailCapacity();
                    break;
                case 4:
                    email.alternateEmail();
                    break;
                case 5:
                    email.storeInfoFile();
                    break;
                case 6:
                    email.readFile();
                    break;
                case 7:
                    System.out.println("Thank you for using application");
                    break;
                default:
                    System.out.println("invalid choice!!\n Enter correct choice");

            }
        }while (choice!=7);
    }
}
