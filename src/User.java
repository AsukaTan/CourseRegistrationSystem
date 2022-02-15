import java.util.ArrayList;

public abstract class User{
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String username,
                String password){
        this.username = username;
        this.password = password;
    }
    public User(String username,
                String password,
                String firstName,
                String lastName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
            return firstName + lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void ViewAllCourse(ArrayList<Course> coursesList){

    }

    public void Exit(){
    }
}


