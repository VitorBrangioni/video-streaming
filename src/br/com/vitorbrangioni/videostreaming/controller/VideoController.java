package br.com.vitorbrangioni.videostreaming.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Video Controller 
 * @author vitorbrangioni
 *
 */
@Controller
public class VideoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);	
	
	@RequestMapping(value = "/encoding", method = RequestMethod.POST)
	public void encoding(HttpSession session, @RequestParam("file") MultipartFile upload) {
	}
	
	@RequestMapping(value = "/encoding", method = RequestMethod.GET)
	public String enconding() {
		return "form";
	}

}
