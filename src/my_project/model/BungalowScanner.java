package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;

public class BungalowScanner extends Scanner<String,String> {

    private String debugOutput;

    @Override
    public boolean scan(String input) {
        if(input == null || input.length() == 0){
            return false;
        }
        this.tokenList = new List();
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == 'a'){
                this.tokenList.append(new Token(input.charAt(i), "AUSSENWAND"));
            }else if(input.charAt(i) == 'w' && input.charAt(i+1) != 'f'){
                this.tokenList.append(new Token(input.charAt(i), "WAND"));
            }else if(input.charAt(i) == 'w' && input.charAt(i+1) == 'f'){
                this.tokenList.append(new Token(input.charAt(i), "FENSTERWAND"));
                i++;
            }else if(input.charAt(i) == 't'){
                this.tokenList.append(new Token(input.charAt(i), "TÜR"));
            }else return false;
        }
        this.tokenList.append(new Token("#","NODATA"));
        tokenList.toFirst(); // WICHTIG!
        return true;
    }

    public String getDebugOutput(){
        return debugOutput;
    }
}
