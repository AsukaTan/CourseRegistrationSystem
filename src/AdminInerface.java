import java.util.ArrayList;

public interface AdminInerface {
    public abstract void CreateNewCourse(String courseName, String courseId, String instructorName,
                                         String courseLoc, int maxNumStu, int courseSectionNum);

    public abstract void DeleteCourse(String courseName, int courseSectionNum, ArrayList<Course> coursesList,
                                      ArrayList<Student> studentsList);

    public abstract void EditCourse(int userinput, String courseId, ArrayList<Course> coursesList);

    public abstract void DisplayGivenCourseinfo(String courseId, ArrayList<Course> coursesList);

    public abstract void ResgiterStu(String username, String password, String firstName, String lastName,
                                     ArrayList<Student> studentsList
                                     );

    public abstract void ViewAllCourses(ArrayList<Course> coursesList);

    public abstract void ViewFullCourse(ArrayList<Course> coursesList);

    public abstract void WriteFullCourse(ArrayList<Course> coursesList);

    public abstract void ViewStuNamesSpcificCourse(String courseId, ArrayList<Course> coursesList);

    public abstract void ViewGivenStuCourses(String studentFullName, ArrayList<Student> studentsList);

    public abstract void SortCourses(ArrayList<Course> coursesList);
}
