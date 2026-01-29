import java.util.ArrayList;
// Student Class due 1/29/26
// CSC230 
public class Student {
    //Properties
    String name;
    String email;
    String major1;
    String major2;
    String minor;
    String path; // for pre-med, pre-law, certificate, etc
    int classYear;
    int gradYear;
    int id;
    ArrayList<Course> coursesCompleted; // Completed Courses - dictionary of Courses
    ArrayList<Course> coursesEnrolled; // array of currently entrolled courses
    ArrayList<Course> requirements; // Requirements - dictionary of Courses - get from major, minor
    Instructor advisor; // Advisor - type Instructor / Faculty / whatever name we're going with
    int creditsEnrolled;
    int creditsCompleted;
    double gpa;
    boolean holdActive;

    // Constructor
    public Student(){
        this.name = null;
        this.email = null;
        this.major1 = null;
        this.major2 = null;
        this.minor = null;
        this.path = null;
        this.gradYear = 0; // e.g. 2026
        this.classYear = 0; // first year 0, sophomore 1, junior 2, senior 3
        this.id = 0;
        this.creditsEnrolled = 0;
        this.creditsCompleted = 0;
        this.gpa = 0.00;
        this.holdActive = false;
        this.coursesCompleted = new ArrayList<>();
        this.coursesEnrolled = new ArrayList<>();
        this.requirements = new ArrayList<>();
    }

    // Methods
    //Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getId() { return this.id; }
    public boolean holdActive() { return holdActive; }
    public double getGpa() { return this.gpa; }
    public int getGradYear() { return this.gradYear; }
    /** Method
     * @return string list of program(s) of study, in order of first major, second major, minor
     */
    public String getProgramOfStudy() {
        if (this.major1 == null){
            return("undeclared");
        } else if (this.major2 == null){
            if (this.minor == null){
                return this.major1;
            } else {
                return this.major1 + ", " + this.minor;
            }
        } else if (this.minor == null){
            return this.major1 + ", " + this.major2;
        } else {
            return this.major1 + ", " + this.major2 + ", " + this.minor;
        }
    }

    //Setters
    public void setAdvisor(Instructor newAdvisor) { this.advisor = newAdvisor; }
    public void setActiveHold(boolean updateHold) { this.holdActive = updateHold; }
    /** 
     * Method to declare a major
     * @return true or false, whether declaration was successful
     */
    public boolean declareMajor(String major){
        if (this.major1 == null){
            this.major1 = major;
            return true;
        } else if (this.major2 == null) {
            this.major2 = major;
            return true;
        } else {
            return false;
        }
    }
    /**
     * Method to register for a course
     * @return true or false if registration was successful
     */
    public boolean register(Course course){
        if (this.holdActive == true){
            return false;
        } else {
            this.coursesEnrolled.add(course);
            this.creditsEnrolled = this.creditsEnrolled + course.getCreditHours;
            return true;
        }
    }
    /**
     * Method to drop a course
     * @return true or false, whether the drop was successful
     */
    public boolean drop(Course course){
        // check if student is enrolled and can drop
        if (this.coursesEnrolled.contains(course)){
            this.coursesEnrolled.remove(course);
            this.creditsEnrolled = this.creditsEnrolled - course.getCreditHours();
            return true;
        } else {
            return false;
        }
    }
}
