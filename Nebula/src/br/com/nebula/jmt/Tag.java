package br.com.nebula.jmt;

import java.io.File;
import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.*;

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

		if (tag.isEmpty())
			return null;

		MP3File mp3 = new MP3File(f);
		AbstractID3v2 tags = mp3.getID3v2Tag();
		AbstractID3v2Frame frame = tags.getFrame(tag);

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

	public static boolean writeTag(File f, String tag, String value) throws IOException, TagException {
		tag = translate(tag);

		if (tag.isEmpty())
			return false;

		MP3File mp3 = new MP3File(f);
		AbstractID3v2 tags = mp3.getID3v2Tag();

		switch (tag) {
		case ("TIT2"):
			value = new String(value.getBytes("UTF16"));
			tags.setSongTitle(value);
			return true;
		case ("TPE1"):
			value = new String(value.getBytes("UTF16"));
			tags.setLeadArtist(value);
			return true;
		case ("TALB"):
			value = new String(value.getBytes("UTF16"));
			tags.setAlbumTitle(value);
			return true;
		case ("TYER"):
			value = new String(value.getBytes("UTF16"));
			tags.setYearReleased(value);
			return true;
		case ("COMM"):
			value = new String(value.getBytes("UTF16"));
			tags.setSongComment(value);
			return true;
		case ("TCON"):
			value = new String(value.getBytes("UTF16"));
			tags.setSongGenre(value);
			return true;
		case ("TRCK"):
			value = new String(value.getBytes("UTF16"));
			tags.setTrackNumberOnAlbum(value);
			return true;
		case ("TCOM"):
			value = new String(value.getBytes("UTF16"));
			tags.setAuthorComposer(value);
			return true;
		default:
			return false;
		}
	}
	// public static ?? readAllTags(File f)
	// public static boolean writeTagsRequest(File f)

}
