package CSMS.Bean;

import java.time.LocalDateTime;

/**
 * 租赁信息（LeaseMsg）
 * 	编号（leaseid）
 * 	起始日期（startDate）
 * 	结束日期(endDate)
 * 	汽车编号（carid）
 * 	用户编号（userid）
 * 	费用（price*时长）
 */
public class LeaseMsg {
    private int leaseid;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int carid;
    private int userid;
    private double charge;

}
