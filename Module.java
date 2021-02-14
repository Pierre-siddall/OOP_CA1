public class Module {

	private int year;

	private byte term;

	private ModuleDescriptor module;

	private StudentRecord[] records;

	private double finalAverageGrade;

	//ADD A STATIC ARRAY OF module instances to help solve module(3)

	public void setYear(int year){
		this.year=year;
	}

	public int getYear(){
		return year;
	}

	public void setTerm(byte term){
		this.term=term;
	}

	public byte getTerm(){
		return term;
	}

	public void setModule(ModuleDescriptor module){
		this.module=module;
	}

	public ModuleDescriptor getModule(){
		return module;
	}

	public void setRecords(StudentRecord[] records){
		if (checkModuleinstance(getYear(), getTerm(), getModule(),records)){
			this.records=records;
		}
	}

	public StudentRecord[] getRecords(){
		return records;
	}

	public double getStudentaverage(StudentRecord[] records){
		int amount_of_students=0;
		double totalstudentfinalscores=0.0;
		for (StudentRecord record : records){
			double studentfinalscore=record.getFinalscore();
			totalstudentfinalscores+=studentfinalscore; // The three lines above are used to iteratively find the sum of the final scores of all students 
			amount_of_students++;
		}
		double studentaverage=totalstudentfinalscores/amount_of_students;
		return studentaverage;
	}

	public void setFinalAverageGrade(StudentRecord[] records){
		this.finalAverageGrade=getStudentaverage(records);
	}

	public double getFinalAverageGrade(){
		return finalAverageGrade;
	}

	public double[] getCAWeights(){
		return module.getWeights();
	}

	public String getDescriptorCode(){
		return module.getCode();
	}

	public String getModuleName(){
		return module.getName();
	}

	public boolean checkModuleinstance(int year,byte term,ModuleDescriptor module,StudentRecord[] records){
			int instanceYear=year;
			byte instanceTerm=term;
			String instanceModuleName=module.getName();
			for (StudentRecord record:records){
				int comparisonYear=record.getModuleYear();
				byte comparisonTerm=record.getModuleTerm();
				String comparisonModuleName=record.getModuleName();
				if(instanceYear==comparisonYear && instanceTerm==comparisonTerm && instanceModuleName==comparisonModuleName){
					return false;
				}
			}
			return true;
	}

	//Please a toString() method for Table3 

	public Module(int year,byte term,ModuleDescriptor module){
				setYear(year);
				setTerm(term);
				setModule(module);
// Please ADD ANOTHER CONSTRUCTOR TO HANDLE THE DEPENDENCY ERROR IN  UNIVERSITY.JAVA 
}
}