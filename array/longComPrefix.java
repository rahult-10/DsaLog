// Longest Common Prefix
public String longComPrefix(String[] strs) {

    if(strs == null || strs.length == 0){
        return "";
    }

    String prefix = strs[0];
    for(int i = 0; i < strs.length; i++){
        int j = 0;
        while(j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)){
            j++;
        }
        prefix = prefix.substring(0,j);
    }

    return prefix;
}

// OR 
public String longCommonPrefix(String[] strs) {

    if(strs == null || strs.length == 0){
        return "";
    }

    String prefix = strs[0];
    for(int i = 1; i < strs.length; i++){
        while(strs[i].indexOf(prefix) != 0){
            prefix = prefix.substring(0, prefix.length()-1);
            if(prefix.isEmpty())
                return "";
        }
    }

    return prefix;
}

/* OR -> 
    for(int i = 1; i < strs.length; i++){
        while(!strs[i].startsWith(prefix)){
            prefix = prefix.substring(0, prefix.length()-1);
            if(prefix.isEmpty())
                return "";
        }
    } 
*/

public void main(String[] args) {
    String[] strs = {"flower","flow","flight"};
    String result = longComPrefix(strs);
    String res2 = longCommonPrefix(strs);
    System.err.println(result);
    System.err.println(res2);
}
