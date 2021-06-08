package CodeWriting;

import org.junit.Test;

import static CodeWriting.TestEditor2.textEditor;
import static org.junit.Assert.*;

public class TestEditor2Test {

    @Test
    public void testMainFunc(){
        String[][] input = {
                {"0", "APPEND", "Hey"},
                {"1", "APPEND", " you "},
                {"2", "APPEND", "!"},
                {"3", "UNDO"},
                {"4", "UNDO"},
                {"5", "REDO"},
                {"6", "REDO"},
        };
        String s = textEditor(input);
        System.out.println(s);

    }

}