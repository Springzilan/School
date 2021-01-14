package Dao;

public class LeaveDao {
    private final String stu_id;
    private final String leavedate;
    private final String leavereason;
    public LeaveDao(String stu_id,String leavedate, String leavereason){
        this.stu_id=stu_id;
        this.leavedate=leavedate;
        this.leavereason = leavereason;
    }
}
