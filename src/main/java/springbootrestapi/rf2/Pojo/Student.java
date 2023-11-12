package springbootrestapi.rf2.Pojo;

public class Student
{
    private String firstName;
    private int id;
    private String lastName;
    
    public Student(final String firstName, final int id, final String lastName) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}