package pwr.edu.tp.chinesecheckers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread {
	private Colors color;
	private Socket socket;
	private BufferedReader input;
    private PrintWriter output;
    private Player nextPlayer;

    public Player(Socket socket, Colors color) {
        this.socket = socket;
        this.color = color;
        try {
            input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("WELCOME " + color.ordinal());
            output.println("MESSAGE Waiting for opponents to connect");
        } catch (IOException e) {
            System.out.println("Player died: " + e);
        }
    }
}
