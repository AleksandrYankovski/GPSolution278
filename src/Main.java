import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);

        String stringT = in.nextLine();
        String stringS = in.nextLine();


        DNK dnk = new DNK(stringT);
        boolean bool = dnk.isSubSequence(stringS);

        if (bool) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}

class DNK {

    private String sequence;


    public DNK(String sequence) {
        this.sequence = sequence;
    }

    public boolean isSubSequence(String subSequence) {

        Integer innerIterator = new Integer(0);

        for (Character characterT : sequence.toCharArray()) {

            Boolean bool = new Boolean(false);

            while (innerIterator < subSequence.length()) {

                if (subSequence.charAt(innerIterator) == characterT) {
                    bool = true;
                    innerIterator++;
                    break;
                } else {
                    innerIterator++;
                }

            }

            if (!bool) {
                return false;
            }
        }
        return true;
    }
}

class InputReader {


    private BufferedReader reader;
    private StringTokenizer tokenizer;


    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        return next();
    }
}