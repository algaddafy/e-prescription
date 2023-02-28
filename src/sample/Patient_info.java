package sample;

public class Patient_info {



    String id;
    String med_name;
    String dose;
    String advice;
    String duration;
    String strength;

    public Patient_info(String id, String med_name, String dose, String advice, String duration, String strength) {
        this.id = id;
        this.med_name = med_name;
        this.dose = dose;
        this.advice = advice;
        this.duration = duration;
        this.strength = strength;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }


}
