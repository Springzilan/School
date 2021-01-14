package School;

public class Leave {
    private String stu_id;
    private String leavedate;
    private String leavereason;
    public Leave(String stu_id, String leavedate, String leavereason){
        this.stu_id=stu_id;
        this.leavedate=leavedate;
        this.leavereason = leavereason;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }

    public String getLeavereason() {
        return leavereason;
    }

    public void setLeavereason(String leavereason) {
        this.leavereason = leavereason;
    }
}
