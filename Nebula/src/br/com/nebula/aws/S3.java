package br.com.nebula.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class S3 {
	public static void createFolder(String folderName) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);

		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

		PutObjectRequest putObjectRequest = new PutObjectRequest("nebulas3",
				String.format("usuarios/%s/", folderName), emptyContent, metadata);

		s3.putObject(putObjectRequest);
	}

	public static boolean uploadFile(String path, File f) {

		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
		try {
			s3.putObject("nebulas3", String.format("usuarios/%s/%s", path, f.getName()), f);
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
			return false;
		}
		System.out.println("sucesso!");
		return true;
	}

	public static List<S3ObjectSummary> listFiles(String path) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
		ObjectListing ol = s3.listObjects("nebulas3", String.format("usuarios/%s/", path));
		List<S3ObjectSummary> objects = ol.getObjectSummaries();

		return objects;
	}

	public static void downloadFile(String path, String file) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
		try {
			S3Object o = s3.getObject("nebulas3", String.format("usuarios/%s/", path) + file);
			S3ObjectInputStream s3is = o.getObjectContent();
			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Vinicius\\" + file));
			byte[] read_buf = new byte[1024];
			int read_len = 0;
			while ((read_len = s3is.read(read_buf)) > 0) {
				fos.write(read_buf, 0, read_len);
			}
			s3is.close();
			fos.close();
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	public static void downloadFolder(String remotePath, String localPath) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
		System.out.println("Listando arquivos...");
		List<S3ObjectSummary> objects = S3.listFiles(remotePath);
		System.out.println("Arquivos listados!");
		String file;
		for (S3ObjectSummary os : objects) {
			System.out.println("Baixando... " + os.getKey());
			file = os.getKey();

			if (file.substring(file.lastIndexOf("/") + 1).trim().isEmpty()) {
				System.out.println("Arquivo inválido!");
				continue;
			}

			try {
				S3Object o = s3.getObject("nebulas3", file);
				S3ObjectInputStream s3is = o.getObjectContent();
				FileOutputStream fos = new FileOutputStream(
						new File(localPath + file.substring(file.lastIndexOf("/") + 1).trim()));
				byte[] read_buf = new byte[1024];
				int read_len = 0;
				while ((read_len = s3is.read(read_buf)) > 0) {
					fos.write(read_buf, 0, read_len);
				}
				s3is.close();
				fos.close();
			} catch (AmazonServiceException e) {
				System.err.println(e.getErrorMessage());
				System.exit(1);
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			} catch (IOException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}
		}
	}

//	public static void copyFile(String filePath, String newPath) {
//		final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
//                .withRegion("us-west-2") 
//                .build();
//		try {
//		    s3.copyObject(from_bucket, object_key, to_bucket, object_key);
//		} catch (AmazonServiceException e) {
//		    System.err.println(e.getErrorMessage());
//		    System.exit(1);
//		}
//	}
}
