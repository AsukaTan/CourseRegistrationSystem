import java.util.ArrayList;

public interface StudentInterface {
    public abstract void ViewAllCourses();

    public abstract void ViewNotFullCourses(ArrayList<Course> coursesList);

    public abstract void RegisterCourses(String courseName,
                                         int sectionNum,
                                         String stuFirstName,
                                         String stuLastName,
                                         ArrayList<Course> coursesList
                                         );

    public abstract void WithdrawClss(String stuFirstName,
                                      String stuLastName,
                                      String courseName,
                                      ArrayList<Course> coursesList
                                         );

    public abstract void ViewRegisterClass();
}
