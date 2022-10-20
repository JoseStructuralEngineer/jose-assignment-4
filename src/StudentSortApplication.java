import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StudentSortApplication {

    public static void main(String[] args){
        //Here Read the Text File
        BufferedReader fileReader = null;
        Student[] arrayCourse1 = new Student[100];
        Student[] arrayCourse2 = new Student[100];
        Student[] arrayCourse3 = new Student[100];
        Student testStudent =  new Student(00,"Dummy Student","Test",-1);
        for(int i =0;i<100;i++){
            arrayCourse1[i] = testStudent;
            arrayCourse2[i] = testStudent;
            arrayCourse3[i] = testStudent;
        }
        try{
            fileReader = new BufferedReader(new FileReader("student-master-list.csv"));
            String line;
            int index1 = 0;
            int index2 = 0;
            int index3 = 0;
            fileReader.readLine();
            while((line = fileReader.readLine()) != null){
                System.out.println(line);
                String[] data = line.split(",");
                Student student = null;
                long stdID = Long.parseLong(data[0]);
                String name = data[1];
                String course = data[2];
                int grade = Integer.parseInt(data[3]);
                student = new Student(stdID, data[1], data[2],grade);
                if(course.contains("COMPSCI")){
                    arrayCourse1[index1] = student;
                    index1++;
                } else if(course.contains("STAT")){
                    arrayCourse2[index2] = student;
                    index2++;
                } else {
                    arrayCourse3[index3] = student;
                    index3++;
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Arrays.sort(arrayCourse1);
        testStudent.printFiles(arrayCourse1, "course1.csv");
        testStudent.printFiles(arrayCourse2, "course2.csv");
        testStudent.printFiles(arrayCourse3, "course3.csv");
    }


}
