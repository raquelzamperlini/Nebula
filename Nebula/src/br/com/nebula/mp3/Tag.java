package br.com.nebula.mp3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.ID3v23Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

public class Tag {
	private String fileKey;
	private String songTitle;
	private String artistName;
	private String albumTitle;
	private String albumYear;
	private String trackNumber;
	private String trackDuration;
	private String trackQuality;
	private String fileSize;
	
	private static boolean save(Mp3File mp3, File f) throws NotSupportedException, IOException {
		try {
			String oldPath = f.getPath();
			String newPath = f.getPath() + "_new";
			mp3.save(newPath);
			f.delete();
			f = new File(newPath);
			f.renameTo(new File(oldPath));
		}catch (Exception e) {
			return false;
		}
				
		return true;
	}
	
	public String getFileKey() {
		return fileKey;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public static String getSongTitle(File f) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();		
		return v2.getTitle();
	}
	public static boolean setSongTitle(File f, String songTitle) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();	
		v2.setTitle(songTitle);
		return save(mp3, f);
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public static String getArtistName(File f) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();		
		return v2.getArtist();
	}
	public static boolean setArtistName(File f, String artistName) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();	
		v2.setArtist(artistName);
		return save(mp3, f);
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public static String getAlbumTitle(File f) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();		
		return v2.getAlbum();
	}
	public static boolean setAlbumTitle(File f, String albumTitle) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();	
		v2.setAlbum(albumTitle);
		return save(mp3, f);
	}
	public String getAlbumYear() {
		return albumYear;
	}
	public void setAlbumYear(String albumYear) {
		this.albumYear = albumYear;
	}
	public static String getAlbumYear(File f) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();		
		return v2.getYear();
	}
	public static boolean setAlbumYear(File f, String albumYear) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();	
		v2.setYear(albumYear);
		return save(mp3, f);
	}
	public String getTrackNumber() {
		return trackNumber;
	}
	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}
	public static String getTrackNumber(File f) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();		
		return v2.getTrack();
	}
	public static boolean setTrackNumber(File f, String trackNumber) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
		Mp3File mp3 = new Mp3File(f);
		ID3v2 v2 = mp3.getId3v2Tag();	
		v2.setTrack(trackNumber);
		return save(mp3, f);
	}
	public String getTrackDuration() {
		return trackDuration;
	}
	public void setTrackDuration(String trackDuration) {
		this.trackDuration = trackDuration;
	}
	public static String getTrackDuration(File f) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3 = new Mp3File(f);
		long secs = mp3.getLengthInMilliseconds();	
		SimpleDateFormat df = new SimpleDateFormat("mm:ss");
		String trackDuration = df.format(secs);
		return trackDuration;
	}
	public String getTrackQuality() {
		return trackQuality;
	}
	public void setTrackQuality(String trackQuality) {
		this.trackQuality = trackQuality;
	}
	private static String getTrackQuality(File f) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3 = new Mp3File(f);
		return mp3.getBitrate() + "kbps";
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public Tag() {
		super();
	}
	public Tag(String fileKey, String songTitle, String artistName, String albumTitle, String albumYear,
			String trackNumber, String trackDuration, String trackQuality, String fileSize) {
		super();
		this.fileKey = fileKey;
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.albumTitle = albumTitle;
		this.albumYear = albumYear;
		this.trackNumber = trackNumber;
		this.trackDuration = trackDuration;
		this.trackQuality = trackQuality;
		this.fileSize = fileSize;
	}
	public Tag(File f, HashMap<String, String> tags) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
		//construtor que monta um objeto Tag a partir de um arquivo File, reconstruindo o arquivo no padrão da aplicação
		super();
		Mp3File mp3 = new Mp3File(f);
		ID3v1 v1;
		ID3v2 v2;
		if(mp3.hasId3v1Tag()) {
			mp3.removeId3v1Tag();
		}
		
		if(mp3.hasId3v2Tag()) {
			mp3.removeId3v2Tag();
		}
		v2 = new ID3v23Tag();
		v2.setAlbum(tags.get("album"));
		v2.setArtist(tags.get("artist"));
		v2.setTitle(tags.get("title"));
		v2.setTrack(tags.get("track"));
		v2.setYear(tags.get("year"));
		mp3.setId3v2Tag(v2);
		
		this.setAlbumTitle(tags.get("album"));
		this.setAlbumYear(tags.get("year"));
		this.setArtistName(tags.get("artist"));
		this.setFileKey("");
		this.setFileSize(String.format("%.2f MB", f.length() / (Math.pow(1024.0, 2.0))));
		this.setSongTitle(tags.get("title"));
		this.setTrackDuration(Tag.getTrackDuration(f));
		this.setTrackNumber(tags.get("track"));
		this.setTrackQuality(mp3.getBitrate() + "kbps");
		
		String oldPath = f.getPath();
		String newPath = f.getPath() + "_new";
		mp3.save(newPath);
		f.delete();
		f = new File(newPath);
		f.renameTo(new File(oldPath));		
	}

	public Tag getTag(File f) throws UnsupportedTagException, InvalidDataException, IOException{
		//método que retorna um objeto Tag a partir de um arquivo File, sem alterar o arquivo
		Tag t = new Tag();
		t.setAlbumTitle(Tag.getAlbumTitle(f));
		t.setAlbumYear(Tag.getAlbumYear(f));
		t.setArtistName(Tag.getArtistName(f));
		t.setFileKey("");
		t.setFileSize(String.format("%.2f MB", f.length() / (Math.pow(1024.0, 2.0))));
		t.setSongTitle(Tag.getSongTitle(f));
		t.setTrackNumber(Tag.getTrackNumber(f));
		t.setTrackQuality(Tag.getTrackQuality(f));
		
		return t;
	}

	@Override
	public String toString() {
		return "Tag [fileKey=" + fileKey + ", songTitle=" + songTitle + ", artistName=" + artistName + ", albumTitle="
				+ albumTitle + ", albumYear=" + albumYear + ", trackNumber=" + trackNumber + ", trackDuration="
				+ trackDuration + ", trackQuality=" + trackQuality + ", fileSize=" + fileSize + "]";
	}

	
	
}
