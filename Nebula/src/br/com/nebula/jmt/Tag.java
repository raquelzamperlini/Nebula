package br.com.nebula.jmt;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.HashMap;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.*;
import org.farng.mp3.lyrics3.*;

public class Tag {

	public static String translate(String tag) {
		switch (tag) {
		case ("track_title"):
			return "TIT2";
		case ("artist_name"):
			return "TPE1";
		case ("album_name"):
			return "TALB";
		case ("year"):
			return "TYER";
		case ("comments"):
			return "COMM";
		case ("genre"):
			return "TCON";
		case ("track_num"):
			return "TRCK";
		case ("composer"):
			return "TCOM";
		default:
			return null;
		}
	}
	
	

	public static String readTag(File f, String tag) throws IOException, TagException {
		tag = translate(tag);
		System.out.println("Translated to: " + tag);

		if (tag.isEmpty())
			return null;

		MP3File mp3 = new MP3File(f);
		AbstractID3v2 tags = mp3.getID3v2Tag();
		AbstractID3v2Frame frame;
		AbstractID3v2FrameBody frameBody;
		
		if (mp3.hasID3v2Tag()) {
			frame = tags.getFrame(tag);
		} else {
			
		    frameBody = new FrameBodyTALB((byte) 0, "albumTitle");
		    frame = new ID3v2_4Frame(frameBody);
		}
		
		switch (tag) {
		case ("TIT2"):
			FrameBodyTIT2 tit2 = (FrameBodyTIT2) frame.getBody();
			return new String(tit2.getText().getBytes(), "UTF16");
		case ("TPE1"):
			FrameBodyTPE1 tpe1 = (FrameBodyTPE1) frame.getBody();
			return new String(tpe1.getText().getBytes(), "UTF16");
		case ("TALB"):
			FrameBodyTALB talb = (FrameBodyTALB) frame.getBody();
			return new String(talb.getText().getBytes(), "UTF16");
		case ("TYER"):
			FrameBodyTYER tyer = (FrameBodyTYER) frame.getBody();
			return new String(tyer.getText().getBytes(), "UTF16");
		case ("COMM"):
			FrameBodyCOMM comm = (FrameBodyCOMM) frame.getBody();
			return new String(comm.getText().getBytes(), "UTF16");
		case ("TCON"):
			FrameBodyTCON tcon = (FrameBodyTCON) frame.getBody();
			return new String(tcon.getText().getBytes(), "UTF16");
		case ("TRCK"):
			FrameBodyTRCK trck = (FrameBodyTRCK) frame.getBody();
			return new String(trck.getText().getBytes(), "UTF16");
		case ("TCOM"):
			FrameBodyTCOM tcom = (FrameBodyTCOM) frame.getBody();
			return new String(tcom.getText().getBytes(), "UTF16");
		default:
			return null;
		}
	}

	public static File writeTag(File f, String tag, String value) throws IOException, TagException {
		tag = translate(tag);
		System.out.println("Translated to: " + tag);
		if (tag.isEmpty())
			return null;

		MP3File mp3 = new MP3File(f);
		AbstractID3v2 fileTags = mp3.getID3v2Tag();

		switch (tag) {
		case ("TIT2"):
			value = new String(value.getBytes("UTF16"));
			fileTags.setSongTitle(value);
			break;
		case ("TPE1"):
			value = new String(value.getBytes("UTF16"));
			fileTags.setLeadArtist(value);
			break;
		case ("TALB"):
			value = new String(value.getBytes("UTF16"));
			System.out.println("Write: " + value);
			fileTags.setAlbumTitle(value);
			break;
		case ("TYER"):
			value = new String(value.getBytes("UTF16"));
			fileTags.setYearReleased(value);
			break;
		case ("COMM"):
			value = new String(value.getBytes("UTF16"));
			fileTags.setSongComment(value);
			break;
		case ("TCON"):
			value = new String(value.getBytes("UTF16"));
			fileTags.setSongGenre(value);
			break;
		case ("TRCK"):
			value = new String(value.getBytes("UTF16"));
			fileTags.setTrackNumberOnAlbum(value);
			break;
		case ("TCOM"):
			value = new String(value.getBytes("UTF16"));
			fileTags.setAuthorComposer(value);
			break;
		default:
			return null;
		}
		
		mp3.save();
		
		return mp3.getMp3file();
	}
	
	public static void fileInfo(File f) throws IOException, TagException {
		MP3File mp3 = new MP3File(f);
		RandomAccessFile ram = new RandomAccessFile(f, "r");
		AbstractID3v2 tags = mp3.getID3v2Tag();
		AbstractID3v2Frame frame = tags.getFrame("TALB");
		FrameBodyTALB frameBody = (FrameBodyTALB) frame.getBody();
		//Long enc = (Long) frameBody.getTextEncoding();
		System.out.println(frameBody.getTextEncoding());
		
		try{
			ID3v1 tag1 = new ID3v1(ram);
	    	System.out.println("ID2v1: " + tag1.toString());
	    } catch (Exception e){
	    	System.out.println("ID3v1 not found!");
	    }
		try{
			ID3v1_1 tag2 = new ID3v1_1(ram);
	    	System.out.println("ID2v1_1: " + tag2.toString());
	    } catch (Exception e){
	    	System.out.println("ID3v1_1 not found!");
	    }
	    try{
	    	ID3v2_2 tag3 = new ID3v2_2(ram);
	    	System.out.println("ID2v2_2: " + tag3.toString());
	    } catch (Exception e){
	    	System.out.println("ID3v2_2 not found!");
	    }
	    try{
	    	ID3v2_3 tag4 = new ID3v2_3(ram);
	    	System.out.println("ID2v2_3: " + tag4.toString());
	    } catch (Exception e){
	    	System.out.println("ID3v2_3 not found!");
	    }
	    try{
	    	ID3v2_4 tag5 = new ID3v2_4(ram);
	    	System.out.println("ID2v2_4: " + tag5.toString());
	    } catch (Exception e){
	    	System.out.println("ID3v2_4 not found!");
	    }
	    try{
	    	Lyrics3v1 tag6 = new Lyrics3v1(ram);
	    	System.out.println("Lyrics3v1: " + tag6.toString());
	    } catch (Exception e){
	    	System.out.println("Lyrics3v1 not found!");
	    }
	    try{
	    	Lyrics3v2 tag7 = new Lyrics3v2(ram);
	    	System.out.println("Lyrics3v2: " + tag7.toString());
	    } catch (Exception e){
	    	System.out.println("Lyrics3v2 not found!");
	    }
	    
	    
	}
	// public static ?? readAllTags(File f)
	// public static boolean writeTagsRequest(File f)

}
