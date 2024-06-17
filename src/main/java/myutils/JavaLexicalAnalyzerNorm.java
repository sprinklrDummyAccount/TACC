package myutils;

import java.util.*;

public class JavaLexicalAnalyzerNorm {
    /*
     * 1 indicates keyword
     * 2 indicates identifier
     * 3 means constant
     * 4 represents operator
     * 5 indicates boundary symbol
     * 6 represents a string
     * */

    /*keyword*/
    static String []keyWord={"private","protected","public","abstract","class","extends","final","implements",
            "interface","native","new","static","strictfp","break","continue","return","do","while","if","else","for",
            "instanceof","switch","case","default","boolean","byte","char","double","float","int","long","short",
            "String","null","true","false","void","this","const","goto","super","package","throws","throw","instanceof",
            "volatile","transient","synchronized","try","catch","import"};
    //operator
    static String []operation={"+","-","*","/","%","++","--","-=","+=","^=","*=","/=","&","|","^","~","<<",">>",">>>","==","!=",
            ">","<","=",">=","<=","&&","||","|","&","^","!","."};
    //Boundary symbol
    static String []symbol={",",";",":","(",")","{","}","[","]"};
    Set<String> keyWords=null;
    Set<String> operations=null;
    Set<String> symbols=null;

    //Pointer to the position of the currently read string
    int p;

    public JavaLexicalAnalyzerNorm() {
        init();
    }

    //Initialize the array and convert it to ArrayList
    private void init(){
        keyWords=new HashSet<>();
        operations=new HashSet<>();
        symbols=new HashSet<>();
        Collections.addAll(keyWords, keyWord);
        Collections.addAll(operations, operation);
        Collections.addAll(symbols, symbol);
    }

    public List<String> analyze(String str){
        List<String> res = new ArrayList<>();
        p=0;
        char ch;
        str=str.trim(); // The input string str is trimmed to remove leading and trailing whitespace.
        for (;p<str.length();p++){
            ch=str.charAt(p);
            if (Character.isDigit(ch)){ //If the character is a digit, the digitCheck method is called to process it.
                res.add(digitCheck(str));
            }else if (Character.isLetter(ch)||ch=='_'){ //If the character is a letter or an underscore (valid start for identifiers), the letterCheck method is called.
                res.add(letterCheck(str));
            }else if (ch=='"' || ch=='\'' || ch=='`'){ //If the character is a quotation mark, the stringCheck method is called.
                res.add(stringCheck(str));
            }
            else if (ch==' '){ //If the character is a space, it is ignored.
                continue;
            }else {
                res.add(symbolCheck(str)); //If the character is not a digit, letter, or space, the symbolCheck method is called.
            }
        }
        return res;
    }

    /*Identification of numbers
     * 1. Recognize exit:
     * 1.1. Encountering a space character
     * 1.2. Encountering operators or delimiters
     * 2. Error situation:
     * 2.1, two or more decimal points
     * 2.2. Doped letters
     * */
    private String digitCheck(String str){
        String token= String.valueOf(str.charAt(p++));
        //Determine whether the number has a decimal point and whether it is greater than 1
        int flag=0; // Flag is raised if there is a decimal point in the number
        boolean err=false; // Error flag
        char ch;
        for (;p<str.length();p++) {
            ch = str.charAt(p);
            if (ch==' '||(!Character.isLetterOrDigit(ch)&&ch!='.')) { // If a space or non-letter/digit character is encountered, the number is terminated.
                break;
            }else if (err){
                token+=ch; // If an error is encountered, the character is added to the token.
            }
            else {
                token+=ch; // If no error is encountered, the character is added to the token.
                if (ch == '.') { // If a decimal point is encountered, the flag is raised.
                    if (flag == 1) { // If the flag is already raised, an error is encountered.
                        err = true;
                    } else {
                        flag++; // If the flag is not raised, the flag is raised.
                    }
                }else if (Character.isLetter(ch)){
                    err=true; // If a letter is encountered, an error is encountered.
                }
            }
        }
        if (token.charAt(token.length()-1)=='.'){ // If the last character of the token is a decimal point, an error is encountered.
            err=true;
        }
        if (p!=str.length()-1||(p==str.length()-1&&!Character.isDigit(str.charAt(p)))){ // If the pointer is not at the end of the string, or if the pointer is at the 
                                                                                        // end of the string and the character is not a digit, the pointer is decremented.
            p--;
        }
        return token;
    }

    //Identifier, keyword identification
    private String letterCheck(String str){
        String token= String.valueOf(str.charAt(p++)); // The token is initialized with the first character of the string.
        char ch; // The character to be processed.
        for (;p<str.length();p++){
            ch=str.charAt(p);
            if (!Character.isLetterOrDigit(ch)&&ch!='_'){ // If the character is not a letter, digit, or underscore, the identifier is terminated.
                break;
            }else{
                token+=ch;
            }
        }
        if (p!=str.length()-1||(p==str.length()-1&&(!Character.isLetterOrDigit(str.charAt(p))&&str.charAt(p)!='_'))){ 
        /* * 
        * If the pointer is not at the end of the string, or if the pointer 
        * is at the end of the string and the character 
        * is not a letter, digit, or underscore, the pointer is decremented.
        * */ 
            p--;
        }
        if (!keyWords.contains(token)) { // If the token is not a keyword, it is an identifier.
            return "ID";
        }
        return token;
    }

    //Identification of symbols
    private String symbolCheck(String str){
        String token= String.valueOf(str.charAt(p++));
        char ch;
        if (symbols.contains(token)){
            p--;
            return token;
        }else {
            if (operations.contains(token)){
                if (p<str.length()){
                    ch=str.charAt(p);
                    if (operations.contains(token+ch)){
                        token+=ch;
                        p++;
                        if (p<str.length()){
                            ch=str.charAt(p);
                            if (operations.contains(token+ch)){
                                token+=ch;
                                return token;
                            }else{
                                p--;
                                return token;
                            }
                        }else{
                            return token;
                        }
                    }else {
                        p--;
                        return token;
                    }
                }
            }else {
                p--;
                return token;
            }
        }
        return token;
    }

    //String check
    private String stringCheck(String str){
        String token= String.valueOf(str.charAt(p++));
        char ch;
        for (;p<str.length();p++){
            ch=str.charAt(p);
            token+=ch;
            if (ch=='"'){
                break;
            }
        }
        return token;
    }
}

