package com;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MyConsole extends JTextArea {
    public String getConsoleMessage() {
        return consoleMessage;
    }

    public void setConsoleMessage(String consoleMessage) {
        this.consoleMessage = consoleMessage;
    }

    String consoleMessage = "Put title here...";

    public MyConsole() {
        setColumns(30);
        setRows(10);
        setText(consoleMessage);
        setLineWrap(true);
    }

    void setMyConsoleMessage() throws IOException {
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextLine()!="  ") {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println(s);
            br.close();
        }
    }
}
