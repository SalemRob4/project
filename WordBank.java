import java.util.Random;

public class WordBank {

    private String[] words={
            "hello","poop","minecraft","mercury"


    };

    public WordBank(){

    }
    public String getRandomWord(){

        Random r = new Random();
        r.ints(0,words.length);
        int i = r.nextInt(words.length);
        return words[i];
    }

}
