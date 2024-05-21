package co.com.sofka.model;

public class TextboxModel {
    private String fullname;
    private String email;
    private String current;
    private String permanet;


    public String getPermanet() { return permanet;
    }

    public void setPermanet(String permanet) {
        this.permanet = permanet;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "TextboxModel{" +
                "fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", current='" + current + '\'' +
                ", permanet='" + permanet + '\'' +
                '}';
    }
}
