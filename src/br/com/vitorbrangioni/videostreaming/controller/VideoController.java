package br.com.vitorbrangioni.videostreaming.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.vitorbrangioni.videostraming.AmazonAwsS3;
import br.com.vitorbrangioni.videostraming.HttpRequest;

/**
 * Video Controller
 * 
 * @author vitorbrangioni
 *
 */
@Controller
public class VideoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);
	private static String submittedVideosPath = "/var/www/html/video-streaming/videos/submitted/";
	private static String zencoderApiUrl = "https://app.zencoder.com/api/v2/jobs";
	private static String zencoderApiKey = "%$#@!";

	@RequestMapping(value = "/encoding", method = RequestMethod.POST)
	public void encoding(HttpSession session, @RequestParam("file") MultipartFile upload) {
		
		// 1) upload
		String videoName = this.upload(session, upload);
		
		// 2) sending to Amazon
		AmazonAwsS3 s3 = new AmazonAwsS3();
		s3.uploadSingleObject(submittedVideosPath + videoName, videoName);
		
		// 3) encoding video
		HashMap<String, String> header = new HashMap<>();
		header.put("content-type", "application/json");
		header.put("Zencoder-Api-Key", zencoderApiKey);

		HashMap<String, String> body = new HashMap<>();
		body.put("input", "http://dinamica-sambatech.s3.amazonaws.com/sample.dv");
		
		JSONObject response = HttpRequest.request(zencoderApiUrl, header, body);
		
		System.out.println(response.toString());
	}

	@RequestMapping(value = "/encoding", method = RequestMethod.GET)
	public String enconding() {
		return "form";
	}

	private String upload(HttpSession session, MultipartFile upload) {
		// @TODO: create hash
		String fileName = "video";
		File file = new File(submittedVideosPath + fileName);
		try {
			upload.transferTo(file);
			System.out.println("uploaded: " + file.getAbsolutePath());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return fileName;
	}
}
