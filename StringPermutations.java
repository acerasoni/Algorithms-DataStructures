/**
/ Solution to calculate all permutations of a given String.
/ It uses a 'current' buffer to save the state of our current permutation, and a boolean[] to check
/ which chars have been used. It then recursively concatenates current with each permutation of the String from
/ (x...String.length), where x is the length of current
/ It backtracks by restoring the boolean[] flag to unvisited and popping the last character from the current buffer
/ Algorithm inspired by Programming Interviews Exposed, 4th Edition
*/

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    boolean[] visited;
    String originalString;
    String current;
    List<String> permutations;

    StringPermutations(String s) {
        originalString = s;
        visited = new boolean[s.length()];
        current = new String();
        permutations = new ArrayList<>();
    }

    public void permutations() {
       if(current.length() == originalString.length()) {
           permutations.add(current); 
           return;
       }

       for(int x = 0; x < originalString.length(); x++) {
        if(visited[x]) continue;
        current += originalString.charAt(x);
        visited[x] = true;
        permutations();
        visited[x] = false;
        current = current.substring(0, current.length() - 1);
       }
    }

     public static void main(String...args) {
        StringPermutations perms = new StringPermutations("abcdsqwe");
        perms.permutations();
    
        for(String s : perms.permutations) System.out.println(s);
    }
} 
