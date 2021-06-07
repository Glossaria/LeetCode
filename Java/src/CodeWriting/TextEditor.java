package CodeWriting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TextEditor {

    public static String str;
    public static Stack<Map<String, String>> operation;
    public static Stack<Map<String, String>> undo;
    public static int selectStart;
    public static int selectEnd;
    public static String selected;
    String[][] input;

    public TextEditor(String[][] input) {
        this.selectStart = -1;
        this.selectEnd = -1;
        this.selected = "";
        this.str = "";
        this.operation = new Stack<>();
        this.undo = new Stack<>();
        this.input = chronological(input);
    }

    public static String[][] chronological(String[][] input) {

        Arrays.sort(input,
                (e1, e2) -> {
                    return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
                });

        return input;
    }

    public static String get() {
        return str;
    }

    public static String append(String s) {
        undo.empty();

        if (selected.isEmpty()) {
            str += s;
        } else {
            str = str.substring(0, selectStart) + s + str.substring(selectEnd);
            selected = "";
            selectStart = -1;
            selectEnd = -1;
        }


        Map<String, String> map = new HashMap<>();
        map.put("APPEND", s);
        operation.add(map);

        return str;
    }

    public static String backSpace() {
        undo.empty();

        if (selected.isEmpty()) {
            if (str.length() < 1) {
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
        return str;
    }


    public static String undo() {

        if (operation.isEmpty()
                || (!operation.peek().containsKey("APPEND")
                && !operation.peek().containsKey("BACKSPACE"))) {
            return str;
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

        return str;
    }

    public static String redo() {
        if (undo.isEmpty()) {
            return str;
        }

        if (undo.peek().containsKey("APPEND")) {
            String s = undo.pop().get("APPEND");
            append(s);
        } else if (undo.peek().containsKey("BACKSPACE")) {
            undo.pop();
            backSpace();
        }
        return str;
    }

    public static void select(int start, int end) {
        undo.empty();

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

    public static String bold() {
        undo.empty();

        if (selected.isEmpty()) {
            return str;
        } else {
            str = str.substring(0, selectStart - 1)
                    + "*"
                    + str.substring(selectStart, selectEnd)
                    + "*"
                    + str.substring(selectEnd);
        }
        selected = "";
        selectStart = -1;
        selectEnd = -1;
        return str;

    }
}
