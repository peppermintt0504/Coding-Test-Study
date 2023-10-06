import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        String text = br.readLine();
        String pattern = br.readLine();

        kmp(text,pattern);

    }

    public static int[] getPi(String str){
        int[] pi = new int[str.length()];

        int j = 0;
        for(int i = 1 ; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                j = pi[j-1];
            }
            if(str.charAt(i) == str.charAt(j)){
                pi[i] = ++j;
            }
        }
        return pi;
    }
    public static void kmp(String text, String pt){
        int[] pi = getPi(pt);
//        System.out.println(Arrays.toString(pi));
        ArrayList<Integer> answer = new ArrayList<>();

        int j = 0 ;

        for(int i = 0; i < text.length(); i++){
            while (j > 0 && text.charAt(i) != pt.charAt(j) ){
                j = pi[j-1];
            }

            if (text.charAt(i) == pt.charAt(j)) {
                if(j == pt.length()-1){
                    answer.add(i - j + 1);
                    j=pi[j];
                }else{
                    j++;
                }
            }
        }

        System.out.println(answer.size());
        for(int n : answer){
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}


