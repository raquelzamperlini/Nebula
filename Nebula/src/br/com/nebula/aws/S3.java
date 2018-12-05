package br.com.nebula.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
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
import java.net.URL;
import java.util.List;

public class S3 {
	public static void createFolder(String path, String folderName) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);

		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest putObjectRequest;
		if (folderName.isEmpty()) {
			putObjectRequest = new PutObjectRequest("nebulas3",
					String.format("usuarios/%s/", path), emptyContent, metadata);
		}else {
			putObjectRequest = new PutObjectRequest("nebulas3",
					String.format("usuarios/%s/%s/", path, folderName), emptyContent, metadata);			
		}

		s3.putObject(putObjectRequest);
	}

	public static boolean uploadFile(String path, InputStream f, String fileName) {

		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
		ObjectMetadata om = new ObjectMetadata();
		om.setContentType("binary/octet-stream");
		//om.setContentLength(fileSize);
		
		try {
			s3.putObject("nebulas3", String.format("usuarios/%s/%s", path, fileName), f, om);
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
			return false;
		}
		return true;
	}

	public static List<S3ObjectSummary> listFiles(String path) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
		ObjectListing ol = s3.listObjects(new ListObjectsRequest()
		        .withBucketName("nebulas3")
		        .withPrefix(String.format("usuarios/%s/", path)));
		
		List<S3ObjectSummary> objects = ol.getObjectSummaries();

		return objects;
	}
	
	public static URL download(String filePath) throws IOException {

        try {            
        	final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-west-2").build();
    
            // Set the presigned URL to expire after one hour.
            java.util.Date expiration = new java.util.Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 60 * 60;
            expiration.setTime(expTimeMillis);

            // Generate the presigned URL.
            GeneratePresignedUrlRequest generatePresignedUrlRequest = 
                    new GeneratePresignedUrlRequest("nebulas3", filePath)
                    .withMethod(HttpMethod.GET)
                    .withExpiration(expiration);
            URL url = s3.generatePresignedUrl(generatePresignedUrlRequest);
    
            return url;
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
            return null;
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
            return null;
        }
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

	public static void copyFile(String filePath, String newPath) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion("us-west-2") 
                .build();
		try {
		    s3.copyObject("nebulas3", filePath, "nebulas3", String.format("usuarios/%s", newPath));
		} catch (AmazonServiceException e) {
		    System.err.println(e.getErrorMessage());
		    System.exit(1);
		}
	}
	
	public static void deleteFile(String filePath, String fileName) {
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion("us-west-2") 
                .build();
		try {
		    s3.deleteObject("nebulas3", String.format("usuarios/%s/%s", filePath, fileName));
		} catch (AmazonServiceException e) {
		    System.err.println(e.getErrorMessage());
		    System.exit(1);
		}
	}
	
	
}
