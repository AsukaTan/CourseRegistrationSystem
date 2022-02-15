import java.util.ArrayList;

public class Student extends User implements StudentInterface{
    private ArrayList<String> stuCourseName;

    /**constructor using User*/
    public Student(String username,
                String password,
                String firstName,
                String lastName){
        super(username,password,firstName,lastName);
        stuCourseName = new ArrayList<>();
    }

    public ArrayList<String> getStuCourseName(){
        return stuCourseName;
    }

    public void setStuCourseName(ArrayList<String> stuCourseName) {
        this.stuCourseName = stuCourseName;
    }

    /**this setter method will check whether there are overlap in stuCourseName*/
    public boolean addStuCourseName(String courseName){
        for (String i : stuCourseName){
            if (i.equals(courseName)){
                return false;
            }
        }
        stuCourseName.add(courseName);
        return true;
    }

    public void ViewAllCourses(){
        for(String i : stuCourseName){
            System.out.println(i);
        }
    }

    /**loop the coursesList, if some course's maximum does not equal to current, then we print Not full*/
    @Override
    public void ViewNotFullCourses(ArrayList<Course> coursesList) {
        for(Course i : coursesList){
            if(i.getMaxNumStu() != i.getCurrentStu()){
                System.out.println("Not full course: " + i.getCourseName() +"Section Number: " + i.getCourseSectionNum());
            }
        }
    }

    @Override
    public void RegisterCourses(String courseName, int sectionNum, String stuFirstName,
                                String stuLastName, ArrayList<Course> coursesList) {
        /**first check the condition in coursesList and check the condition for overlapping*/
        for(Course i : coursesList){
            if (i.getCourseName().equals(courseName) && i.getCourseSectionNum() == sectionNum
                    && i.getMaxNumStu() != i.getCurrentStu() && addStuCourseName(courseName)){
                i.addStuNameToList(stuFirstName + stuLastName);
                System.out.println("Successfully registering");
            }
        }
    }

    @Override
    public void WithdrawClss(String stuFirstName, String stuLastName,
                             String courseName, ArrayList<Course> coursesList) {
        /**delete the student name,current student from course*/
        for(Course i : coursesList) {
            if (i.getCourseName().equals(courseName) && i.getStuNameList().contains(stuFirstName+stuLastName)) {
                i.setCurrentStu(i.getCurrentStu() - 1);
                i.removeStuNameList(stuFirstName + stuLastName);
            }
        }
        /**delete the courses from student's course list*/
        stuCourseName.remove(courseName);
        System.out.println("Withdraw Successfully");
        }

    @Override
    /**Using loop to view student's courses*/
    public void ViewRegisterClass() {
        for (String i: stuCourseName){
            System.out.println(i + "\n");
    }
    }
}
