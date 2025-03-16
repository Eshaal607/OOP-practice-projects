import java.util.ArrayList;

 class Professor {
    private String name;

    public Professor(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
    
}
 class Student{

    String name;
    int rollno;

    public Student(String name, int rollno){
        this.name = name;
        this.rollno = rollno;
    }

    public String toString(){
        return name + " Roll no: " + rollno;
    }
}

class University{

    String name;
    ArrayList<Department> departments = new ArrayList<>();
    ArrayList<Professor> professors = new ArrayList<>();

    public void addDepartment(Department dept){
        departments.add(dept);
    }

    public void addprofessor(Professor prof){
        professors.add(prof);
    }

    public University(String name){
        this.name = name;
    }

    public String toString(){
        return "University: " + name +"\nProfessors: " + professors + "\nDepartments: "
                  + departments;
    }
}

class Department{

    String name;
    ArrayList<Student> students = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }

    public void addStudent(String studentname,int rollno){
        students.add(new Student(studentname, rollno));
    }

    public String toString(){
        return "\nDepartment: "+ name + "\nStudents: "+ students;
    }
}

public class UniversitySystem{
   
        public static void main(String[] args) {
            University uni = new University("MUET");
    
            uni.addprofessor(new Professor("Dr. Smith"));
            uni.addprofessor(new Professor("Dr. John"));
    
            Department compSci = new Department("Computer Science");
            Department mechEng = new Department("Mechanical Engineering");
            uni.addDepartment(compSci);
            uni.addDepartment(mechEng);
    
            compSci.addStudent("Eshaal", 101);
            compSci.addStudent("Ali", 102);
            mechEng.addStudent("Ahmed", 201);
    
            System.out.println(uni);
        }
    
    
}
