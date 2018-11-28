package br.com.nebula.testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.farng.mp3.TagException;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.ID3v23Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

import br.com.nebula.controller.DiretorioCTRL;
import br.com.nebula.mp3.Tag;

public class TestMP3agic {
	
	public static void leitura() throws UnsupportedTagException, InvalidDataException, IOException {
		File file;
		Mp3File mp3;
		ID3v1 v1;
		ID3v2 v2;
		long secs;
		SimpleDateFormat df;
		
		file = new File("C:\\Users\\Vinicius\\Documents\\neb\\albuns_teste\\_teste\\01 - Woman In Love.mp3");
		mp3 = new Mp3File(file);
		System.out.println("C:\\\\Users\\\\Vinicius\\\\Documents\\\\neb\\\\albuns_teste\\\\_teste\\\\01 - Woman In Love.mp3");
		System.out.println("Bitrate: " + mp3.getBitrate() + "kbps");
		secs = mp3.getLengthInMilliseconds();	
		df = new SimpleDateFormat("mm:ss");
		System.out.println("Length (s): " + df.format(secs));
		
		if(mp3.hasId3v1Tag()) {
			v1 = mp3.getId3v1Tag();
			System.out.println("(v1) Album: " + v1.getAlbum());
			System.out.println("(v1) Artist: " + v1.getArtist());
			System.out.println("(v1) Title: " + v1.getTitle());
			System.out.println("(v1) Track: " + v1.getTrack());
			System.out.println("(v1) Year: " + v1.getYear());
		}
		
		if(mp3.hasId3v2Tag()) {
			v2 = mp3.getId3v2Tag();
			System.out.println("(v2) Album: " + v2.getAlbum());
			System.out.println("(v2) Album Artist: " + v2.getAlbumArtist());
			System.out.println("(v2) Artist: " + v2.getArtist());
			System.out.println("(v2) Title: " + v2.getTitle());
			System.out.println("(v2) Track: " + v2.getTrack());
			System.out.println("(v2) Year: " + v2.getYear());
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("");
		
		file = new File("C:\\Users\\Vinicius\\Documents\\neb\\albuns_teste\\_teste\\02 - Rough Stuff.mp3");
		mp3 = new Mp3File(file);
		System.out.println("C:\\\\Users\\\\Vinicius\\\\Documents\\\\neb\\\\albuns_teste\\\\_teste\\\\02 - Rough Stuff.mp3");
		System.out.println("Bitrate: " + mp3.getBitrate() + "kbps");
		secs = mp3.getLengthInMilliseconds();	
		df = new SimpleDateFormat("mm:ss");
		System.out.println("Length (s): " + df.format(secs));
		
		if(mp3.hasId3v1Tag()) {
			v1 = mp3.getId3v1Tag();
			System.out.println("(v1) Album: " + v1.getAlbum());
			System.out.println("(v1) Artist: " + v1.getArtist());
			System.out.println("(v1) Title: " + v1.getTitle());
			System.out.println("(v1) Track: " + v1.getTrack());
			System.out.println("(v1) Year: " + v1.getYear());
		}
		
		if(mp3.hasId3v2Tag()) {
			v2 = mp3.getId3v2Tag();
			System.out.println("(v2) Album: " + v2.getAlbum());
			System.out.println("(v2) Album Artist: " + v2.getAlbumArtist());
			System.out.println("(v2) Artist: " + v2.getArtist());
			System.out.println("(v2) Title: " + v2.getTitle());
			System.out.println("(v2) Track: " + v2.getTrack());
			System.out.println("(v2) Year: " + v2.getYear());
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("");
		
		file = new File("C:\\Users\\Vinicius\\Documents\\neb\\albuns_teste\\_teste\\03 - Dot The I.mp3");
		mp3 = new Mp3File(file);
		System.out.println("C:\\\\Users\\\\Vinicius\\\\Documents\\\\neb\\\\albuns_teste\\\\_teste\\\\03 - Dot The I.mp3");
		System.out.println("Bitrate: " + mp3.getBitrate() + "kbps");
		secs = mp3.getLengthInMilliseconds();	
		df = new SimpleDateFormat("mm:ss");
		System.out.println("Length (s): " + df.format(secs));
		
		if(mp3.hasId3v1Tag()) {
			v1 = mp3.getId3v1Tag();
			System.out.println("(v1) Album: " + v1.getAlbum());
			System.out.println("(v1) Artist: " + v1.getArtist());
			System.out.println("(v1) Title: " + v1.getTitle());
			System.out.println("(v1) Track: " + v1.getTrack());
			System.out.println("(v1) Year: " + v1.getYear());
		}
		
		if(mp3.hasId3v2Tag()) {
			v2 = mp3.getId3v2Tag();
			System.out.println("(v2) Album: " + v2.getAlbum());
			System.out.println("(v2) Album Artist: " + v2.getAlbumArtist());
			System.out.println("(v2) Artist: " + v2.getArtist());
			System.out.println("(v2) Title: " + v2.getTitle());
			System.out.println("(v2) Track: " + v2.getTrack());
			System.out.println("(v2) Year: " + v2.getYear());
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("");
		
		file = new File("C:\\Users\\Vinicius\\Documents\\neb\\albuns_teste\\_teste\\04 - Yvonne Gets Dumped.mp3");
		mp3 = new Mp3File(file);
		System.out.println("C:\\\\Users\\\\Vinicius\\\\Documents\\\\neb\\\\albuns_teste\\\\_teste\\\\04 - Yvonne Gets Dumped.mp3");
		System.out.println("Bitrate: " + mp3.getBitrate() + "kbps");
		secs = mp3.getLengthInMilliseconds();	
		df = new SimpleDateFormat("mm:ss");
		System.out.println("Length (s): " + df.format(secs));
		
		if(mp3.hasId3v1Tag()) {
			v1 = mp3.getId3v1Tag();
			System.out.println("(v1) Album: " + v1.getAlbum());
			System.out.println("(v1) Artist: " + v1.getArtist());
			System.out.println("(v1) Title: " + v1.getTitle());
			System.out.println("(v1) Track: " + v1.getTrack());
			System.out.println("(v1) Year: " + v1.getYear());
		}
		
		if(mp3.hasId3v2Tag()) {
			v2 = mp3.getId3v2Tag();
			System.out.println("(v2) Album: " + v2.getAlbum());
			System.out.println("(v2) Album Artist: " + v2.getAlbumArtist());
			System.out.println("(v2) Artist: " + v2.getArtist());
			System.out.println("(v2) Title: " + v2.getTitle());
			System.out.println("(v2) Track: " + v2.getTrack());
			System.out.println("(v2) Year: " + v2.getYear());
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("");
		
		file = new File("C:\\Users\\Vinicius\\Documents\\neb\\albuns_teste\\_teste\\05 - All The Planes That Come In On The Quiet.mp3");
		mp3 = new Mp3File(file);
		System.out.println("C:\\\\Users\\\\Vinicius\\\\Documents\\\\neb\\\\albuns_teste\\\\_teste\\\\05 - All The Planes That Come In On The Quiet.mp3");
		System.out.println("Bitrate: " + mp3.getBitrate() + "kbps");
		secs = mp3.getLengthInMilliseconds();	
		df = new SimpleDateFormat("mm:ss");
		System.out.println("Length (s): " + df.format(secs));
		System.out.println(String.format("Size: %.2f MB", file.length() / (Math.pow(1024.0, 2.0))));
		
		if(mp3.hasId3v1Tag()) {
			v1 = mp3.getId3v1Tag();
			System.out.println("(v1) Album: " + v1.getAlbum());
			System.out.println("(v1) Artist: " + v1.getArtist());
			System.out.println("(v1) Title: " + v1.getTitle());
			System.out.println("(v1) Track: " + v1.getTrack());
			System.out.println("(v1) Year: " + v1.getYear());
		}
		
		if(mp3.hasId3v2Tag()) {
			v2 = mp3.getId3v2Tag();
			System.out.println("(v2) Album: " + v2.getAlbum());
			System.out.println("(v2) Album Artist: " + v2.getAlbumArtist());
			System.out.println("(v2) Artist: " + v2.getArtist());
			System.out.println("(v2) Title: " + v2.getTitle());
			System.out.println("(v2) Track: " + v2.getTrack());
			System.out.println("(v2) Year: " + v2.getYear());
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("");		

	}
	
	public static void escrita(File f, HashMap<String, String> tags) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
		Mp3File mp3 = new Mp3File(f);
		ID3v1 v1;
		ID3v2 v2;
		if(mp3.hasId3v1Tag()) {
			v1 = mp3.getId3v1Tag();
			v1.setAlbum(tags.get("album"));
			v1.setArtist(tags.get("artist"));
			v1.setTitle(tags.get("title"));
			v1.setTrack(tags.get("track"));
			v1.setYear(tags.get("year"));
		}
		
		if(mp3.hasId3v2Tag()) {
			v2 = mp3.getId3v2Tag();
			v2.setAlbum(tags.get("album"));
			v2.setArtist(tags.get("artist"));
			v2.setTitle(tags.get("title"));
			v2.setTrack(tags.get("track"));
			v2.setYear(tags.get("year"));
		}
		mp3.save("C:\\\\Users\\\\Vinicius\\\\Documents\\\\neb\\\\albuns_teste\\\\_teste\\\\06 - Fugitive.mp3");
	}
	
	public static void escritaRemove(File f, HashMap<String, String> tags) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
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
		
		String oldPath = f.getPath();
		String newPath = f.getPath() + "_new";
		mp3.save(newPath);
		f.delete();
		f = new File(newPath);
		f.renameTo(new File(oldPath));
	}

	public static void main(String[] args) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException, TagException {
		// TODO Auto-generated method stub
		File file;
		file = new File("C:\\Users\\Vinicius\\Documents\\neb\\albuns_teste\\_teste\\05 - All The Planes That Come In On The Quiet.mp3");
		HashMap<String, String> tags = new HashMap<String, String>();
		tags.put("key","jsilveira/a-ha");
		tags.put("artist", "Bridges");
		tags.put("album", "Vakenatt");
		tags.put("title", "All The Planes That Come In On The Quiet");
		tags.put("track", "5");
		tags.put("year", "2018");
		Tag t = new Tag(file, tags);
		System.out.println(t.toString());
		
		//escritaRemove(file, tags);		
		
//		DiretorioCTRL dir = new DiretorioCTRL();
//		File file;
//		file = new File("C:\\Users\\Vinicius\\Documents\\neb\\albuns_teste\\American Music Club\\1987 - Engine\\05 - Nightwatchman.mp3");
//		String userName = "jsilveira/American Music Club";
//		String keyName = "05 - Nightwatchman.mp3";		
//		InputStream is = new FileInputStream(file);
//		
//		dir.upload(userName, is, keyName);
//		System.out.println("Pronto");
	}

}
