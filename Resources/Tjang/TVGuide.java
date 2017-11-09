public class TVGuide{
	
	public static void main(String[] args){
		
		int[] channels = {2,4,5,7,9,11};
		String[] networks = {"CBS","NBC","FOX","ABC","My9","CW"};
		
		
	}
	
	public static int channelLookUp(String[] nets, int[] chans, String net){
		
		
		for( int i=0; i< nets.length; i++  ){
			
			if( chan == chans[i] )
				return nets[i];
			
			
		}
		return "channel not found";
		
	}
	
	public static String networkLookUp(String[] nets, int[] chans, int chan){
		
		for( int i=0; i<chans.length; i++  ){
			
			if( chan == chans[i] )
				return nets[i];
			
			
		}
		return "channel not found";
	}
	
}