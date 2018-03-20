package br.com.vitorbrangioni.videostreaming.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.vitorbrangioni.videostraming.AmazonAwsS3;

/**
 * Video Controller
 * 
 * @author vitorbrangioni
 *
 */
@Controller
public class VideoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);
	private String submittedVideosPath = "/var/www/html/video-streaming/videos/submitted/";

	@RequestMapping(value = "/encoding", method = RequestMethod.POST)
	public void encoding(HttpSession session, @RequestParam("file") MultipartFile upload) {

		String videoName = this.upload(session, upload);

		AmazonAwsS3 s3 = new AmazonAwsS3();
		s3.uploadSingleObject(this.submittedVideosPath + videoName, videoName);
	}

	@RequestMapping(value = "/encoding", method = RequestMethod.GET)
	public String enconding() {
		return "form";
	}

	private String upload(HttpSession session, MultipartFile upload) {
		// @TODO: create hash
		String fileName = "video";
		File file = new File(this.submittedVideosPath + fileName);
		try {
			upload.transferTo(file);
			System.out.println("uploaded: " + file.getAbsolutePath());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return fileName;
	}
}
