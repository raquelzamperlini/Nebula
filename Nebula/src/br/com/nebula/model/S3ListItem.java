package br.com.nebula.model;

public class S3ListItem {
	
	private String key;
	private String keyLong;
	private String downloadLink;
	private String title;
	private String artist;
	private String album;
	private String year;
	private String number;
	private String duration;
	private String size;
	
	private boolean isDirectory;
	
	public S3ListItem() {
		super();
	}
	
	public S3ListItem(String key, String downloadLink, boolean isDirectory) {
		super();
		this.key = key;
		this.downloadLink = downloadLink;
		this.isDirectory = isDirectory;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKeyLong() {
		return keyLong;
	}
	public void setKeyLong(String keyLong) {
		this.keyLong = keyLong;
	}
	
	public String getDownloadLink() {
		return downloadLink;
	}
	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
	public boolean isDirectory() {
		return isDirectory;
	}
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
