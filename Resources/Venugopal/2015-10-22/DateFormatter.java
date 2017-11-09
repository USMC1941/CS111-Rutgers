
public class DateFormatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// names of months
		String[] months = {"Jan","Feb","Mar","Apr","May","Jun",
							"Jul","Aug","Sep","Oct","Nov","Dec"};
		
		System.out.print("Enter date in mm/dd/yyyy format: ");
		String date = IO.readString();
		
		int slashPos = date.indexOf('/');
		String month = date.substring(0, slashPos);
		int nextSlashPos = date.indexOf('/',slashPos+1);
		String day = date.substring(slashPos+1,nextSlashPos);
		String year = date.substring(nextSlashPos+1);
		
		// convert string to int
		int monthIndex = Integer.parseInt(month);
		
		System.out.println(months[monthIndex-1] + " " + day + ", " + year);
		
		
	}

}
