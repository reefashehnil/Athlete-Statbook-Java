public class Athlete {
    private String name;
    private int age;
    private double height;
    private double weight;
    private String DOB;
    private String contactInfo;
    private String statistics;
    private String achievements;
    private double performance;

    public Athlete(String name, int age, double height, double weight, String DOB, String contactInfo, String statistics, String achievements,double performance) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.DOB = DOB;
        this.contactInfo = contactInfo;
        this.statistics = statistics;
        this.achievements = achievements;
        this.performance = performance;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }
    @Override
     public String toString() {
        return name + "," + age + "," + height + "," + weight + "," + DOB + "," + contactInfo + "," + statistics + "," + achievements + "," + performance;
    }
}
