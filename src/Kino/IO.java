package Kino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

	private static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

	private static double[] einlesenZahlen;

	public static double readDouble(double min) throws IOException {
		double input = IO.readDouble();
		if (input < min) {
			System.out.print("Mindestwert nicht erreicht ! Bitte geben sie eine Zahl ein die > als ");
		}
		return input;
	}

	public static double readDouble() throws IOException {
		while (true) {
			try  {
				String i = br.readLine();
				double number = Double.parseDouble(i.trim().replace(',','.'));
				return number;
			}
			catch (NumberFormatException e) {
				System.out.print("Keine Kommazahl! Bitte erneut versuchen: ");
			}
		}
	}

	public static int readInt() throws IOException {
		while (true) {
			try  {
				String i = br.readLine();
				int number = Integer.parseInt(i.trim().replace(',','.'));
				return number;
			}
			catch (NumberFormatException e) {
				System.out.print("Keine Ganzzahl! Bitte erneut versuchen: ");
			}
		}
	}

	public static String readString() throws IOException {
		return br.readLine();
	}

	public static boolean readBoolean() throws IOException {
		while (true) {
			String tmpEingabe = br.readLine();
			if (tmpEingabe != null && tmpEingabe.equalsIgnoreCase("ja") || tmpEingabe.equalsIgnoreCase("j") || tmpEingabe.equalsIgnoreCase("1") || tmpEingabe.equalsIgnoreCase("yes"))  {
				return true;
			}
			else if (tmpEingabe != null && tmpEingabe.equalsIgnoreCase("nein") || tmpEingabe.equalsIgnoreCase("n") || tmpEingabe.equalsIgnoreCase("0") || tmpEingabe.equalsIgnoreCase("no")) {
				return false;
			}
			else {
				System.out.print("Ungültige Eingabe! Bitte erneut versuchen: ");
			}
		}

	}
	public static double[] readDoubleArray() throws IOException {
		System.out.print("Wie lang soll der Array sein: ");
		int betrag = readInt();
		einlesenZahlen = new double[betrag];

		for (int i = 0; i < einlesenZahlen.length;i++) {
			System.out.print("Zahl " + i + ": ");
			String input10 = br.readLine();
			int input2 = Integer.parseInt(input10.trim());
			einlesenZahlen[i] = input2;
		}
		for(int i = 0; i < einlesenZahlen.length;i++) {
			System.out.println(einlesenZahlen[i]);
		}
		return einlesenZahlen;
	}
	

}
