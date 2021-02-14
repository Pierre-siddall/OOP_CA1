public class University {

	public ModuleDescriptor[] moduleDescriptors=new ModuleDescriptor[6];

	public Student[] students=new Student[10];

	public Module[] modules=new Module[7];

	// Maybe remove array init here into main to work with your current methods

	//private Module[] modules;

	/**
	 * @return The number of students registered in the system.
	 */
	public int getTotalNumberStudents() {
		Student[] students=getStudentArray();
		int count=0;
		for (Student student: students){
			count++;
		}
		return count;
	}

	/**
	 * @return The student with the highest GPA.
	 */
	public Student getBestStudent() {
		Student[] students=getStudentArray();
		Student bestStudent=null;
		double bestGpa=0.0;
		for (Student student: students){
			double studentGpa=student.getGpa();
			if(studentGpa>bestGpa){
				bestStudent=student;
				bestGpa=studentGpa;
			} 
		} return bestStudent;
	}

	/**
	 * @return The module with the highest average score.
	 */
	public Module getBestModule() {
		Module[] modules=getModulesArray();
		Module bestModule=null;
		double bestFinalAverage=0.0;
		for(Module module:modules){
			double moduleFinalAverage=module.getFinalAverageGrade();
			if(moduleFinalAverage>bestFinalAverage){
				bestModule=module;
				bestFinalAverage=moduleFinalAverage;
			}
		}
		return bestModule;
	}

	public ModuleDescriptor[] initialiseModuleDescriptorsArray(){
		double [] weights_1={0.1,0.3,0.6};
		ModuleDescriptor module1= new ModuleDescriptor("ECM0002","Real World Mathematics",weights_1);

		double [] weights_2={0.25,0.25,0.25,0.25};
		ModuleDescriptor module2= new ModuleDescriptor("ECM1400","Programming",weights_2);

		double [] weights_3={0.25,0.25,0.5};
		ModuleDescriptor module3= new ModuleDescriptor("ECM1406","Data structures",weights_3);

		double [] weights_4={0.2,0.3,0.5};
		ModuleDescriptor module4= new ModuleDescriptor("ECM1410","Object-Oriented Programming",weights_4);

		double [] weights_5={0.1,0.3,0.3,0.3};
		ModuleDescriptor module5= new ModuleDescriptor("BEM2027","Information systems",weights_5);

		double [] weights_6={0.4,0.6};
		ModuleDescriptor module6= new ModuleDescriptor("PHY2023","PHY2023",weights_6);

		ModuleDescriptor[] moduleDescriptors={module1,module2,module3,module4,module5,module6};
		
		return moduleDescriptors;
	}

	public Module[] initialiseModulesArray(){
		ModuleDescriptor[] Descriptors=initialiseModuleDescriptorsArray();
		Module ECM1400term1=new Module((int)2019,(byte)1,Descriptors[1]);
		Module ECM1400term2=new Module((int)2019,(byte)2,Descriptors[1]);
		Module PHY2023=new Module((int)2019,(byte)1,Descriptors[5]);
		Module BEM2027=new Module((int)2019,(byte)2,Descriptors[4]);
		Module ECM1406=new Module((int)2020,(byte)1,Descriptors[2]);
		Module ECM1410=new Module((int)2020,(byte)1,Descriptors[3]);
		Module ECM0002=new Module((int)2020,(byte)2,Descriptors[0]);

		Module[] modules={ECM1400term1,PHY2023,BEM2027,ECM1406,ECM1410,ECM0002,ECM1400term2};

		return modules;


	}

	public Student[] initialiseStudentsArray(){
		// create student
		Module[] Modules=initialiseModulesArray(); 

		Student Ana=new Student("Ana", 'F');

		double[] AnaECM1400Marks={9.0,10.0,10.0,10.0};
		double[] AnaBEM2027Marks={10.0,10.0,9.5,10};
		double[] AnaECM1406Marks={10.0,10.0,10.0};
		double[] AnaECM1410Marks={10.0,9.0,10.0};

		StudentRecord Ana1= new StudentRecord(Ana,Modules[0],AnaECM1400Marks);
		StudentRecord Ana2= new StudentRecord(Ana,Modules[2],AnaBEM2027Marks);
		StudentRecord Ana3= new StudentRecord(Ana,Modules[3],AnaECM1406Marks);
		StudentRecord Ana4= new StudentRecord(Ana,Modules[4],AnaECM1410Marks);
		StudentRecord[] AnaRecords={Ana1,Ana2,Ana3,Ana4};
		Ana.setRecords(AnaRecords);
		Ana.setGpa(AnaRecords);


		Student Oliver=new Student("Oliver",'M');

		double[] OliverECM1400Marks={8.0,8.0,8.0,9.0};
		double[] OliverBEM2027Marks={7.0,8.5,8.2,8.0};
		double[] OliverECM1406Marks={8.0,7.5,7.5};
		double[] OliverECM1410Marks={8.5,9.0,7.5};

		StudentRecord Oliver1= new StudentRecord(Oliver, Modules[0],OliverECM1400Marks);
		StudentRecord Oliver2= new StudentRecord(Oliver, Modules[2],OliverBEM2027Marks);
		StudentRecord Oliver3= new StudentRecord(Oliver, Modules[3],OliverECM1406Marks);
		StudentRecord Oliver4= new StudentRecord(Oliver, Modules[4],OliverECM1410Marks);
		StudentRecord[] OliverRecords={Oliver1,Oliver2,Oliver3,Oliver4};
		Oliver.setRecords(OliverRecords);
		Oliver.setGpa(OliverRecords);

		Student Mary=new Student("Mary",'F');

		double[] MaryECM1400Marks={5.0,5.0,6.0,5.0};
		double[] MaryBEM2027Marks={6.5,7.0,5.5,8.5};
		double[] MaryECM1406Marks={9.0,7.0,7.0};
		double[] MaryECM1410Marks={10.0,10.0,5.0};

		StudentRecord Mary1= new StudentRecord(Mary,Modules[0],MaryECM1400Marks);
		StudentRecord Mary2= new StudentRecord(Mary,Modules[2],MaryBEM2027Marks);
		StudentRecord Mary3= new StudentRecord(Mary,Modules[3],MaryECM1406Marks);
		StudentRecord Mary4= new StudentRecord(Mary,Modules[4],MaryECM1410Marks);
		StudentRecord[] MaryRecords={Mary1,Mary2,Mary3,Mary4};
		Mary.setRecords(MaryRecords);
		Mary.setGpa(MaryRecords);

		Student John=new Student("John",'M');

		double[] JohnECM1400Marks={6.0,4.0,7.0,9.0};
		double[] JohnBEM2027Marks={5.5,5.0,6.5,7.0};
		double[] JohnECM1406Marks={9.0,8.0,7.0};
		double[] JohnECM1410Marks={7.0,7.0,7.0};

		StudentRecord John1= new StudentRecord(John,Modules[0],JohnECM1400Marks);
		StudentRecord John2= new StudentRecord(John,Modules[2],JohnBEM2027Marks);
		StudentRecord John3= new StudentRecord(John,Modules[3],JohnECM1406Marks);
		StudentRecord John4= new StudentRecord(John,Modules[4],JohnECM1410Marks);
		StudentRecord[] JohnRecords={John1,John2,John3,John4};
		John.setRecords(JohnRecords);
		John.setGpa(JohnRecords);


		Student Noah=new Student("Noah", 'M');

		double[] NoahECM1400Marks={10.0,9.0,10.0,9.0};
		double[] NoahBEM2027Marks={7.0,5.0,8.0,6.0};
		double[] NoahECM1406Marks={2.0,7.0,7.0};
		double[] NoahECM1410Marks={5.0,6.0,10.0};

		StudentRecord Noah1= new StudentRecord(Noah,Modules[0],NoahECM1400Marks);
		StudentRecord Noah2= new StudentRecord(Noah,Modules[2],NoahBEM2027Marks);
		StudentRecord Noah3= new StudentRecord(Noah,Modules[3],NoahECM1406Marks);
		StudentRecord Noah4= new StudentRecord(Noah,Modules[4],NoahECM1410Marks);
		StudentRecord[] NoahRecords={Noah1,Noah2,Noah3,Noah4};
		Noah.setRecords(NoahRecords);
		Noah.setGpa(NoahRecords);

		Student Chico=new Student("Chico",'M');

		double[] ChicoPHY2023Marks={9.0,9.0};
		double[] ChicoECM1400Marks={9.0,10.0,10.0,10.0};
		double[] ChicoECM1406Marks={10.0,10.0,10.0};
		double[] ChicoECM0002Marks={8.0,9.0,8.0};

		StudentRecord Chico1= new StudentRecord(Chico,Modules[1],ChicoPHY2023Marks);
		StudentRecord Chico2= new StudentRecord(Chico,Modules[6],ChicoECM1400Marks);
		StudentRecord Chico3= new StudentRecord(Chico,Modules[3],ChicoECM1406Marks);
		StudentRecord Chico4= new StudentRecord(Chico,Modules[5],ChicoECM0002Marks);
		StudentRecord[] ChicoRecords={Chico1,Chico2,Chico3,Chico4};
		Chico.setRecords(ChicoRecords);
		Chico.setGpa(ChicoRecords);

		Student Maria=new Student("Maria",'F');

		double[] MariaPHY2023Marks={6.0,9.0};
		double[] MariaECM1400Marks={8.0,8.0,8.0,9.0};
		double[] MariaECM1406Marks={8.0,7.5,7.5};
		double[] MariaECM0002Marks={6.5,9.0,9.5};

		StudentRecord Maria1= new StudentRecord(Maria,Modules[1],MariaPHY2023Marks);
		StudentRecord Maria2= new StudentRecord(Maria,Modules[6],MariaECM1400Marks);
		StudentRecord Maria3= new StudentRecord(Maria,Modules[3],MariaECM1406Marks);
		StudentRecord Maria4= new StudentRecord(Maria,Modules[5],MariaECM0002Marks);
		StudentRecord[] MariaRecords={Maria1,Maria2,Maria3,Maria4};
		Maria.setRecords(MariaRecords);
		Maria.setGpa(MariaRecords);

		Student Mark=new Student("Mark",'X');

		double[] MarkPHY2023Marks={5.0,6.0};
		double[] MarkECM1400Marks={5.0,5.0,6.0,5.0};
		double[] MarkECM1406Marks={10.0,10.0,10.0};
		double[] MarkECM0002Marks={8.5,10.0,8.5};

		StudentRecord Mark1= new StudentRecord(Mark,Modules[1],MarkPHY2023Marks);
		StudentRecord Mark2= new StudentRecord(Mark,Modules[6],MarkECM1400Marks);
		StudentRecord Mark3= new StudentRecord(Mark,Modules[3],MarkECM1406Marks);
		StudentRecord Mark4= new StudentRecord(Mark,Modules[5],MarkECM0002Marks);
		StudentRecord[] MarkRecords={Mark1,Mark2,Mark3,Mark4};
		Mark.setRecords(MarkRecords);
		Mark.setGpa(MarkRecords);

		Student Lia=new Student("Lia",'F');

		double[] LiaPHY2023Marks={9.0,7.0};
		double[] LiaECM1400Marks={6.0,4.0,7.0,9.0};
		double[] LiaECM1406Marks={9.0,8.0,7.0};
		double[] LiaECM0002Marks={7.5,8.0,10.0};

		StudentRecord Lia1= new StudentRecord(Lia,Modules[1],LiaPHY2023Marks);
		StudentRecord Lia2= new StudentRecord(Lia,Modules[6],LiaECM1400Marks);
		StudentRecord Lia3= new StudentRecord(Lia,Modules[3],LiaECM1406Marks);
		StudentRecord Lia4= new StudentRecord(Lia,Modules[5],LiaECM0002Marks);
		StudentRecord[] LiaRecords={Lia1,Lia2,Lia3,Lia4};
		Lia.setRecords(LiaRecords);
		Lia.setGpa(LiaRecords);

		Student Rachel=new Student("Rachel",'F');

		double[] RachelPHY2023Marks={8.0,5.0};
		double[] RachelECM1400Marks={10.0,9.0,8.0,9.0};
		double[] RachelECM1406Marks={8.0,9.0,10.0};
		double[] RachelECM0002Marks={10.0,6.0,10.0};

		StudentRecord Rachel1= new StudentRecord(Rachel,Modules[1],RachelPHY2023Marks);
		StudentRecord Rachel2= new StudentRecord(Rachel,Modules[6],RachelECM1400Marks);
		StudentRecord Rachel3= new StudentRecord(Rachel,Modules[3],RachelECM1406Marks);
		StudentRecord Rachel4= new StudentRecord(Rachel,Modules[5],RachelECM0002Marks);
		StudentRecord[] RachelRecords={Rachel1,Rachel2,Rachel3,Rachel4};
		Rachel.setRecords(RachelRecords);
		Rachel.setGpa(RachelRecords);

		Student[] students={Ana,Oliver,Mary,John,Noah,Chico,Maria,Mark,Lia,Rachel};

		return students;


	}

	public Module[] initialiseUpdatedModulesArray(){
		//Maybe replace the following two lines with this.blah if cons
		Module[] modules=initialiseModulesArray();
		Student[] StudentsWithRecords=initialiseStudentsArray();
		Student Ana=StudentsWithRecords[0];
		Student Oliver=StudentsWithRecords[1];
		Student Mary=StudentsWithRecords[2];
		Student John=StudentsWithRecords[3];
		Student Noah=StudentsWithRecords[4];
		Student Chico=StudentsWithRecords[5];
		Student Maria=StudentsWithRecords[6];
		Student Mark=StudentsWithRecords[7];
		Student Lia=StudentsWithRecords[8];
		Student Rachel=StudentsWithRecords[9];

		StudentRecord[] AnaRecords=Ana.getRecords();
		StudentRecord[] OliverRecords=Oliver.getRecords();
		StudentRecord[] MaryRecords=Mary.getRecords();
		StudentRecord[] JohnRecords=John.getRecords();
		StudentRecord[] NoahRecords=Noah.getRecords();
		StudentRecord[] ChicoRecords=Chico.getRecords();
		StudentRecord[] MariaRecords=Maria.getRecords();
		StudentRecord[] MarkRecords=Mark.getRecords();
		StudentRecord[] LiaRecords=Lia.getRecords();
		StudentRecord[] RachelRecords=Rachel.getRecords();

		StudentRecord[] ECM1400Term1Records={AnaRecords[0],OliverRecords[0],MaryRecords[0],JohnRecords[0],NoahRecords[0]};
		StudentRecord[] BEM2027Records={AnaRecords[1],OliverRecords[1],MaryRecords[1],JohnRecords[1],NoahRecords[1]};
		StudentRecord[] ECM1406Records={AnaRecords[2],OliverRecords[2],MaryRecords[2],JohnRecords[2],NoahRecords[2],ChicoRecords[2],MariaRecords[2],MarkRecords[2],LiaRecords[2],RachelRecords[2]};
		StudentRecord[] ECM1410Records={AnaRecords[3],OliverRecords[3],MaryRecords[3],JohnRecords[3],NoahRecords[3]};
		StudentRecord[] PHY2023Records={ChicoRecords[0],MariaRecords[0],MarkRecords[0],LiaRecords[0],RachelRecords[0]};
		StudentRecord[] ECM1400Term2Records={ChicoRecords[1],MariaRecords[1],MarkRecords[1],LiaRecords[1],RachelRecords[1]};
		StudentRecord[] ECM0002Records={ChicoRecords[3],MariaRecords[3],MarkRecords[3],LiaRecords[3],RachelRecords[3]};

		modules[0].setRecords(ECM1400Term1Records);
		modules[1].setRecords(ECM1400Term2Records);
		modules[2].setRecords(PHY2023Records);
		modules[3].setRecords(BEM2027Records);
		modules[4].setRecords(ECM1406Records);
		modules[5].setRecords(ECM1410Records);
		modules[6].setRecords(ECM0002Records);

		modules[0].setFinalAverageGrade(ECM1400Term1Records);
		modules[1].setFinalAverageGrade(ECM1400Term2Records);
		modules[2].setFinalAverageGrade(PHY2023Records);
		modules[3].setFinalAverageGrade(BEM2027Records);
		modules[4].setFinalAverageGrade(ECM1406Records);
		modules[5].setFinalAverageGrade(ECM1410Records);
		modules[6].setFinalAverageGrade(ECM0002Records);



		return modules;
	}

	public void setModuleDescriptorsArray(){
		this.moduleDescriptors=initialiseModuleDescriptorsArray();
	}

	public ModuleDescriptor[] getModuleDescriptorArray(){
		return moduleDescriptors;
	}

	public void setStudentArray(){
		this.students=initialiseStudentsArray();
	}

	public Student[] getStudentArray(){
		return students;
	}

	public void setModulesArray(){
		this.modules=initialiseUpdatedModulesArray();
	}

	public Module[] getModulesArray(){
		return modules;
	}


	public University(){
		setModuleDescriptorsArray();
		setModulesArray();
		setStudentArray();
		//FIGURE OUT THE DEPENDENCIES WITH THIS
	}
	public static void main(String[] args) {
		University UoK=new University();
		System.out.println("The UoK has "+UoK.getTotalNumberStudents()+" Students");
		System.out.println("\n\r");
		System.out.println("The best module is:");
		System.out.println(UoK.getBestModule().getModule().getCode());
		System.out.println("\n\r");
		System.out.println("The best student is:");
		System.out.println(UoK.getBestStudent().printTranscript());
	}
}
