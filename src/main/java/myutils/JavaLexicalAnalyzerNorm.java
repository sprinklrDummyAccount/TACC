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
    //界符
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
        str=str.trim();
        for (;p<str.length();p++){
            ch=str.charAt(p);
            if (Character.isDigit(ch)){
                res.add(digitCheck(str));
            }else if (Character.isLetter(ch)||ch=='_'){
                res.add(letterCheck(str));
            }else if (ch=='"'){
                res.add(stringCheck(str));
            }
            else if (ch==' '){
                continue;
            }else {
                res.add(symbolCheck(str));
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
        int flag=0;
        boolean err=false;
        char ch;
        for (;p<str.length();p++) {
            ch = str.charAt(p);
            if (ch==' '||(!Character.isLetterOrDigit(ch)&&ch!='.')) {
                break;
            }else if (err){
                token+=ch;
            }
            else {
                token+=ch;
                if (ch == '.') {
                    if (flag == 1) {
                        err = true;
                    } else {
                        flag++;
                    }
                }else if (Character.isLetter(ch)){
                    err=true;
                }
            }
        }
        if (token.charAt(token.length()-1)=='.'){
            err=true;
        }
        if (p!=str.length()-1||(p==str.length()-1&&!Character.isDigit(str.charAt(p)))){
            p--;
        }
        return token;
    }

    //Identifier, keyword identification
    private String letterCheck(String str){
        String token= String.valueOf(str.charAt(p++));
        char ch;
        for (;p<str.length();p++){
            ch=str.charAt(p);
            if (!Character.isLetterOrDigit(ch)&&ch!='_'){
                break;
            }else{
                token+=ch;
            }
        }
        if (p!=str.length()-1||(p==str.length()-1&&(!Character.isLetterOrDigit(str.charAt(p))&&str.charAt(p)!='_'))){
            p--;
        }
        if (!keyWords.contains(token)) {
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

