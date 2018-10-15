
public class Note {

	private int startTime;
	private int pitch;
	private int velocity;
	
	public Note(int startTime, int pitch, int velocity) {
		
		this.startTime = startTime;
		this.pitch = pitch;
		this.velocity = velocity;
		
	}
	
	public int getStartTime() {
		
		return startTime;
		
	}

	public int getPitch() {
		
		return pitch;
		
	}
	
	public int getVelocity() {
		
		return velocity;
		
	}
	
	public String toString() {
		
		return "" + startTime + " " + pitch + " " + velocity;
		
	}

}
