public class StudentRecord {

	private Student student;

	private Module module;

	private double[] marks; // These three may need to be used in the 

	private double finalScore;

	private Boolean isAboveAverage;


	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}

	public String getStudentName(){
		return student.getName();
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Module getModule() {
		return module;
	}

	public void checkMarks(double[] marks) {
		for (double mark : marks) {
			if (mark > 100) {
				mark = 100.0;
			} else if (mark < 0) {
				mark = 0.0;
			}
		}
	}

	public void setMarks(double[] marks) {
		checkMarks(marks);
		this.marks = marks;

	}

	public double[] getMarks() {
		return marks;
	}

	public double calculate_finalScore() {
		double sum = 0.0;
		double[] module_weighting = getModule().getCAWeights();
		double[] marks_array = getMarks();
		double[] weighted_scores = new double[module_weighting.length];
		for (int i = 0; i<module_weighting.length; i++) {
			weighted_scores[i] = module_weighting[i] * marks_array[i];
		}
		for (int i = 0; i < weighted_scores.length; i++) {
			sum += weighted_scores[i];
		}

		double finalScore = sum / marks_array.length;
		return finalScore;

	}

	public void setFinalscore() {
		this.finalScore = calculate_finalScore();
	}

	public double getFinalscore() {
		return finalScore;
	}

	public boolean calculateIsAboveAverage() {
		double studentfinalscore = getFinalscore();
		double modulefinalaverage = getModule().getFinalAverageGrade();
		if (studentfinalscore > modulefinalaverage) {
			return true;
		} else {
			return false;
		}
	}

	public void setIsaboveaverage() {
		this.isAboveAverage=calculateIsAboveAverage();
	}

	public boolean getIsaboveaverage(){
		return isAboveAverage;
	}

	public int getModuleYear(){
		return module.getYear();
	}

	public byte getModuleTerm(){
		return module.getTerm();
	}

	public String getModuleDescriptorCode(){
		return module.getDescriptorCode();
	}

	public String getModuleName(){
		return module.getModuleName();
	}

	public boolean checkRecordInstance(Student student,Module module){
		if (module.getRecords()!=null){
			StudentRecord[] studentRecordsByModule=module.getRecords();
			String instanceModuleName=module.getModuleName();
			String instanceStudentName=student.getName();
			for (StudentRecord record:studentRecordsByModule){
				String studentName=record.getStudentName();
				String moduleName=record.getModuleName();
				if(instanceModuleName==moduleName && instanceStudentName==studentName){
					return false;
				}
			}
			return true;
		}else{
			return true;
		}

}

//^^^^^ FIX THE ABOVE DEPENDENCIES IN UNIVERSITY.JAVA

	public String toTranscriptString(){
		return "|"+getModuleYear()+"|"+getModuleTerm()+"|"+getModuleDescriptorCode()+"|"+getFinalscore()+"|";
	}

	public StudentRecord (Student student,Module module, double[] marks){
		if (checkRecordInstance(student,module)){
			setModule(module);
			setMarks(marks);
			setFinalscore();
			setIsaboveaverage();
		}
	}
}