package CodeWriting;

import java.util.*;

public class TestEditor2 {


    static String str;
    static Stack<Map<String, String>> operation;
    static Stack<Map<String, String>> undo;


    static String selected;
    static int selectStart;
    static int selectEnd;

    public static String textEditor(String[][] input) {
        str = "";
        chronological(input);
        selectEnd = -1;
        selectStart = -1;
        selected = "";

        operation = new Stack<>();
        undo = new Stack<>();


        for (String[] s : input) {
            switch (s[1]) {
                case "APPEND":
                    append(s[2]);
                    break;
                case "BACKSPACE":
                    backspace();
                    break;
                case "UNDO":
                    undo();
                    break;
                case "REDO":
                    redo();
                    break;
                case "SELECT":
                    select(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
                    break;
                case "BOLD":
                    bold();
                    break;

            }
        }

        return str;
    }

    private static void chronological(String[][] input) {
        Arrays.sort(input,
                Comparator.comparingLong(e -> Long.parseLong(e[0]))
        );
    }

    private static void append(String s) {
        if (undo != null && !undo.isEmpty()) {
            undo.removeAllElements();
        }

        if (selected.isEmpty()) {
            str = str + s;
        } else {
            str = str.substring(0, selectStart) + s + str.substring(selectEnd);
        }


        Map<String, String> map = new HashMap<>();
        map.put("APPEND", s);

        operation.add(map);
    }

    private static void backspace() {
        if (undo != null && !undo.isEmpty()) {
            undo.removeAllElements();
        }

        if (selected.isEmpty()) {

            if (str.length() == 0) {
                str = "";
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("BACKSPACE", str.charAt(str.length() - 1) + "");
                operation.add(map);

                int idx = str.length() - 1;
                while (str.charAt(idx) == '*') {
                    idx--;
                }

                if (idx == str.length() - 1) {
                    str = str.substring(0, str.length() - 1);
                } else {
                    str = str.substring(0, idx) + str.substring(idx + 1);
                }
            }

        } else {
            str = str.substring(0, selectStart) + str.substring(selectEnd);
            selected = "";
            selectStart = -1;
            selectEnd = -1;
        }


    }

    private static void undo() {

        if (operation.isEmpty()
                || (!operation.peek().containsKey("APPEND")
                && !operation.peek().containsKey("BACKSPACE"))) {
            return;
        }

        Map<String, String> val = new HashMap<>();

        if (operation.peek().containsKey("APPEND")) {

            String value = operation.pop().get("APPEND");
            int size = value.length();
            val.put("APPEND", value);

            str = str.substring(0, str.length() - size);

        } else if (operation.peek().containsKey("BACKSPACE")) {

            String value = operation.pop().get("BACKSPACE");
            val.put("BACKSPACE", value);

            str += value;
        }

        undo.add(val);

    }

    public static void redo() {

        if (undo.isEmpty()) {
            return;
        }

        if (undo.peek().containsKey("APPEND")) {
            String s = undo.pop().get("APPEND");
            str += s;
        } else if (undo.peek().containsKey("BACKSPACE")) {
            undo.pop();
            backspace();
        }

    }

    public static void select(int start, int end) {
        if (undo != null && !undo.isEmpty()) {
            undo.removeAllElements();
        }

        selectStart = start;
        selectEnd = Math.min(end, str.length());

        if (selectStart > str.length() || selectStart < 0) {
            selected = "";
            selectStart = -1;
            selectEnd = -1;
        } else {
            selected = str.substring(selectStart, selectEnd);
        }
    }


    public static void bold() {

        if (undo != null && !undo.isEmpty()) {
            undo.removeAllElements();
        }

        if (selected.isEmpty()) {
            return;
        } else {
            str = str.substring(0, selectStart)
                    + "*"
                    + str.substring(selectStart, selectEnd)
                    + "*"
                    + str.substring(selectEnd);
        }

        selectStart = -1;
        selectEnd = -1;
        selected = "";
    }


}

