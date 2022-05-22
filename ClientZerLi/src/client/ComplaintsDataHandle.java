package client;

import java.util.List;

import entities_reports.Complaint;


public class ComplaintsDataHandle {
private static  Complaint complaint;
private static List<Complaint>comlaints;

public static List<Complaint> getComlaints() {
	return comlaints;
}

public static void setComlaints(List<Complaint> comlaints) {
	ComplaintsDataHandle.comlaints = comlaints;
}

public static Complaint getComplaint() {
	return complaint;
}

public static void setComplaint(Complaint complaint) {
	ComplaintsDataHandle.complaint = complaint;
}

}
