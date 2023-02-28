package sample;

public class Prescription {

    String Name;
    String Strength;
    String Dose;
    String Duration;
    String Advice;

    Prescription(String Name, String Strength, String Dose, String Duration, String Advice)
    {
        this.Name=Name;
        this.Strength=Strength;
        this.Dose=Dose;
        this.Duration=Duration;
        this.Advice=Advice;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStrength(String strength) {
        Strength = strength;
    }

    public void setDose(String dose) {
        Dose = dose;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public void setAdvice(String advice) {
        Advice = advice;
    }

    public String getName() {
        return Name;
    }

    public String getStrength() {
        return Strength;
    }

    public String getDose() {
        return Dose;
    }

    public String getDuration() {
        return Duration;
    }

    public String getAdvice() {
        return Advice;
    }



}
