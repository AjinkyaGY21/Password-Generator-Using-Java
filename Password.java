public class Password{
    String key;
    int length;
    public Password(String key) {
        this.key = key;
        length = key.length();
    }
    public int charType(char ch){
        int val;
        //uppercase chars
        if((int)ch>=65 && (int)ch<=90){
            val = 1;
        }
        //lowercase chars
        if((int)ch>=97 && (int)ch<=122){
            val = 2;
        }
        //digits
        if((int)ch>=48 && (int)ch<=57){
            val = 3;
        }
        //symbols
        else{
            val = 4;
        }
        return val;

    }
    //return strength of password
    public int calculateScore(){
        String key = this.key;
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedNum = false;
        boolean usedSym = false;
        int type;
        int score = 0;

        for(int i=0;i<key.length();i++){
            char curr = key.charAt(i);
            type = charType(curr);

            if(type==1){
                usedUpper = true;
            }
            if(type==2){
                usedLower = true;
            }
            if(type==3){
                usedNum = true;
            }
            if(type==4){
                usedSym = true;
            }


            if(usedUpper){
                score += 1;
            }
            if(usedLower){
                score += 1;
            }
            if(usedNum){
                score += 1;
            }
            if(usedSym){
                score += 1;
            }
            
        }
        int length = key.length();

        if(length>=8 && length<16){
            score += 1;
        }
        if(length>=16){
            score += 2;
        }
        return score;
    }
    public String passwordStrength(){
        int score = this.calculateScore();
        if(score>=16){
            return "Very Strong Password";
        }
        else if(score>=8 && score<16){
            return "Strong Password";
        }
        else if(score>=6 && score<8){
            return "Good Password";
        }
        else if(score>=4 && score<6){
            return "Weak Password, add more characters";
        }
        else{
            return "Try using symbols,digits,casing of letters to make strong Password";
        }

    }

    @Override
    public String toString() {
        return "Password {key: " + key + "}";
    }
    
}
