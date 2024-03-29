package POJO;

public class GetCourse {


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public POJO.Courses getCourses() {
        return Courses;
    }

    public void setCourses(POJO.Courses courses) {
        Courses = courses;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    private String url;
    private String services;
    private String expertise;
    private Courses Courses;
    private String instruction;
    private String linkedIn;
}
