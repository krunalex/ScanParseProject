package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;

public class MagicDoorsScanner extends Scanner<String,String> {

    private String debugOutput;

    @Override
    public boolean scan(String input) {
        debugOutput = "\nScanner recognized following tokens:\n";
        if(input == null || input.length() == 0){
            debugOutput+="Sorry, can't scan empty String.";
            return false;
        }
        this.tokenList = new List();
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == 'a'){
                this.tokenList.append(new Token(input.charAt(i),"A-START"));
            } else if (input.charAt(i) == 'b'){
                this.tokenList.append(new Token(input.substring(i),"B-START"));
            } else if (input.charAt(i) == 'c' || input.charAt(i) == 'd'){
                this.tokenList.append(new Token(input.substring(i),"A-END"));
            } else if (input.charAt(i) == 'e' || input.charAt(i) == 'f'){
                this.tokenList.append(new Token(input.substring(i),"B-END"));
            } else return false;
        }
        this.tokenList.append(new Token("#","NODATA"));
        tokenList.toFirst(); // WICHTIG!
        return true;
    }

    public String getDebugOutput(){
        return debugOutput;
    }
}
