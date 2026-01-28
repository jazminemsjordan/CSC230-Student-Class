public class Student {
    String name;
    String email;
    String major;
    String minor;
    int classYear;
    int gradYear;
    int id;
    // Completed Courses
    // Requirements
    // Advisor
    int creditsEnrolled;
    int creditsCompleted;
    double gpa;
    boolean holdActive;

    public Student(){
        this.name = null;
        this.email = null;
        this.major = null;
        this.minor = null;
        this.gradYear = 0;
        this.classYear = 0;
        this.id = 0;
        this.creditsEnrolled = 0;
        this.creditsCompleted = 0;
        this.gpa = 0.00;
        this.holdActive = false;
    }

}
