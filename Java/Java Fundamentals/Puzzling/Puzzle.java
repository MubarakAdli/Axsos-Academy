import java.util.Random;
import java.util.ArrayList;
public class  Puzzle{
    public int [] getTenRolls(){
        Random randMachine =  new Random();
        int[] array=new int[10];
        int limit = 20;
        for (int i=0 ; i<10 ; i++){
            int random = randMachine.nextInt(limit);
            array[i] = random;
        }
        return array;
    }
    public void getRandomLetter(){
        Random randMachine =  new Random();
        char [] array= new char[26];
        String letters = "abcdefghijklmnopqrstuvwxys";

        for (int i=0 ; i<26; i++){
            int randomInt = randMachine.nextInt(letters.length());
            array[i] = characters.charAt(randomInt);
        }
    }
    public void generatePassword(){
        Random randMachine =  new Random();
        String password ="";
        String letters = "abcdefghijklmnopqrstuvwxys";

        for (int i=0 ; i<8; i++){
            int randomInt = randMachine.nextInt(letters.length());
            char letter= letters.charAt(randomInt);
            password +=letter;
        }
    }
    public void getNewPasswordSet(int length){
        ArrayList<String> newPassword = new ArrayList<String>();
        Random randMachine =  new Random();
        
        String letterss = "abcdefghijklmnopqrstuvwxys";

        for (int j=0 ; j<length ; j++){
            String password ="";
        for (int i=0 ; i<8; i++){
            int randomInt = randMachine.nextInt(letters.length());
            char letter= letters.charAt(randomInt);
            password +=letter;
        }
        newPassword.add(password);
    }
    System.out.println(newPassword);
        
    }

}
