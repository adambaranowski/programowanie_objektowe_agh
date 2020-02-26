public class Main {

    public static void main(String[] args){

        Palindrom my_palindrom = new Palindrom();

        System.out.println(my_palindrom.first(args[0]));
        System.out.println(my_palindrom.last(args[0]));
        System.out.println(my_palindrom.middle(args[0]));

        if(my_palindrom.IsPalindrom(args[0])){
            System.out.println("yes");

        }
        else{
            System.out.println("no");
        }

    }

}
