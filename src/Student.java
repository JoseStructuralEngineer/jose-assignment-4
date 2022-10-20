import java.io.*;

public class Student implements Comparable<Student>  {
    private long studentId;
    private String studentName;
    private String course;
    private int grade;

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

    public void printFiles(Student[] arrayCourse, String file){
        File fout = new File(file);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("Student ID,Student Name,Course,Grade\n");
            for (int i = 1; i < arrayCourse.length; i++) {
                if(arrayCourse[i].grade!=-1){
                    bw.write(String.valueOf((long) arrayCourse[i].studentId)+","+arrayCourse[i].studentName
                            +","+arrayCourse[i].getCourse()+","+String.valueOf((long) arrayCourse[i].grade));
                }
                bw.newLine();
            }

            bw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
