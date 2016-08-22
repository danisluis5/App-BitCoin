/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author vuongluis
 */
public class LibraryString {
    public String subString(String outString){
        int beginIndex = 0,endIndex = 0;
        String result = "";
        if(outString.substring(0, 7).equals("http://")){
            if(outString.substring(0, 10).equals("http://www")){
                int index = 0;
                for(char c : outString.toCharArray()){
                    if(c=='.'){
                        if(beginIndex == 0){
                            beginIndex = index+1;
                        }else{
                            endIndex = index;
                        }
                    }
                    index++;
                }
                result = outString.substring(beginIndex,endIndex).toUpperCase();
            }else{
                int index = 0;
                for(char c : outString.toCharArray()){
                    if(c=='.'){
                        endIndex = index;
                    }
                    index++;
                }
                result = outString.substring(7,endIndex).toUpperCase();
            }
        }else{
            int index = 0;
            for(char c : outString.toCharArray()){
                if(c=='.'){
                    endIndex = index;
                }
                index++;
            }
           result = outString.substring(8,endIndex).toUpperCase();
        }
        return result;
    }
}
