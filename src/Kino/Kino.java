package Kino;
import java.io.IOException;
public class Kino {

	private static String[][] cinema = null;
	private static int row = 0;
	private static int seat = 0;
	public static void main(String[] args) throws IOException {

		System.out.print("Wie viele Sitze pro Reihe hat der Kinosaal?: ");
		int input = IO.readInt();

		System.out.print("Wie viele Reihen hat der Kinosaal?: ");
		int input2 = IO.readInt();
		System.out.print("\n");

		row = input;
		seat = input2;


		cinema = new String[seat][row];

		printSeats(seat, row);

	}

	public static void printSeats(int input, int input2) throws IOException {
		for(int i = 0; i < input; i++) {
			System.out.print(i+1 + ". ");
			for(int j = 0; j < input2; j++) {
				cinema[i][j] = "O";
				System.out.print(cinema[i][j] + " ");
			}
			System.out.println("");
		}
		abfrageMachen();

	}

	public static void abfrageMachen() throws IOException { 
		while (true) {
			System.out.print("\n======Menü======");
			System.out.print("\nWas möchten sie tun?\n"+
		   			"[1]Sitz reservieren\n"+
					"[2]Sitz stornieren\n"+
					"[3]Saal anzeigen lassen\n"+
					"[4]Programm beenden: ");
			int i = IO.readInt();

			if (i == 1) {
				sitzReservieren();
				saalAnzeigen(seat, row);
				abfrageMachen();
			} 
			else if (i == 2) {
				sitzStornieren();
				saalAnzeigen(seat, row);
				abfrageMachen();
			} 
			else if (i == 3) {
				saalAnzeigen(seat, row);
				abfrageMachen();
			} 
			else if (i == 4) {
				System.exit(0);
			} 
			else {
				System.out.println("Falsche Eingabe nur Zahlen von 1 - 4! ");
			}
		}


	}

	public static void sitzReservieren() throws IOException {
		System.out.print("\nIn welcher Reihe möchten sie den Sitz reservieren?: ");
		int i = IO.readInt();

		System.out.print("Welchen Sitz möchten sie reservieren z.B. .. 3, 4: ");
		int i2 = IO.readInt();
		System.out.print("\n");

		if(cinema[i-1][i2-1].equals("X")) {
			System.out.println("\nDer Sitz ist bereits reserviert!");
		}
		else {
			cinema[i-1][i2-1] = "X";
		}

	}

	public static void saalAnzeigen(int input, int input2) {
		for(int i = 0; i < input; i++) {
			System.out.print(i+1 + ". ");
			for(int j = 0; j < input2; j++) {
				System.out.print(cinema[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void sitzStornieren() throws IOException {
		System.out.print("\nIn welcher Reihe möchten sie den Sitz stornieren?: ");
		int i = IO.readInt();

		System.out.print("Welchen Sitz möchten sie stornieren z.B. .. 3, 4: \n");
		int i2 = IO.readInt();
		System.out.print("\n");

		if(cinema[i-1][i2-1].equals("O")) {
			System.out.println("Der Sitz ist noch gar nicht belegt!");
		}
		else {
			cinema[i-1][i2-1] = "O";
		}

	}
}