package entities_reports;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;

import enums.ReportDuration;
import enums.ReportType;

/**
 * @author Dvir Bublil
 */
public class Report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reportID;
	private ReportType reportType;
	private String branchID;
	private String reportCreator;
	private ReportDuration reportDuration;
	private LocalDate reportDate;
	private byte[] blob;

	public Report(String reportID, ReportType reportType, String branchID, String reportCreator,
			ReportDuration reportDuration, byte[] blob, LocalDate reportDate) {
		super();
		this.reportID = reportID;
		this.reportType = reportType;
		this.branchID = branchID;
		this.reportCreator = reportCreator;
		this.reportDuration = reportDuration;
		this.blob = blob;
		this.reportDate=reportDate;

	}

	

	public String getReportID() {
		return reportID;
	}

	public void setReportID(String reportID) {
		this.reportID = reportID;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getReportCreator() {
		return reportCreator;
	}

	public void setReportCreator(String reportCreator) {
		this.reportCreator = reportCreator;
	}

	public ReportDuration getReportDuration() {
		return reportDuration;
	}

	public void setReportDuration(ReportDuration reportDuration) {
		this.reportDuration = reportDuration;
	}

	public byte[] getBlob() {
		return blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	@Override
	public String toString() {
		return "Report [reportID=" + reportID + ", reportType=" + reportType + ", branchID=" + branchID
				+ ", reportCreator=" + reportCreator + ", reportDuration=" + reportDuration + ", reportDate="
				+ reportDate + ", blob=" + blob + "]";
	}
}
