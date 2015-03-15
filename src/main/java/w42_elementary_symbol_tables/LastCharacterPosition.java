package w42_elementary_symbol_tables;

import java.util.Scanner;

/**
 * Created by sandro on 3/15/15.
 */
public class LastCharacterPosition {
    public static void main(String[] args) {
        SymbolTable<Character, Integer> st = new UnorderedListSymbolTable<>();
        String str = new Scanner(System.in).nextLine();
        for (int i = 0; i < str.length(); i++) {
            st.put(str.charAt(i), i);
        }
        for (char c: st) {
            System.out.printf("%c %d\n", c, st.get(c));
        }
    }
}
