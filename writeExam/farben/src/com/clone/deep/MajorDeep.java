package src.com.clone.deep;

public class MajorDeep implements Cloneable {

    private String majorName;

    private long majorId;

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public MajorDeep(String majorName, long majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

/*    @Override
    public String toString() {
        return "MajorDeep{" +
                "majorName='" + majorName + '\'' +
                ", majorId=" + majorId +
                '}';
    }*/
}
