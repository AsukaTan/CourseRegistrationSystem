import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Admin extends User implements AdminInerface{

    /**using User's constructor*/
    public Admin(String username, String password){
        super(username,password);
    }

    @Override
    public void CreateNewCourse(String courseName,
                                String courseId,
                                String instructorName,
                                String courseLoc,
                                int maxNumStu,
                                int courseSectionNum
                                ) {
        /**adding a new course by new a course object*/
        Course course = new Course(courseName,courseId,
                            instructorName, courseLoc,
                            maxNumStu, courseSectionNum);
    }


    @Override
    public void DeleteCourse(String courseName, int courseSectionNum,
                             ArrayList<Course> coursesList, ArrayList<Student> studentsList) {
        /**First: delete the course from course class*/
        for(Course i : coursesList){
            if(i.getCourseName().equals(courseName) && i.getCourseSectionNum() == courseSectionNum){
                for (String j : i.getStuNameList()){
                    for(Student k : studentsList){
                        if(k.getFullName().equals(j)){

                        }
                    }
                }
                coursesList.remove(i);
            }
        }
        /**First: delete the course from student's*/

    }

    @Override
    public void EditCourse(int userinput, String courseId, ArrayList<Course> coursesList) {
        ArrayList<String> newStuNameList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for(Course i : coursesList){
            /**loop to search for the target course Id*/
            if(i.getCourseId().equals(courseId)){
                    if(userinput == 1){
                        /**search the name in the stuNameList, then copy the array, search
                         * for target name, and replace it in a new array, finally replace
                         * the original array with new array*/
                        System.out.println("Please Enter the student name you want to edit.");
                        String targetName = scanner.next();
                        for(String stuName : i.getStuNameList()){
                            if (stuName.equals(targetName)){
                                stuName = targetName;
                            }
                            newStuNameList.add(stuName);
                        }
                        i.setStuNameList(newStuNameList);
                    }else if(userinput == 2){
                        /** collect the instructor name admin want to change,replace old name with new one*/
                        System.out.println("Please Enter the instructor name you want to chango t0.");
                        String ExpectedName = scanner.next();
                        i.setInstructorName(ExpectedName);
                    }else if(userinput == 3){
                        /**collect the expected location, and change with new one*/
                        System.out.println("Please Enter the course location you want to change to.");
                        String ExpectedLocation = scanner.next();
                        i.setCourseLoc(ExpectedLocation);
                    }else if (userinput == 4) {
                        /**collect the max number of students, and change with new one*/
                        System.out.println("Please Enter the max number of students in one course you want to change to.");
                        int ExpectedMaxNum = scanner.nextInt();
                        i.setMaxNumStu(ExpectedMaxNum);
                    } else if (userinput == 5) {
                        /**collect the current number of students, and change with new one*/
                        System.out.println("Please Enter the current number of students in one course you want to change to.");
                        int ExpectedCurrentNum = scanner.nextInt();
                        i.setCurrentStu(ExpectedCurrentNum);
                    } else if (userinput == 6) {
                        /**collect the course section number, and change with new one*/
                        System.out.println("Please Enter the course section number you want to change to. ");
                        int ExpectedCourseSectionNum = scanner.nextInt();
                        i.setCourseSectionNum(ExpectedCourseSectionNum);
                    } else if (userinput == 7) {
                        /**return to the upper menu*/
                        break;
                }
            }
        }
    }


    @Override
    public void DisplayGivenCourseinfo(String courseId, ArrayList<Course> coursesList) {
        for(Course i : coursesList) {
            if (i.getCourseId().equals(courseId)){
                System.out.println(i.toString());
            }
        }
    }

    @Override
    public void ResgiterStu(String username, String password, String firstName, String lastName, ArrayList<Student> studentsList) {
            Student student = new Student(username, password, firstName, lastName);
            studentsList.add(student);
    }

    @Override
    public void ViewAllCourses(ArrayList<Course> coursesList) {
        for (Course i : coursesList){
            System.out.println(i.getCourseName() +"\n"
                    + i.getCourseId() +"\n"
                    + i.getCurrentStu() +"\n"
                    + i.getMaxNumStu());
        }
    }

    @Override
    public void ViewFullCourse(ArrayList<Course> coursesList) {
        for (Course i : coursesList){
            if (i.getMaxNumStu() == i.getCurrentStu()){
                System.out.println(i.getCourseId() + " course is full!");
            }
        }
    }

    @Override
    public void WriteFullCourse(ArrayList<Course> coursesList) {
        /**using fileWriter and bufferWriter to write all full courses into file*/
        try {
            String path = "/Users/yuantiantan/IdeaProjects/CourseRegistrationSystem/src/FullCourseFile.txt";
            File fullCourseFile = new File(path);
            FileWriter fw = new FileWriter(fullCourseFile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Course i : coursesList){
                if (i.getMaxNumStu() == i.getCurrentStu()){
                    bw.write(i.toString() + "\n");
                }
            }
            System.out.println("file write successfully in " + path);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ViewStuNamesSpcificCourse(String courseId, ArrayList<Course> coursesList) {
        for (Course i : coursesList){
            if (i.getCourseId().equals(courseId)){
                System.out.println(i.getStuNameList());
            }
        }
    }

    @Override
    public void ViewGivenStuCourses(String studentFullName, ArrayList<Student> studentsList) {
        for(Student i : studentsList){
            if(i.getFullName().equals(studentFullName)){
                for (String j : i.getStuCourseName()){
                    System.out.println(j);
                }
            }
        }
    }

    @Override
    public void SortCourses(ArrayList<Course> coursesList) {
        /**using the selection sort to sort*/
        for(int i = 0; i < coursesList.size(); i++){
            int currentMaxindex = i;
            for(int j = i + 1; j < coursesList.size(); j++){
                if(coursesList.get(j).getCurrentStu() > coursesList.get(currentMaxindex).getCurrentStu()){
                    currentMaxindex = j;
                }
            }
            Collections.swap(coursesList, i, currentMaxindex);
        }
    }
}
