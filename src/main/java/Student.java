public class Student extends Human{
    private String univercity;
    private String faculty;
    private String special;

    public Student(String surname, String name, String patronymic, int age, Gender gender, String univercity, String faculty, String special){
        super(surname, name, patronymic, age, gender);
        this.univercity = univercity;
        this.faculty = faculty;
        this.special = special;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpecial() {
        return special;
    }

    public String getUnivercity() {
        return univercity;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }
}
