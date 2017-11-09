public class Song{

	//Data
	private String title;
	private String genre;
	private String artist;
	private int length;
	
	//Ops
	public Song(String title, String artist,int length){
		this.title = title;
		this.artist = artist;
		this.length = length ;
	}
	
	public void setLength(int length){
		if (length > 0 )
			this.length = length;
	}
	
	public int getLength(){
		return length;
	}
	
	public boolean equals(Song x){
		
		if(title.equals(x.title)  && artist.equals(x.artist) && length == x.length)
			return true;
		else
			return false;
		
	}
	
	
	public String toString(){
		return title + " - " + artist;
	}
}