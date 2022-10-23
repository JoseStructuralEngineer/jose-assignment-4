import java.io.Serializable;

public class Student implements Comparable<Student> , Serializable{
    private long studentId;
    private String studentName;
    private String course;
    private int grade;

    //Here crate a user
    public Student() {
    }
    public Student(String[] data){

        this.studentId = Long.parseLong(data[0]);
        this.studentName = data[1];
        this.course = data[2];
        this.grade = Integer.parseInt(data[3]);

    }
    public Student(long studentId, String studentName, String course, int grade){
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;

    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student that) {

        if(that == null || this == null){

            return 0;
        }

        if(this.grade>that.grade){

            return -1;
        } else if (this.grade == that.grade){

            return 0;
        } else if (this.grade < that.grade){

            return 1;
        }
        return 0;
    }






}
