package src.com.clone.shallow;

public class MajorShallow implements Cloneable {

    private String majorName;

    private long majorId;


    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public MajorShallow(String majorName, long majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }

/*    @Override
    public String toString() {
        return "MajorShallow{" +
                "majorName='" + majorName + '\'' +
                ", majorId=" + majorId +
                '}';
    }*/
}
