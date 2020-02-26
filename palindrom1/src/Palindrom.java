public class Palindrom {

    String first(String s){
        return s.substring(0,1);//(0);
    }

    String last(String s){
        int lenght = s.length();
        return s.substring(lenght-1,lenght);
    }

    String middle(String s){
        String s_mod = s.substring(1, s.length()-1);
        return s_mod;
    }

    boolean IsPalindrom(String s){

        if(s.length()>1){
            if(first(s).equals(last(s))){
                if(IsPalindrom(middle(s))){
                    return true;
                }
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
        return false;
    }


}
