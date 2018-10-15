
public class Line {

	private int[] RGBs;
	
	public Line(int[] RGBs) {
		
		this.RGBs = RGBs;
		
	}
	
	public int getSize() {
		
		return RGBs.length;
		
	}
	
	public int[] getRGBs() {
		
		return RGBs;
		
	}
	
}
