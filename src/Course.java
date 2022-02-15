import java.util.ArrayList;

public class Course {
    /**basic data fields for Course class*/
    private String courseName;
    private String courseId;
    private String instructorName;
    private ArrayList<String> stuNameList;
    private String courseLoc;
    private int maxNumStu;
    private int currentStu;
    private int courseSectionNum;

    /**This constructor is for creating new courses by admin*/
    public Course(String courseName,
                  String courseId,
                  String instructorName,
                  String courseLoc,
                  int maxNumStu,
                  int courseSectionNum) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.instructorName = instructorName;
        this.stuNameList = new ArrayList<>();
        this.courseLoc = courseLoc;
        this.maxNumStu = maxNumStu;
        this.currentStu = 0;
        this.courseSectionNum = courseSectionNum;

    }

    /**This constructor is for importing .csv into Course*/
    public Course(String[] info){
        this.courseName = info[0];
        this.courseId = info[1];
        this.maxNumStu = Integer.parseInt(info[2]);
        this.currentStu = Integer.parseInt(info[3]);
        this.instructorName = info[5];
        this.courseSectionNum = Integer.parseInt(info[6]);
        this.courseLoc =  info[7];
        this.stuNameList = new ArrayList<>();
    }

    public int getCurrentStu() {
        return currentStu;
    }

    public int getMaxNumStu() {
        return maxNumStu;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseLoc() {
        return courseLoc;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public ArrayList<String> getStuNameList() {
        return stuNameList;
    }

    public int getCourseSectionNum() {
        return courseSectionNum;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseLoc(String courseLoc) {
        this.courseLoc = courseLoc;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseSectionNum(int courseSectionNum) {
        this.courseSectionNum = courseSectionNum;
    }

    public void setCurrentStu(int currentStu) {
        this.currentStu = currentStu;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setMaxNumStu(int maxNumStu) {
        this.maxNumStu = maxNumStu;
    }

    public void setStuNameList(ArrayList<String> stuNameList) {
        this.stuNameList = stuNameList;
    }

    public void addStuNameToList(String stuName) {
        this.stuNameList.add(stuName);
    }

    public void removeStuNameList(String stuName){
        this.stuNameList.remove(stuName);
    }

    @Override
    public String toString(){
        return
                "Course Name: " + courseName + "\n" +
                "Course Id: " + courseId + "\n" +
                "Maximum Number Students: " + maxNumStu + "\n" +
                "Current Students: " + currentStu + "\n" +
                "Students Name: " + stuNameList + "\n" +
                "Course Instructor: " + instructorName + "\n" +
                "Section numbers: " + courseSectionNum + "\n" +
                "Course Location " + courseLoc
        ;
    }
}
