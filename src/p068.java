import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larry Liu on 11/28/2017.
 * 68. Text Justification
 */
public class p068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int wordsPerLine, wordsLen;
        for (int i = 0; i < words.length; i += wordsPerLine) {
            wordsPerLine = 0;
            wordsLen = 0;
            // count how many words can fit into one line and the total length of these words.
            while (i+wordsPerLine < words.length &&
                    wordsLen + words[i+wordsPerLine].length() <= maxWidth - wordsPerLine) {
                wordsLen += words[i+wordsPerLine].length();
                wordsPerLine++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            for (int j = 0; j < wordsPerLine - 1; j++) {
                // check if it's the last line
                if (i + wordsPerLine >= words.length) sb.append(' ');
                else {
                    // put appropriate number of spaces after each word.
                    int numOfSpaces = (maxWidth-wordsLen)/(wordsPerLine-1) + (j < (maxWidth-wordsLen)%(wordsPerLine-1) ? 1: 0);
                    for (int n = 0; n < numOfSpaces; n++) sb.append(' ');
                }
                sb.append(words[i+j+1]);
            }
            int remainingSpaces = maxWidth - sb.length();
            for (int n = 0; n < remainingSpaces; n++) sb.append(' ');
            res.add(sb.toString());
        }
        return res;
    }
}
