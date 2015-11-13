package ht.content.model;

public class ContentDTO {

	/**시 이름*/
	private String govNm;
	/**카테고리*/
	private String ctgryNm;
	/**일련번호*/
	private int seqNum;
	/**이미지*/
	private String img;
	/**제목*/
	private String subject;
	/**주소 (도로명)*/
	private String addr;
	/**문의처 (없을 수 있음*/
	private String contact;
	/**홈페이지*/
	private String homepage;
	/**여행 정보*/
	private String tourInfm; 
	/**이용요금*/
	private String usefulCharge;
	/**주자장 이용 정보*/
	private String carparkUsefullGuide;
	/**코스 정보*/
	private String courseInfm;
	/**주변 정보*/
	private String surroundingsAttraction;
	/**이용 가이드*/
	private String usefullGuide;
	/**개장일*/
	private String runDe;
	/**운영 시간*/
	private String operTime;
	/**개장기간*/
	private String runPd;
	/**교통안내*/
	private String trafficGuide;
	/**등산로*/
	private String mountiontrail;
	/**등록일*/
	private String regDt;
	/**수정일*/
	private String edtDt;
	
	public ContentDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContentDTO(String govNm, String ctgryNm, int seqNum, String img, String subject, String addr, String contact,
			String homepage, String tourInfm, String usefulCharge, String carparkUsefullGuide, String courseInfm,
			String surroundingsAttraction, String usefullGuide, String runDe, String operTime, String runPd,
			String trafficGuide, String mountiontrail, String regDt, String edtDt) {
		super();
		this.govNm = govNm;
		this.ctgryNm = ctgryNm;
		this.seqNum = seqNum;
		this.img = img;
		this.subject = subject;
		this.addr = addr;
		this.contact = contact;
		this.homepage = homepage;
		this.tourInfm = tourInfm;
		this.usefulCharge = usefulCharge;
		this.carparkUsefullGuide = carparkUsefullGuide;
		this.courseInfm = courseInfm;
		this.surroundingsAttraction = surroundingsAttraction;
		this.usefullGuide = usefullGuide;
		this.runDe = runDe;
		this.operTime = operTime;
		this.runPd = runPd;
		this.trafficGuide = trafficGuide;
		this.mountiontrail = mountiontrail;
		this.regDt = regDt;
		this.edtDt = edtDt;
	}

	public String getGovNm() {
		return govNm;
	}

	public void setGovNm(String govNm) {
		this.govNm = govNm;
	}

	public String getCtgryNm() {
		return ctgryNm;
	}

	public void setCtgryNm(String ctgryNm) {
		this.ctgryNm = ctgryNm;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getTourInfm() {
		return tourInfm;
	}

	public void setTourInfm(String tourInfm) {
		this.tourInfm = tourInfm;
	}

	public String getUsefulCharge() {
		return usefulCharge;
	}

	public void setUsefulCharge(String usefulCharge) {
		this.usefulCharge = usefulCharge;
	}

	public String getCarparkUsefullGuide() {
		return carparkUsefullGuide;
	}

	public void setCarparkUsefullGuide(String carparkUsefullGuide) {
		this.carparkUsefullGuide = carparkUsefullGuide;
	}

	public String getCourseInfm() {
		return courseInfm;
	}

	public void setCourseInfm(String courseInfm) {
		this.courseInfm = courseInfm;
	}

	public String getSurroundingsAttraction() {
		return surroundingsAttraction;
	}

	public void setSurroundingsAttraction(String surroundingsAttraction) {
		this.surroundingsAttraction = surroundingsAttraction;
	}

	public String getUsefullGuide() {
		return usefullGuide;
	}

	public void setUsefullGuide(String usefullGuide) {
		this.usefullGuide = usefullGuide;
	}

	public String getRunDe() {
		return runDe;
	}

	public void setRunDe(String runDe) {
		this.runDe = runDe;
	}

	public String getOperTime() {
		return operTime;
	}

	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}

	public String getRunPd() {
		return runPd;
	}

	public void setRunPd(String runPd) {
		this.runPd = runPd;
	}

	public String getTrafficGuide() {
		return trafficGuide;
	}

	public void setTrafficGuide(String trafficGuide) {
		this.trafficGuide = trafficGuide;
	}

	public String getMountiontrail() {
		return mountiontrail;
	}

	public void setMountiontrail(String mountiontrail) {
		this.mountiontrail = mountiontrail;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getEdtDt() {
		return edtDt;
	}

	public void setEdtDt(String edtDt) {
		this.edtDt = edtDt;
	}
	
	
	
}
