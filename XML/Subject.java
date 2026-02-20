import annotations.SubjectAnnotation;

public class Subject {

    @SubjectAnnotation(SubjectAnnotation.Type.SUBJECTNAME)
    String subjectName;
    
    @SubjectAnnotation(SubjectAnnotation.Type.STAFFNAME)
    private String staffName;
    
    @SubjectAnnotation(SubjectAnnotation.Type.MARKS) 
    int mark;
    
    @SubjectAnnotation(SubjectAnnotation.Type.GRADE)
    private String grade;
    
    public Subject(String subjectName, String staffName, int mark, String grade){
        this.subjectName = subjectName;
        this.staffName = staffName;
        this.mark = mark;
        this.grade = grade;
    }

    public Subject(){}

    @SubjectAnnotation(SubjectAnnotation.Type.SUBJECTNAME)
    public String getSubjectName(){
        return subjectName;
    }
    
    @SubjectAnnotation(SubjectAnnotation.Type.STAFFNAME)
    public String getStaffName(){
        return staffName;
    }
    
    @SubjectAnnotation(SubjectAnnotation.Type.MARKS)
    public int getMarks(){
        return mark;
    }
    
    @SubjectAnnotation(SubjectAnnotation.Type.GRADE)
    public String getGrade(){
        return grade;
    }

}
