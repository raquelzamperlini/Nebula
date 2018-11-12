package br.com.nebula.testes;

import java.io.File;
import java.io.IOException;

import org.farng.mp3.*;
import org.farng.mp3.id3.*;

public class TestJavaMusicTag {

	public static void main(String[] args) throws IOException, TagException {
		// TODO Auto-generated method stub
		
		//pegando o objeto com as tags
		File file = new File("C:\\Users\\Vinicius\\Of Montreal\\(1997) Cherry Peel\\13 At Night Trees Aren't Sleeping.mp3");
		MP3File mp3 = new MP3File(file);
		ID3v1 tag1 = mp3.getID3v1Tag();
		AbstractID3v2 tag2 = mp3.getID3v2Tag();
		
		//mostrando quais tags existem no arquivo e quantos frames de tag ID3v2 est�o no arquivo
		System.out.println("ID3v1: " + mp3.hasID3v1Tag() + " | ID3v2: " + mp3.hasID3v2Tag() + " | Lyrics3: " + mp3.hasLyrics3Tag());
		System.out.println("Frames: " + tag2.getFrameCount());
		
		//pegando o frame
		AbstractID3v2Frame frame = tag2.getFrame("TIT2");
		FrameBodyTIT2 st = (FrameBodyTIT2) frame.getBody();
		
		//extraindo t�tulo da m�sica
		String songTitle = new String(st.getText().getBytes(), "UTF16");
		System.out.println("Song Title: " + songTitle);
		
		//alterando t�tulo da m�sica (no objeto FrameBodyTIT2)
		String newSongTitle = "AlteredTitle";
		newSongTitle = new String(newSongTitle.getBytes("UTF16"));
		st.setText(newSongTitle);
		System.out.println("New Song Title: " + st.getText());
		songTitle = new String(st.getText().getBytes(), "UTF16");
		System.out.println("Song Title: " + songTitle);
		
		tag2.setAlbumTitle(st.getText());
		System.out.println("Album: " + tag2.getAlbumTitle());
		mp3.setID3v2Tag(tag2);
		mp3.save();
		
//		TagOptionSingleton.getInstance().setDefaultSaveMode(TagConstant.MP3_FILE_SAVE_OVERWRITE);
//		ID3v1 tag = new ID3v1();
		
	}

}
