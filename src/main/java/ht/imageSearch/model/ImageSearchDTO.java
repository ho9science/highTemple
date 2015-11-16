package ht.imageSearch.model;

public class ImageSearchDTO {
	private String title;
	private String link;
	private String thumbnail;
	
	public ImageSearchDTO() {
		super();
	}
	
	
	public ImageSearchDTO(String title, String link, String thumbnail) {
		super();
		this.title = title;
		this.link = link;
		this.thumbnail = thumbnail;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}
