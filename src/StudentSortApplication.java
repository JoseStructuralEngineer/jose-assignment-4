import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StudentSortApplication {

    public static void main(String[] args){
        //Here We Are going to call a service class "PrintDataService" and feed it an input file
        //It will then create internal array of students
        //The service will have a method to return a sub array based on name of class as input
        //THe service allows to print an array of student given sorted by grade given d a file name

        PrintDataService printDataService = new PrintDataService();
        printDataService.readStudentData("student-master-list.csv");

        String[] courses = {"COMPSCI","STAT","APMTH"};

        for(int i = 0;i<courses.length;i++){
            Student[] arrayCourse = printDataService.printStudentsPerClass(courses[i]);
            printDataService.printFilesSorted(arrayCourse,"course" + (i+1)+ ".csv");
        }
    }
}
