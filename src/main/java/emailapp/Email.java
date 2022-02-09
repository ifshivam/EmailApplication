package emailapp;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class Email {
    public Scanner sc = new Scanner(System.in);
    private String first_name;
    private String last_name;
    private String department;
    private String email;
    private String password;
    private int mail_capacity =500;
    private String alter_email;
    public Email(String first_name,String last_name){
        this.first_name=first_name;
        this.last_name=last_name;
        System.out.println("New Employee"+this.first_name+""+this.last_name);
        //calling methods
        this.department=this.setDepartment();
        this.password=this.generatePassword(8);
        this.email=this.generateEmail();

    }
    //generating mail method
    private String generateEmail(){
        return this.first_name.toLowerCase()+"."+this.last_name.toLowerCase()+"@"+this.department.toLowerCase()+".company.com";
    }
    //asking for dept
    private String setDepartment(){
        System.out.println("Department codes \n1 for sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do{
            System.out.println("Enter Department Code");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    return "sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 4:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");
            }
        }while (!flag);
          return null;
    }
    private String generatePassword(int length){
        Random random = new Random();
        String capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_chars="abcdefghijklmnopqrstuvwxyz";
        String numbers="0123456789";
        String symbols="!@#$%&*?";
        String values=capital_chars+small_chars+numbers+symbols;
        String password="";
        for(int i=0;i<length;i++){
            password =password+values.charAt(random.nextInt(values.length()));
        }
        return password;
    }
    public void changePassword(){
        boolean flag=false;
        do{
            System.out.println("Do you want to change your password!(Y/N");
            char choice =sc.next().charAt(0);
            if(choice=='Y'||choice=='y'){
                flag=true;
                System.out.println("Enter current Password:");
                String temp =sc.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new Password:");
                    String type_password=sc.next();
                    System.out.println("Enter the password again");
                    String retype_password=sc.next();
                    if(retype_password.equals(type_password)){
                        this.password=retype_password;
                        System.out.println("Password changed successfully!");
                    }
                    else{
                        System.out.println("Password didn't match");
                    }
                }else{
                    System.out.println("Incorrect password");
                }
            }else if (choice=='N'||choice=='n'){
                flag=true;
                System.out.println("your password didn't changed");
            }
            else{
                System.out.println("Enter valid choice");
            }
        }while(!flag);
    }
    public void setMailCapacity(){
        System.out.println("Current capacity= "+this.mail_capacity+"mb");
        System.out.println("Enter new mailbox capacity:");
        this.mail_capacity= sc.nextInt();
        System.out.println("mailbox capacity is successfully changed");
    }
    //set alternate mail
    public void alternateEmail(){
        System.out.println("Enter new alternate mail:");
        this.alter_email=sc.next();
        System.out.println("Alternate email is set");
    }
    //display user information method
    public void getUserInfo(){
        System.out.println("New:"+this.first_name+" "+this.last_name);
        System.out.println("Department:"+this.department);
        System.out.println("Email:"+this.email);
        System.out.println("password:"+this.password);
        System.out.println("Mailbox capacity"+this.mail_capacity+"mb");
        System.out.println("Alternate mail"+alter_email);
    }
    //store in file
    public void storeInfoFile(){
        try{
            FileWriter file = new FileWriter("emaildetails");
            file.write("\nFirst Name: "+this.first_name);
            file.write("\nLast Name: "+this.last_name);
            file.write("\nEmail: "+this.email);
            file.write("\nPassword: "+this.password);
            file.write("\nMail Capacity: : "+this.mail_capacity);
            file.write("\nAlternate email: "+this.alter_email);
            file.close();
            System.out.println("Data Stored...");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //reading file method
    public void readFile(){
        try{
            FileReader readfile = new FileReader("emaildetails");
            int i;
            while ((i=readfile.read())!=-1){
                System.out.print((char)i);
            }
            readfile.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
