package tool;

/**
 * Created by Phosphorus15 on 2017/1/24.
 */
public class IntTokenizer {
    char[] content;

    int index;

    protected IntTokenizer(String original){
        content = original.toCharArray();
        index = 0;
    }

    public int nextToken(){
        int result = 0;
        int current = content[index++];
        while (!(current >= '0' && current <= '9')) current = content[index++];
        while (index <= content.length && current >= '0' && current <= '9') {
            result = (result << 3) + (result << 1) + (current - '0'); // equal to result * 10
            if (index >= content.length) break;
            current = content[index++];
        }
        return result;
    }

    public static IntTokenizer of(String text){
        return new IntTokenizer(text);
    }

}
