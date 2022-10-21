import java.io.*;
import java.util.Arrays;

public class PrintDataService {

    //This service is given a document that contains first row as column titles
    //The columns are known
    //There is a method that prints data based on column sorted mechanicsm and with filters

    private Student[] globaStudentArray;

    public Student createUser(String[] userData){

        Student student = new Student(userData);
        return student;
    }

    public Student[] readStudentData(String fileName){

        BufferedReader fileReader = null;
        Student[] array;

        try{

            fileReader = new BufferedReader(new FileReader(fileName));
            String line;
            int lines = 0;
            fileReader.readLine();
            while (fileReader.readLine() != null) lines++;
            fileReader.close();
            fileReader = new BufferedReader(new FileReader(fileName));
            array = new Student[lines];
            int index = 0;
            fileReader.readLine();
            while((line = fileReader.readLine()) != null){

                String[] data = line.split(",");
                Student user = null;
                if(data.length>2){
                    user = createUser(data);
                    array[index] = user;
                    index++;
                }

            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        globaStudentArray = array;
        return array;

    }


    public Student[] printStudentsPerClass(String course){

        int sizeArray = 0;
        for (Student student: globaStudentArray) {
            if(student.getCourse().contains(course)){
                sizeArray++;
            }
        }
        Student[] array = new Student[sizeArray];

        int i = 0;
        for (Student student: globaStudentArray) {
            if(student.getCourse().contains(course)){
                array[i] = student;
                i++;
            }
        }
        return array;
    }

    public void printFilesSorted(Student[] arrayCourse, String fileName){

        File file = new File(fileName);
        FileOutputStream fos = null;
        Arrays.sort(arrayCourse);

        try {

            fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("Student ID,Student Name,Course,Grade\n");
            for (int i = 1; i < arrayCourse.length; i++) {
                if(arrayCourse[i].getGrade()!=-1){
                    bw.write(String.valueOf((long) arrayCourse[i].getStudentId())+","+arrayCourse[i].getStudentName()
                            +","+arrayCourse[i].getCourse()+","+String.valueOf((long) arrayCourse[i].getGrade()));
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
