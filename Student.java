public class Student {

	private int id;

	private String name;

	private char gender;

	private double gpa;

	private StudentRecord[] records=new StudentRecord[8];

	private static int idCount=990;

	public static void setIdCount(){
		idCount++;
	}

	public static int getIdcount(){
		return idCount;
	}

	public void setId(int idCount){
		this.id=idCount;
		setIdCount();
	}
	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setGender(char gender){
		char[] genderoptions={'F','M','X'};
		for (char i:genderoptions){
			if (i==gender){
				this.gender=gender;
			}else {
				this.gender='x';
			}
		}
	}

	public char getGender(){
		return gender;
	}

	public double calculate_Gpa(StudentRecord[] records){
		double[] student_final_scores= new double[records.length];
		int count=0;
		double sum=0.0;
		for (StudentRecord record : records){
			student_final_scores[count]=record.getFinalscore();
			count++;
		}
		for(double score : student_final_scores){
			sum+=score;
		}
		double student_gpa=sum/records.length;
		return student_gpa;
	}

	public void setGpa(StudentRecord[] records){
		this.gpa=calculate_Gpa(records);
	}

	public double getGpa(){
		return gpa;
	}

	public void setRecords(StudentRecord[] records){
		this.records=records;
	}

	public StudentRecord[] getRecords(){
		return records;
	}

	public String getModulelines(){
		//Whole lotta for loops with each of the respective years and terms in the if checks after the term and year of each module in student records array above 
		String StringToBeAddedTo="";

		for (StudentRecord record:records){
			int comparison_year=record.getModuleYear();
			byte comparison_term=record.getModuleTerm();
			if(comparison_year==2019 && comparison_term==1){
				StringToBeAddedTo+=record.toTranscriptString()+"\n\r";
			}
		}
		StringToBeAddedTo+="\n\r";
		for (StudentRecord record:records){
			int comparison_year=record.getModuleYear();
			byte comparison_term=record.getModuleTerm();
			if (comparison_year==2019 && comparison_term==2){
				StringToBeAddedTo+=record.toTranscriptString()+"\n\r";
			}
		}
		StringToBeAddedTo+="\n\r";
		for(StudentRecord record:records){
			int comparison_year=record.getModuleYear();
			byte comparison_term=record.getModuleTerm();
			if (comparison_year==2020 && comparison_term==1){
				StringToBeAddedTo+=record.toTranscriptString()+"\n\r";
			}
		}
		StringToBeAddedTo+="\n\r";
		for (StudentRecord record:records){
			int comparison_year=record.getModuleYear();
			byte comparison_term=record.getModuleTerm();
			if (comparison_year==2020 && comparison_term==2){
				StringToBeAddedTo+=record.toTranscriptString()+"\n\r";
			}
		}
		return StringToBeAddedTo;
	}

	public String printTranscript() {
		String line1="                            Univesity of Knowledge-Official Transcript";
		String line2="ID: "+getId(); 
		String line3="Name: "+getName();
		String line4="GPA: "+getGpa();
		String linebreak="\n\r";
		String modulelines=getModulelines();
		String transcript =line1+linebreak+linebreak+line2+linebreak+line3+linebreak+line4+linebreak+linebreak+modulelines;

		//ADD TRANSCRIPT FOR STUDENT RECORD HERE

		return transcript;
	}

	public Student(String name,char gender){ //PLEASE FOR THIS line find a way to sort studentrecords into respective student 
		setId(getIdcount());
		setName(name);
		setGender(gender);
	}
}