package br.com.tecsegapi.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;





public class UploadAWSS3 {
	
	private String bucket;
	private AWSPropertie awsPropertie;
	
	public UploadAWSS3(String tipo) {
		awsPropertie = new AWSPropertie();
		if (tipo.equalsIgnoreCase("local")) {
				bucket = awsPropertie.getBucketLocal();
		}
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
	
	public boolean uploadFile(MultipartFile file, String pasta) {
		String keyName ="";
		if (pasta.length()>0) {
			keyName = pasta + "/" + file.getName();
		}else {
			keyName = file.getName();
		}
		try {

			BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsPropertie.getAccesskey(),
					awsPropertie.getSecretaccesskey());
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(awsPropertie.getClientRegion())
					.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
			TransferManager tm = TransferManagerBuilder.standard().withS3Client(s3Client).build();
			Upload upload = tm.upload(bucket, keyName, convertFile(file));
			upload.waitForCompletion();
			return true;
		} catch (AmazonServiceException e) {
			  
		} catch (SdkClientException e) {
			  
		} catch (AmazonClientException e) {

			  
		} catch (InterruptedException e) {

			  
		}
		return false;

	}
	
	public List<S3ObjectSummary> list() {
	
	List<S3ObjectSummary> lista = new ArrayList<S3ObjectSummary>();
    
    try {    
    	BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsPropertie.getAccesskey(), awsPropertie.getSecretaccesskey());
    	AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
    			 				.withRegion(awsPropertie.getClientRegion())
    	                       .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                       .build();

        ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(bucket).withMaxKeys(2);
        ListObjectsV2Result result;

        do {
            result = s3Client.listObjectsV2(req);

            for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
                lista.add(objectSummary);
            }
            String token = result.getNextContinuationToken();
            req.setContinuationToken(token);
        } while (result.isTruncated());
    }
    catch(AmazonServiceException e) {
          
    }
    catch(SdkClientException e) {
          
    }
    return lista;
}
	
	public boolean delete(S3ObjectSummary objectSummary) {
		if (objectSummary!=null) {
			try {
				BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsPropertie.getAccesskey(), awsPropertie.getSecretaccesskey());
	        	AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	        			 				.withRegion(awsPropertie.getClientRegion())
	        	                       .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	        	                       .build();

	            s3Client.deleteObject(new DeleteObjectRequest(bucket,objectSummary.getKey()));
	            return true;
	        }
	        catch(AmazonServiceException e) {
	              
	        }
			catch(SdkClientException e) {
	              
	        }
		}
		return false;
		
	}
	
	public File convertFile(MultipartFile multi) {
		File file = new File(multi.getOriginalFilename());
		try {
			multi.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	
		

}
