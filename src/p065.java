/**
 * Created by Larry Liu on 11/13/2017.
 * 65. Valid Number
 */
public class p065 {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = false;
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                numberSeen = true;
                if (eSeen) numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && (numberAfterE == eSeen);
    }
}
