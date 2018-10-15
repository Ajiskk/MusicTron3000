import java.util.ArrayList;

public class Track {

	private ArrayList<Note> notes;
	
	public Track() {
		
		notes = new ArrayList<Note>();
		
	}
	
	public void addNote(Note note) {
		
		notes.add(note);
		
	}
	
	public Note getNote(int i) {
		
		return notes.get(i);
		
	}
	
	public int getNumberOfNotes() {
		
		return notes.size();
		
	}
	
}
