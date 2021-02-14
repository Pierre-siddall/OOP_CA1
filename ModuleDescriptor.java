public class ModuleDescriptor {

	private String code;

	private String name;

	private double[] continuousAssignmentWeights;

	private static Integer count=0;

	private static String[] codearray=new String[6];

	public static String[] getCodeArray(){
		return codearray;
	}

	public static Integer getCount(){
		return count;
	}
	public static void setCount(Integer count){
		count++;
	}

	public void addToCodeArray(String code,Integer count){
		int index=getCount();
		getCodeArray()[index]=code;
		setCount(count);
	}

	public String makeCodeUnique(String code){
		String newCode;
		for(String currentCode:getCodeArray()){
			if (currentCode==code){
				newCode=code+"dup"+count.toString();
				return newCode;
			}

		}return code;
	}

	public void setCode(String code,Integer count){
		this.code=makeCodeUnique(code);
		addToCodeArray(code,count);


	}public String getCode(){
		return code;

	}public void setName(String name){
		this.name=name;

	}public String getName(){
		return name;

	}public double findSum(double[] continuousAssignmentWeights){
		double sum=0;
		for (double number: continuousAssignmentWeights){
			sum+=number;
		}return sum;	
	}
	
	public double[] setDefaultWeights(){
		double[] defaultWeights={1.0};
		return defaultWeights;
	}
	
	public void setWeights(double[] continuousAssignmentWeights){
		double sum_weights=findSum(continuousAssignmentWeights);
		if (sum_weights==1.0){
			this.continuousAssignmentWeights=continuousAssignmentWeights;
		}else {
			this.continuousAssignmentWeights=setDefaultWeights();
		}

	}	public double[] getWeights(){
		return continuousAssignmentWeights;

	}
	
	public String toString(){
		return "["+name+"|"+code+"|"+continuousAssignmentWeights+"]";

	} public ModuleDescriptor(String code, String name, double[] continuousAssignmentWeights){
			setCode(code,getCount());
			setName(name);
			setWeights(continuousAssignmentWeights);
	}
}
