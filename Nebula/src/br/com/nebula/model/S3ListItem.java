package br.com.nebula.model;

public class S3ListItem {
	
	private String key;
	private String downloadLink;
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
	
	
}
