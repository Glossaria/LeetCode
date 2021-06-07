package CodeWriting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextEditorTest {


    @Test
    public void appendTest() {

        String[][] input = {
                {"0", "APPEND", "Hey"},
                {"1", "APPEND", " there"},
                {"2", "APPEND", "!"}};
        TextEditor run = new TextEditor(input);

        for (String[] s : input) {
            if (s[1].equals("APPEND")) {
                TextEditor.append(s[2]);
            }
        }
        assertEquals(TextEditor.get(), "Hey there!");
    }

    @Test
    public void backSpaceTest1() {

        String[][] input = {
                {"0", "APPEND", "Hey"},
                {"1", "APPEND", " there"},
                {"2", "APPEND", "!"},
                {"3","BACKSPACE"},
                {"4","BACKSPACE"}};
        TextEditor run = new TextEditor(input);

        for (String[] s : input) {

            switch (s[1]){
                case "APPEND": run.append(s[2]); break;
                case "BACKSPACE" : run.backSpace(); break;
            }
        }

        System.out.println("backSpaceTest1 " + run.get());
    }

    @Test
    public void backSpaceTest3() {

        String[][] input = {
                {"0", "APPEND", "Hey you"},
                {"2", "APPEND", " "},
                {"3","BACKSPACE"},
                {"4","BACKSPACE"}};

        TextEditor run = new TextEditor(input);

        for (String[] s : input) {

            switch (s[1]){
                case "APPEND": run.append(s[2]); break;
                case "BACKSPACE" : run.backSpace(); break;
            }
        }

        System.out.println("backSpaceTest3 " + run.get());
    }

    @Test
    public void backSpaceTest2() {
        String[][] input = {
                {"0", "APPEND", "Hey"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"4","BACKSPACE"}};
        TextEditor run = new TextEditor(input);

        for (String[] s : input) {

            switch (s[1]){
                case "APPEND": run.append(s[2]); break;
                case "BACKSPACE" : run.backSpace(); break;
            }
        }

        System.out.println("backSpaceTest2 " + run.get());
    }

    @Test
    public void undoTest1(){
        String[][] input = {
                {"0", "APPEND", "Hey there"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"5", "UNDO"},
                {"5", "UNDO"},
                {"5", "UNDO"},
                {"5", "UNDO"}};
        TextEditor run = new TextEditor(input);


        for (String[] s : input) {

            switch (s[1]){
                case "APPEND": run.append(s[2]); break;
                case "BACKSPACE" : run.backSpace(); break;
                case "UNDO": run.undo();break;
            }
        }

        System.out.println("undoTest1 " + run.get());
    }

    @Test
    public void undoTest2(){
        String[][] input = {
                {"0", "APPEND", "Hey there"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"5", "UNDO"},
                {"5", "UNDO"},
                {"5", "UNDO"},
                {"5", "UNDO"}};
        TextEditor run = new TextEditor(input);


        for (String[] s : input) {

            switch (s[1]){
                case "APPEND": run.append(s[2]); break;
                case "BACKSPACE" : run.backSpace(); break;
                case "UNDO": run.undo();break;
            }
        }

        System.out.println("undoTest2 " + run.get());
    }


    @Test
    public void redoTest1(){
        String[][] input = {
                {"0", "APPEND", "Hey there"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},
                {"3","BACKSPACE"},

                {"5", "UNDO"},
                {"5", "UNDO"},
                {"5", "UNDO"},
                {"5", "UNDO"},

                {"6", "REDO"},
                {"7", "REDO"},
                {"7", "REDO"},
                {"7", "REDO"},
                {"7", "REDO"}};
        TextEditor run = new TextEditor(input);


        for (String[] s : input) {

            switch (s[1]){
                case "APPEND": run.append(s[2]); break;
                case "BACKSPACE" : run.backSpace(); break;
                case "UNDO": run.undo();break;
                case "REDO" : run.redo(); break;
            }
        }

        System.out.println("redoTest1 " + run.get());
    }

    @Test
    public void chronologicalTest1(){
        String[][] input = {
                {"0", "APPEND", "Hey there"},
                {"3","BACKSPACE"},
                {"4","BACKSPACE"},
                {"5","BACKSPACE"},

                {"6", "UNDO"},
                {"7", "UNDO"},
                {"11", "UNDO"},
                {"8", "UNDO"},

                {"9", "REDO"},
                {"10", "REDO"},
                {"12", "REDO"},
                {"13", "REDO"},
                {"2", "REDO"}};
        TextEditor run = new TextEditor(input);


        for (String[] s : input) {

            switch (s[1]){
                case "APPEND": run.append(s[2]); break;
                case "BACKSPACE" : run.backSpace(); break;
                case "UNDO": run.undo();break;
                case "REDO" : run.redo(); break;
            }
        }

        System.out.println("chronologicalTest1 " + run.get());
    }



}