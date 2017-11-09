public class Grader{
	
	public static void main(String[] args){
		
		int choice = 0;
		double[][] gradebook = new double[100][30];
		String[] students = new String[100];
		int counter = 0;
				
		while (choice != 6){
			
			System.out.println("Menu");
			System.out.println("1. Change Student grade");
			System.out.println("2. Add Student");
			System.out.println("3. Average Student");
			System.out.println("4. Average Class");
			System.out.println("5. Print Grades");
			System.out.println("6. Exit");
			
			choice = IO.readInt();
		
			if ( choice == 1){
				System.out.println("Which Student?");
				String student = IO.readString();
				
				System.out.println("Which assignment?");
				int an = IO.readInt();
				
				System.out.println("What grade?");
				double grade = IO.readDouble();
				
				changeGrade( gradebook, students , student,  grade,  an);
				
			}else if( choice == 2){
				System.out.println("Student?");
				String student = IO.readString();
				
				counter = addStudent(students, student, counter );
			}else if(choice == 3 ){
				System.out.println("Which Student?");
				String student = IO.readString();
				
				System.out.println(studentAverage(gradebook, students, student));
			}else if( choice == 4){
				
				System.out.println(classAverage(gradebook));
				
			}else if (choice == 5){
				
				printGradebook(gradebook, students);
				
			}else if (choice != 6){
				System.out.println("Not a valid choice.");
			}
		}
	}
		
		public static int addStudent(String[] roster,String name, int index ){
			
				if (index < roster.length){
					roster[index] = name;
					return index+1;
				}else{
					System.out.println("Gradebook Full!");
					return index;
				}
		}
		
		public static int findStudent(String[] roster, String name){
			
			for(int i=0 ;roster[i] !=null && i < roster.length ; i++){
				
				if(name.equals(roster[i]))
					return i;
			}
			return -1;
		}
		
		public static void changeGrade( double[][] gb, String[] roster ,String student, double grade, int assign){
			
			if(assign >0 && assign < gb[0].length)
			 gb[findStudent(roster,student)][assign-1] = grade;
			
		}
		
		public static double studentAverage(double[][] gb, String[] roster, String student){
			
			int x = findStudent(roster, student);
			
			double sum=0;
			for(int i=0; i<gb[x].length; i++){
				sum = sum + gb[x][i];
			}
			
			return sum/gb[0].length;
		}
		
		public static double classAverage(double[][] gb){
			//you implement!
			return 0.0;
			
		}
		
		public static void printGradebook( double[][] gb, String[] roster ){
			
				for(int i=0 ;  roster[i] != null && i<roster.length ; i++ ){
					System.out.print(roster[i]+":  ");
					
					for(int j=0 ; j< gb[i].length; j++){
						
						System.out.print(gb[i][j] + " ");
						
					}
					
					System.out.println();
				}
			
		}
		
}
	
	
