//import java.util.Objects;
import java.util.Scanner;

public class Generator{
    Alphabet alphabet;
    public static Scanner input;

    public Generator(Scanner sc){
        input = sc;
    }

    public Generator(boolean includeUpper, boolean includeLower, boolean includeNumber, boolean includeSymbol){
        alphabet = new Alphabet(includeUpper, includeLower, includeNumber, includeSymbol);
    }

    public void mainLoop(){
        System.out.println("Welcome to XYZ Password Services :) ");
        printMenu();

        String userOption = "-1";
        while(!userOption.equals("4")){
            userOption = input.next();
            switch(userOption){
                case "1":
                    requestPassword();
                    printMenu();
                break;
                case "2":
                    checkPassword();
                    printMenu();
                break;
                case "3":
                    printUsefulInfo();
                    printMenu();
                break;
                case "4":
                    printQuitMessage();
                break;
                default:
                System.out.println();
                System.out.println("Select any one of valid inputs available to proceed further");
                printMenu();
            }
        }
    }

    public Password generatePassword(int length){
        final StringBuilder password = new StringBuilder("");
        int alphabetLength = alphabet.getAlphabet().length();
        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;
        for(int i=0;i<length;i++){
            int index = (int) ((Math.random() * range) + min);
            password.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(password.toString());

    }

    public void printUsefulInfo(){
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters");
        System.out.println("Avoid using same password again eg. across multiple accounts");
        System.out.println("Generate passwords randomly using combinations of upper and lowercase chars, numbers and symbols");
        System.out.println("Don't use common patterns, dictionary words, repeated chars,number sequences");
        System.out.println("Avoid using relative names,pet names, biological info(DOB,etc..)");
        System.out.println("Don't use passwords which consists of wholly of any simple combination of above mentioned weak components");
    }

    public void requestPassword(){
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeNumber = false;
        boolean includeSymbol = false;

        boolean correctParams;
        System.out.println("Hello, Welcome to the password generator :)");
        System.out.println("Answer the following questions by Y/N");
        do{
            String ans;
            correctParams = false;
            do{
                System.out.println("Do you want to use lowercase letters ? ");
                ans = input.next();
                passwordRequestError(ans);

            }while(!ans.equalsIgnoreCase("Y") && !ans.equalsIgnoreCase("N"));
            if(isInclude(ans)){
                includeLower = true;
            }

            do{
                System.out.println("Do you want to use uppercase letters ? ");
                ans = input.next();
                passwordRequestError(ans);

            }while(!ans.equalsIgnoreCase("Y") && !ans.equalsIgnoreCase("N"));

            if(isInclude(ans)){
                includeUpper = true;
            }

            do{
                System.out.println("Do you want to use numbers ? ");
                ans = input.next();
                passwordRequestError(ans);

            }while(!ans.equalsIgnoreCase("Y") && !ans.equalsIgnoreCase("N"));

            if(isInclude(ans)){
                includeNumber = true;
            }

            do{
                System.out.println("Do you want to use symbols ? ");
                ans = input.next();
                passwordRequestError(ans);

            }while(!ans.equalsIgnoreCase("Y") && !ans.equalsIgnoreCase("N"));

            if(isInclude(ans)){
                includeSymbol = true;
            }

            if(!includeUpper && !includeLower && !includeNumber && !includeSymbol){
                System.out.println("You have not selected any character to generate password");
                System.out.println("Atleast one of your answers should be Y to proceed");
                correctParams = true;
            }

        }while(correctParams);

        System.out.println("Now, enter the length of the password");
        int len = input.nextInt();

        final Generator generator = new Generator(includeUpper, includeLower, includeNumber, includeSymbol);

        final Password password = generator.generatePassword(len);

        System.out.println("Your password is: "+ password);

    }

    public boolean isInclude(String input){
        if(input.equalsIgnoreCase("Y")){
            return true;
        }
        else{
            return false;
        }
    }

    public void passwordRequestError(String i){
        if(!i.equalsIgnoreCase("Y") && !i.equalsIgnoreCase("N")){
            System.out.println("Invalid Input. Try Again. /n");
            System.out.println("Enter (Y/N)");
        }
    }

    public void checkPassword(){
        
        System.out.println("Enter your password: ");
        String password = input.next();
        final Password p = new Password(password);

        System.out.println("Strength of your password generated is: "+p.passwordStrength());
        System.out.println("Score of yor password is: "+p.calculateScore());
    }

    public void printMenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Checking");
        System.out.println("Enter 3 - Useful Information/n");
        System.out.println("Enter 4 - Quit/n");
        System.out.println("Choice: ");
    }

    public void printQuitMessage(){
        System.out.println("Thank you for visiting XYZ Password Services ");
    }

}