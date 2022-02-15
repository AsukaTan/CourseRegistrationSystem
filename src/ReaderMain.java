import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderMain {
    public static void main(String[] args) {
        String path = "/Users/yuantiantan/IdeaProjects/CourseRegistrationSystem/src/MyUniversityCoursesFile.csv";
        String line = "";
        try {
            /**
             * read all the data from .csv
             * */
            BufferedReader br = new BufferedReader(new FileReader(path));
            ArrayList<Course> coursesList= new ArrayList<>();
            ArrayList<Student> studentsList = new ArrayList<>();

            boolean firstLine = true;
            int i = 0;

            while ((line = br.readLine()) != null){
                if (firstLine){
                    firstLine = false;
                }else {
                    String[] info = line.split(",");
                    Course course = new Course(info);
                    coursesList.add(course);
                }
            }
            for (Course a : coursesList){
                System.out.println(a);
            }

            /**
             * Ask if you are admin or students
             * */
            Scanner scanner = new Scanner(System.in);
                System.out.println("Admin presses a / Students press s");
                String userInput = scanner.next();
                if (
                            userInput.equals("a") || userInput.equals("A")
                    ){
                        System.out.println("enter you username here");
                        String userInputOne = scanner.next();
                        System.out.println("enter you password here");
                        String userInputTwo = scanner.next();
                        if(
                                userInputOne.equals("Admin") && userInputTwo.equals("Admin001")
                        ){
                            System.out.println("1. CreateNewCourses \n" +
                                    "2. DeleteCourse \n"+
                                    "3. EditCourse \n"+
                                    "4. DisplayGivenCourseinfo \n"+
                                    "5. ResgiterStu \n"+
                                    "6. ViewAllCourses \n"+
                                    "7. WriteFullCourse \n"+
                                    "8. ViewStuNamesSpcificCourse \n"+
                                    "9. ViewGivenStuCourses \n"+
                                    "10. SortCourses \n" +
                                    "11. Exit"
                            );
                            Admin admin = new Admin(userInputOne,userInputTwo);
                            int userInputInt = scanner.nextInt();
                            switch (userInputInt){

                                case 1:
                                    System.out.println("Enter Course Name: ");
                                    String caseOneCourseName = scanner.next();
                                    System.out.println("Enter Course Id: ");
                                    String caseOneCourseId = scanner.next();
                                    System.out.println("Enter Course Instructor Name: ");
                                    String caseOneInstructorName = scanner.next();
                                    System.out.println("Enter Course Location: ");
                                    String caseOneCourseLocation = scanner.next();
                                    System.out.println("Enter Course max number of student: ");
                                    int caseOneMaximumNumStu = scanner.nextInt();
                                    System.out.println("Enter Course Section Number: ");
                                    int caseOneCourseSectionNum = scanner.nextInt();
                                    admin.CreateNewCourse(caseOneCourseName,caseOneCourseId,
                                            caseOneInstructorName,caseOneCourseLocation,
                                            caseOneMaximumNumStu,caseOneCourseSectionNum
                                            );

                                case 2:
                                    System.out.println("Enter delete Course Name: ");
                                    String caseTwoCourseName = scanner.next();
                                    System.out.println("Enter delete Course Section Number: ");
                                    int caseTwoCourseSectionNum = scanner.nextInt();
                                    admin.DeleteCourse(caseTwoCourseName,caseTwoCourseSectionNum,
                                            coursesList,studentsList);

                                case 3:
                                    System.out.println("Enter the Course Id which class you want to modified");
                                    String caseThreeModifiedCourseId = scanner.next();
                                    System.out.println("What you want to edit? \n" +
                                            "press 1 for stuName \n"+
                                            "press 2 for instructorName \n"+
                                            "press 3 for courseLoc \n"+
                                            "press 4 for maxNumStu \n"+
                                            "press 5 for currentStu \n"+
                                            "press 6 for courseSectionNum \n"+
                                            "press 7 for exit.");
                                    int caseThreeEditOptions = scanner.nextInt();
                                    admin.EditCourse(caseThreeEditOptions, caseThreeModifiedCourseId, coursesList);

                                case 4:
                                    System.out.println("Enter the Course Id which class you want to view");
                                    String caseFourDisplayInfoCourseId = scanner.next();
                                    admin.DisplayGivenCourseinfo(caseFourDisplayInfoCourseId, coursesList);

                                case 5:
                                    /** not sure*/

                                case 6:
                                    admin.ViewAllCourses(coursesList);

                                case 7:
                                    admin.ViewFullCourse(coursesList);

                                case 8:
                                    admin.WriteFullCourse(coursesList);

                                case 9:
                                    System.out.println("Enter the class Id you want to view");
                                    String caseNine = scanner.next();
                                    admin.ViewStuNamesSpcificCourse(caseNine, coursesList);

                                case 10:
                                    admin.SortCourses(coursesList);

                                case 11:
                                    break;
                                    }
                            } else {
                            System.out.println("Invalid log in! ");
                        }
                }else if(
                        userInput.equals("s") || userInput.equals("S")
                ){
                    System.out.println("Please enter your username");
                    String studentUserName = scanner.next();
                    System.out.println("Please enter your passowrd");
                    String studentPassword = scanner.next();
                    for(Student s : studentsList){
                        if (s.getUsername().equals(studentUserName) &&
                        s.getPassword().equals(studentPassword)){
                            System.out.println("1. View All Courses \n" +
                                    "2. View not Full Courses \n" +
                                    "3. Register Courses \n"+
                                    "4. Withdraw Course \n"+
                                    "5. View All Register Courses \n"+
                                    "6. Exit");
                            int studentOptions = scanner.nextInt();
                            switch (studentOptions){
                                case 1:
                                    s.ViewAllCourses();

                                case 2:
                                    s.ViewNotFullCourses(coursesList);

                                case 3:
                                    System.out.println("Enter the Course Name you want to register here");
                                    String caseThreeRigsterCoursesName = scanner.next();
                                    System.out.println("Enter the Section Number you want to register here");
                                    int caseThreeRigsterCoursesSection = scanner.nextInt();
                                    System.out.println("Enter your first name here");
                                    String caseThreeStuFirstName = scanner.next();
                                    System.out.println("Enter your last name here");
                                    String caseThreeStuLastName = scanner.next();
                                    s.RegisterCourses(caseThreeRigsterCoursesName, caseThreeRigsterCoursesSection,
                                            caseThreeStuFirstName, caseThreeStuLastName, coursesList);

                                case 4:
                                    System.out.println("Enter the Course Name you want to register here");
                                    String caseFourWithdrawCoursesName = scanner.next();
                                    System.out.println("Enter your first name here");
                                    String caseFourStuFirstName = scanner.next();
                                    System.out.println("Enter your last name here");
                                    String caseFourStuLastName = scanner.next();
                                    s.WithdrawClss(caseFourStuFirstName, caseFourStuLastName,
                                            caseFourWithdrawCoursesName, coursesList);

                                case 5:
                                    s.ViewRegisterClass();

                                case 6:
                                    break;
                            }
                        }else {
                            System.out.println("Wrong type, please try again!");
                        }
                    }

                }else {
                    System.out.println("Wrong type, Try again");
                }





        /**
         * catch exceptions
         * */
        } catch (IOException e) {
            e.printStackTrace();
            }
    }
}
