import java.io.*;
import java.util.Arrays;

//This service is given a document that contains first row as titles and columns:Student ID,Student Name,Course,Grade
//The columns are known and the tdata on the columns has been clean from null errors
//There is a method that prints array Student[] data based on sorted mechanicsm defined by compareTo (based on grade)

public class PrintDataService {

    private Student[] globalStudentArray;

    public Student createUser(String[] userData) {
        return new Student(userData);
    }

    public Student[] readStudentData(String fileName) {

        Student[] array;

        try {

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            int lines = 0;
            fileReader.readLine();//Skip frist line

            while (fileReader.readLine() != null) lines++;

            fileReader.close();

            fileReader = new BufferedReader(new FileReader(fileName));
            array = new Student[lines];
            int index = 0;
            fileReader.readLine();//Skip frist line

            String line;
            while ((line = fileReader.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length > 2) {
                    Student user = createUser(data);
                    array[index] = user;
                    index++;
                }

            }

            fileReader.close();

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
        globalStudentArray = array;
        return array;

    }


    public Student[] printStudentsPerClass(String course) {

        int sizeArray = 0;
        for (Student student : globalStudentArray) {
            if (student.getCourse().contains(course)) {
                sizeArray++;
            }
        }
        Student[] array = new Student[sizeArray];

        int i = 0;
        for (Student student : globalStudentArray) {
            if (student.getCourse().contains(course)) {
                array[i] = student;
                i++;
            }
        }
        return array;
    }

    public void printFilesSorted(Student[] arrayCourse, String fileName) {

        File file = new File(fileName);
        Arrays.sort(arrayCourse);  //Sorted array

        try {

            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("Student ID,Student Name,Course,Grade\n");

            for (Student student : arrayCourse) {

                bw.write(student.getStudentId() + "," + student.getStudentName()
                        + "," + student.getCourse() + "," + (long) student.getGrade());

                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
