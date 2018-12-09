package br.com.nebula.jmt;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagConstant;
import org.farng.mp3.TagException;
import org.farng.mp3.TagOptionSingleton;
import org.farng.mp3.id3.*;
import org.farng.mp3.lyrics3.*;

public class Tag {
	//INFO
//	  textEncodingIdToString.put(new Long(0), "ISO-8859-1");
//    textEncodingIdToString.put(new Long(1), "UTF-16");
//    textEncodingIdToString.put(new Long(2), "UTF-16BE");
//    textEncodingIdToString.put(new Long(3), "UTF-8");
    //
	
	public String encoding(int num) {
		
		switch(num) {
		case 0:
			return "ISO-8859-1";
		case 1:
			return "UTF-16";
		case 2:
			return "UTF-16BE";
		case 3:
			return "UTF-8";
		default: return "";
		}
	}
	
	private String fileKey;
	private String songTitle;
	private String artistName;
	private String albumTitle;
	private String albumYear;
	private String trackNumber;
	private String trackDuration;
	private String trackQuality;
	private String fileSize;
	public String getFileKey() {
		return fileKey;
	}
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public String getSongTitle(RandomAccessFile ram, MP3File mp3) {
		String st = "";
		int encNumber;
		String enc = "";
		while(st.isEmpty()) {
			try {
				if(mp3.hasLyrics3Tag()) {
					AbstractLyrics3 alt = mp3.getLyrics3Tag();
					if (!alt.getSongTitle().isEmpty()){
						return alt.getSongTitle();
					}
				}	
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v2Tag()) {
					AbstractID3v2 ai2 = mp3.getID3v2Tag();
					if (!ai2.getSongTitle().isEmpty()){
						AbstractID3v2Frame ai2Frame = ai2.getFrame("TIT2");
						FrameBodyTIT2 ai2FrameBody = (FrameBodyTIT2) ai2Frame.getBody();
						encNumber = ai2FrameBody.getTextEncoding().intValue();
						enc = encoding(encNumber);
						st = new String(ai2.getSongTitle().getBytes(),enc);
						st = st.substring(0, st.length() - 1) + ai2.getSongTitle().substring(ai2.getSongTitle().length() - 1, ai2.getSongTitle().length());
						return st;
					}
				}
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v1Tag()) {
					AbstractID3v1 ai1 = mp3.getID3v1Tag();
					if (!ai1.getSongTitle().isEmpty()){
						return ai1.getSongTitle();
					}
				}			
			}catch(Exception e) {
				
			}
		}
		return null;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getArtistName() {
		return artistName;
	}
	public String getArtistName(RandomAccessFile ram, MP3File mp3) {
		String st = "";
		int encNumber;
		String enc = "";
		while(st.isEmpty()) {
			try {
				if(mp3.hasLyrics3Tag()) {
					AbstractLyrics3 alt = mp3.getLyrics3Tag();
					if (!alt.getLeadArtist().isEmpty()){
						return alt.getLeadArtist();
					}
				}
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v2Tag()) {
					AbstractID3v2 ai2 = mp3.getID3v2Tag();
					if (!ai2.getLeadArtist().isEmpty()){
						AbstractID3v2Frame ai2Frame = ai2.getFrame("TPE1");
						FrameBodyTPE1 ai2FrameBody = (FrameBodyTPE1) ai2Frame.getBody();
						encNumber = ai2FrameBody.getTextEncoding().intValue();
						enc = encoding(encNumber);
						st = new String(ai2.getLeadArtist().getBytes(),enc);
						st = st.substring(0, st.length() - 1) + ai2.getLeadArtist().substring(ai2.getLeadArtist().length() - 1, ai2.getLeadArtist().length());
						return st;
					}
				}
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v1Tag()) {
					AbstractID3v1 ai1 = mp3.getID3v1Tag();
					if (!ai1.getLeadArtist().isEmpty()){
						return ai1.getLeadArtist();
					}
				}
			}catch(Exception e) {
				
			}
		}
		return null;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAlbumTitle() {
		return albumTitle;
	}
	public String getAlbumTitle(RandomAccessFile ram, MP3File mp3) {
		String st = "";
		int encNumber;
		String enc = "";
		while(st.isEmpty()) {
			try {
				if(mp3.hasLyrics3Tag()) {
					AbstractLyrics3 alt = mp3.getLyrics3Tag();
					if (!alt.getAlbumTitle().isEmpty()){
						return alt.getAlbumTitle();
					}
				}
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v2Tag()) {
					AbstractID3v2 ai2 = mp3.getID3v2Tag();
					if (!ai2.getAlbumTitle().isEmpty()){
						AbstractID3v2Frame ai2Frame = ai2.getFrame("TALB");
						FrameBodyTALB ai2FrameBody = (FrameBodyTALB) ai2Frame.getBody();
						encNumber = ai2FrameBody.getTextEncoding().intValue();
						enc = encoding(encNumber);
						st = new String(ai2.getAlbumTitle().getBytes(),enc);
						st = st.substring(0, st.length() - 1) + ai2.getAlbumTitle().substring(ai2.getAlbumTitle().length() - 1, ai2.getAlbumTitle().length());
						return st;
					}
				}
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v1Tag()) {
					AbstractID3v1 ai1 = mp3.getID3v1Tag();
					if (!ai1.getAlbumTitle().isEmpty()){
						return ai1.getAlbumTitle();
					}
				}
			}catch(Exception e) {
				
			}
		}
		return null;
	}
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public String getAlbumYear() {
		return albumYear;
	}
	public String getAlbumYear(RandomAccessFile ram, MP3File mp3) {
		String st = "";
		int encNumber;
		String enc = "";
		while(st.isEmpty()) {
			try {
				if(mp3.hasLyrics3Tag()) {
					AbstractLyrics3 alt = mp3.getLyrics3Tag();
					if (!alt.getYearReleased().isEmpty()){
						return alt.getYearReleased();
					}
				}				
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v2Tag()) {
					AbstractID3v2 ai2 = mp3.getID3v2Tag();
					if (!ai2.getYearReleased().isEmpty()){
						AbstractID3v2Frame ai2Frame = ai2.getFrame("TYER");
						FrameBodyTYER ai2FrameBody = (FrameBodyTYER) ai2Frame.getBody();
						encNumber = ai2FrameBody.getTextEncoding().intValue();
						enc = encoding(encNumber);
						st = new String(ai2.getYearReleased().getBytes(),enc);
						st = st.substring(0, st.length() - 1) + ai2.getYearReleased().substring(ai2.getYearReleased().length() - 1, ai2.getYearReleased().length());
						return st;
					}
				}
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v1Tag()) {
					AbstractID3v1 ai1 = mp3.getID3v1Tag();
					if (!ai1.getYearReleased().isEmpty()){
						return ai1.getYearReleased();
					}
				}
			}catch(Exception e) {
				
			}			
		}
		return null;
	}
	public void setAlbumYear(String albumYear) {
		this.albumYear = albumYear;
	}
	public String getTrackNumber() {
		return trackNumber;
	}
	public String getTrackNumber(RandomAccessFile ram, MP3File mp3) {
		String st = "";
		int encNumber;
		String enc = "";
		while(st.isEmpty()) {
			try {
				if(mp3.hasLyrics3Tag()) {
					AbstractLyrics3 alt = mp3.getLyrics3Tag();
					if (!alt.getTrackNumberOnAlbum().isEmpty()){
						return alt.getTrackNumberOnAlbum();
					}
				}
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v2Tag()) {
					AbstractID3v2 ai2 = mp3.getID3v2Tag();
					if (!ai2.getTrackNumberOnAlbum().isEmpty()){
						AbstractID3v2Frame ai2Frame = ai2.getFrame("TRCK");
						FrameBodyTRCK ai2FrameBody = (FrameBodyTRCK) ai2Frame.getBody();
						encNumber = ai2FrameBody.getTextEncoding().intValue();
						enc = encoding(encNumber);
						st = new String(ai2.getTrackNumberOnAlbum().getBytes(),enc);
						st = st.substring(0, st.length() - 1) + ai2.getTrackNumberOnAlbum().substring(ai2.getTrackNumberOnAlbum().length() - 1, ai2.getTrackNumberOnAlbum().length());
						return st;
					}
				}
			}catch(Exception e) {
				
			}
			try {
				if(mp3.hasID3v1Tag()) {
					AbstractID3v1 ai1 = mp3.getID3v1Tag();
					if (!ai1.getTrackNumberOnAlbum().isEmpty()){
						return ai1.getTrackNumberOnAlbum();
					}
				}
			}catch(Exception e) {
				
			}
		}
		return null;
	}
	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}
	public String getTrackDuration() {
		return trackDuration;
	}
	public void setTrackDuration(String trackDuration) {
		this.trackDuration = trackDuration;
	}
	public String getTrackQuality() {
		return trackQuality;
	}
	public void setTrackQuality(String trackQuality) {
		this.trackQuality = trackQuality;
	}
	public String getFileSize() {
		return fileSize;
	}
	public String getFileSize(File mp3) {
		return String.valueOf(mp3.length());
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	public Tag() {
		
	}
	
	public Tag(File f) throws IOException, TagException {
		this.buildTagObject(f, this);
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
	
	public void buildTagObject(File f, Tag t) throws IOException, TagException {
		//////////////
		//preparando//
		//////////////
		
		//declarando classes para trabalhar com as tags
		MP3File mp3 = new MP3File(f);
		RandomAccessFile ram = new RandomAccessFile(f, "rw");
	    TagOptionSingleton.getInstance().setDefaultSaveMode(TagConstant.MP3_FILE_SAVE_OVERWRITE);
		
	    HashMap<String, String> tags = readTags(f);
	    
		//declarando dados
		//String fileKey; //Never used
		String songTitle = tags.get("song_title");
		String artistName = tags.get("artist_name");
		String albumTitle = tags.get("album_title");
		String albumYear = tags.get("album_year");
		String trackNumber = tags.get("track_number");
		//String trackDuration; //Never used
		//String trackQuality = String.valueOf(mp3.getBitRate()); //Never used
		//String fileSize; //Never used
		
		//pega tags v1
		ID3v1 	tagv1_0 = null;
		ID3v1_1 tagv1_1 = null;
		ID3v2_2 tagv2_2 = null;
		ID3v2_3 tagv2_3 = null;
		ID3v2_4 tagv2_4 = null;
		Lyrics3v1 tagL1 = null;
		Lyrics3v2 tagL2 = null;
		
		try{
	    	tagv1_0 = new ID3v1(ram);
	    }catch (Exception e) {
	    	
	    }
	    
	    try {
	    	tagv1_1 = new ID3v1_1(ram);
	    }catch (Exception e) {
	    	
	    }
	    
	    //pega tags v2
	    try {
	    	tagv2_2 = new ID3v2_2(ram);
	    }catch (Exception e) {
	    	
	    }
	    
	    try {
	    	tagv2_3 = new ID3v2_3(ram);
	    }catch (Exception e) {
	    	
	    }
	    
	    try {
	    	tagv2_4 = new ID3v2_4(ram);
	    }catch (Exception e) {
	    	
	    }	       
	    
	    //pega tags de letra
	    try {
	    	tagL1 = new Lyrics3v1(ram);
	    }catch (Exception e) {
	    	
	    }
	    
	    try {
	    	tagL2 = new Lyrics3v2(ram);
	    }catch (Exception e) {
	    	
	    }
	    
	    //deleta todas as tags para reconstruir no padr�o da aplica��o
	    if(tagv1_0 != null) {
	    	tagv1_0.delete(ram);
	    }
	    
	    if(tagv1_1 != null) {
	    	tagv1_1.delete(ram);
	    }
	    
	    if(tagv2_2 != null) {
	    	tagv2_2.delete(ram);
	    }
	    
	    if(tagv2_3 != null) {
	    	tagv2_3.delete(ram);
	    }
	    
	    if(tagv2_4 != null) {
	    	tagv2_4.delete(ram);
	    }
	    
	    if(tagL1 != null) {
	    	tagL1.delete(ram);
	    }
	    
	    if(tagL2 != null) {
	    	tagL2.delete(ram);
	    }
	    
	    ////////////////////
	    //construindo tags//
	    ////////////////////
	    
	    //GLOSSARIO:
	    //TIT2 = T�tulo da m�sica
	    //TPE1 = Artista
	    //TALB = T�tulo do �lbum
	    //TDRC = Ano
	    //TRCK = N�mero da faixa
	    
	    
	    //declarando as frames das novas tags
	    AbstractID3v2 id3v2 = mp3.getID3v2Tag();
	    AbstractID3v2Frame frameTIT2; 
	    AbstractID3v2FrameBody frameBodyTIT2;	//frame de t�tulo da m�sica
	    AbstractID3v2Frame frameTPE1;
	    AbstractID3v2FrameBody frameBodyTPE1;	//frame de artista
	    AbstractID3v2Frame frameTALB;
	    AbstractID3v2FrameBody frameBodyTALB;	//frame de �lbum
	    AbstractID3v2Frame frameTYER;
	    AbstractID3v2FrameBody frameBodyTYER;	//frame de ano
	    AbstractID3v2Frame frameTRCK;
	    AbstractID3v2FrameBody frameBodyTRCK;	//frame de n�mero da faixa
	    
	    //atribuindo valores (em teste)
	    frameBodyTIT2 = new FrameBodyTIT2((byte) 0, songTitle);
	    frameBodyTPE1 = new FrameBodyTPE1((byte) 0, artistName);
	    frameBodyTALB = new FrameBodyTALB((byte) 0, albumTitle);
	    frameBodyTYER = new FrameBodyTYER((byte) 0, albumYear);
	    frameBodyTRCK = new FrameBodyTRCK((byte) 0, trackNumber);
	    
	    //jogando as novas tags nos frames
	    frameTIT2 = new ID3v2_4Frame(frameBodyTIT2);
	    frameTPE1 = new ID3v2_4Frame(frameBodyTPE1);
	    frameTALB = new ID3v2_4Frame(frameBodyTALB);
	    //frameTYER = new ID3v2_3Frame(frameBodyTYER); // Comentado por erro apontado pela IDE; corrigido abaixo
	    frameTYER = new ID3v2_4Frame(frameBodyTYER);
	    frameTRCK = new ID3v2_4Frame(frameBodyTRCK);
	    
	    id3v2.setFrame(frameTIT2);
	    id3v2.setFrame(frameTPE1);
	    id3v2.setFrame(frameTALB);
	    id3v2.setFrame(frameTYER);
	    id3v2.setFrame(frameTRCK);
	    
	    ////////////
		//Salvando//
	    ////////////
	    
		//atribuindo dados ao objeto
//		t.setFileKey(fileKey);
//		t.setSongTitle(songTitle);
//		t.setArtistName(artistName);
//		t.setAlbumTitle(albumTitle);
//		t.setAlbumYear(albumYear);
//		t.setTrackNumber(trackNumber);
//		t.setTrackDuration(trackDuration);
//		t.setTrackQuality(trackQuality);
//		t.setFileSize(fileSize);
	    
	    mp3.save();
	}
	
	public HashMap<String, String> readTags(File f) throws IOException, TagException {
		HashMap<String, String> tags = new HashMap<String, String>();
		
		//declarando classes para trabalhar com as tags
		MP3File mp3 = new MP3File(f);
		RandomAccessFile ram = new RandomAccessFile(f, "rw");
	    TagOptionSingleton.getInstance().setDefaultSaveMode(TagConstant.MP3_FILE_SAVE_OVERWRITE);
		
		//declarando dados
		//String fileKey = getFileKey(ram);
		String songTitle = getSongTitle(ram, mp3);
		tags.put("song_title", songTitle);
		String artistName = getArtistName(ram, mp3);
		tags.put("artist_name", artistName);
		String albumTitle = getAlbumTitle(ram, mp3);
		tags.put("album_title", albumTitle);
		String albumYear = getAlbumYear(ram, mp3);
		tags.put("album_year", albumYear);
		String trackNumber = getTrackNumber(ram, mp3);
		tags.put("track_number", trackNumber);
		//String trackDuration = getTrackDuration(ram);
		String trackQuality = String.valueOf(mp3.getBitRate());
		tags.put("bit_rate", trackQuality);
		String fileSize = getFileSize(f);
		tags.put("file_size", fileSize);
		
		//pega tags v1
		/*  //Never used
		 * ID3v1 	tagv1_0 = null;
		 * ID3v1_1 tagv1_1 = null;
		 * ID3v2_2 tagv2_2 = null;
		 * ID3v2_3 tagv2_3 = null;
		 * ID3v2_4 tagv2_4 = null;
		 * Lyrics3v1 tagL1 = null;
		 * Lyrics3v2 tagL2 = null;
		 */
		
		//return tags;
		return tags;
	}
	
	
}
