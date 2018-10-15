import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class CSVtoImage {

	private static final int MAX_LENGTH = 500;
	private static final String FILE_PATH = "internal/";
	private static final String FILE_NAME = "<FileName>"
	
	public static void main(String args[]) throws IOException {

		BufferedImage toReturn = csvToImage(FILE_PATH + FILE_NAME + ".txt");
			if(toReturn != null) {
				ImageIO.write(transformed, "PNG", new File(FILE_PATH + FILE_NAME + ".png"));
			}
		}

	}

	@SuppressWarnings("resource")
	public static BufferedImage csvToImage(String filename) throws IOException {

		Track[] tracks = null;
		int noteClock = -1;
		ArrayList<Integer> clockCounts = new ArrayList<Integer>();
		try {
			FileInputStream inputStream = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String lineInput = "";
			while (lineInput != null) {
				lineInput = br.readLine();
				lineInput = lineInput.replaceAll(",", "");
				// System.out.println(lineInput);
				Scanner s = new Scanner(lineInput);
				int trackNumber = s.nextInt();
				if (trackNumber == 0) {
					s.nextInt();
					if (s.next().toLowerCase().equals("end_of_file"))
						break;
					s.nextInt();
					tracks = new Track[s.nextInt()];
					for (int i = 0; i < tracks.length; i++) {
						tracks[i] = new Track();
					}
					noteClock = s.nextInt();
				} else {
					try {
						int startTime = s.nextInt();
						String action = s.next();
						if (action.toLowerCase().equals("note_on_c")) {
							clockCounts.add(startTime);
							s.nextInt();
							int pitch = s.nextInt();
							int velocity = s.nextInt();
							tracks[trackNumber - 1].addNote(new Note(startTime, pitch, velocity));
						} else if (action.toLowerCase().equals("note_off_c")) {
							clockCounts.add(startTime);
							s.nextInt();
							int pitch = s.nextInt();
							tracks[trackNumber - 1].addNote(new Note(startTime, pitch, 0));
						}
					} catch(NoSuchElementException e) {
						System.out.println("Corrupted");
						break;
					}
				}
			}

			BufferedImage[] img = new BufferedImage[tracks.length];
			int snoteClock = noteClock / 8;
			for (int x = 0; x < tracks.length; x++) {
				Track t = tracks[x];
				img[x] = new BufferedImage(128, MAX_LEN, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = (Graphics2D) img[x].getGraphics();
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				for (int i = 0; i < t.getNumberOfNotes(); i++) {
					Note n = t.getNote(i);
					// System.out.println(n.toString());
					int time = n.getStartTime() / snoteClock;
					int pitch = n.getPitch();
					int velocity = n.getVelocity() * 2;
					// System.out.println(time + " " + pitch + " " + velocity);
					if (time / 3 >= MAX_LEN) break;
					if (time % 3 == 0) {
						g.setColor(new Color(velocity, velocity, velocity));
						g.drawLine(pitch, time / 3, pitch, img[x].getHeight());
					} else if (time % 3 == 1) {
						Color original = new Color(img[x].getRGB(pitch, time / 3));
						g.setColor(new Color(original.getRed(), velocity, velocity));
						g.drawLine(pitch, time / 3, pitch, time / 3);
						g.setColor(new Color(velocity, velocity, velocity));
						g.drawLine(pitch, time / 3 + 1, pitch, img[x].getHeight());
					} else if (time % 3 == 2) {
						Color original = new Color(img[x].getRGB(pitch, time / 3));
						g.setColor(new Color(original.getRed(), original.getGreen(), velocity));
						g.drawLine(pitch, time / 3, pitch, time / 3);
						g.setColor(new Color(velocity, velocity, velocity));
						g.drawLine(pitch, time / 3 + 1, pitch, img[x].getHeight());
					}
				}
			}

			BufferedImage toReturn = new BufferedImage(128, MAX_LEN, BufferedImage.TYPE_INT_RGB);
			Graphics g = toReturn.getGraphics();
			for (int i = 0; i < img.length; i++) {
				g.drawImage(img[i], 0, 0, null);
			}
			return toReturn;

		} catch (FileNotFoundException e) {
			
			return null;
			
		}

	}

}
