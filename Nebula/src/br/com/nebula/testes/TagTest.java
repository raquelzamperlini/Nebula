package br.com.nebula.testes;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "NebulaFiles")
public class TagTest {
	private String fileKey;
	private String songTitle;
	private String artistName;
	private String albumTitle;
	private String albumYear;
	private String trackNumber;
	private String trackDuration;
	private String trackQuality;
	private String fileSize;
	private String fileName;
	
	@DynamoDBHashKey
	public String getFileKey() {
		return fileKey;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	@DynamoDBAttribute
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	@DynamoDBAttribute
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	@DynamoDBAttribute
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	@DynamoDBAttribute
	public String getAlbumYear() {
		return albumYear;
	}
	public void setAlbumYear(String albumYear) {
		this.albumYear = albumYear;
	}
	@DynamoDBAttribute
	public String getTrackNumber() {
		return trackNumber;
	}
	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}
	@DynamoDBAttribute
	public String getTrackDuration() {
		return trackDuration;
	}
	public void setTrackDuration(String trackDuration) {
		this.trackDuration = trackDuration;
	}
	@DynamoDBAttribute
	public String getTrackQuality() {
		return trackQuality;
	}
	public void setTrackQuality(String trackQuality) {
		this.trackQuality = trackQuality;
	}
	@DynamoDBAttribute
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	@DynamoDBAttribute
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
		
}
