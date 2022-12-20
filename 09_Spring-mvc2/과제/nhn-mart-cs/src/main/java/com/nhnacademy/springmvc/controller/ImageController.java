package com.nhnacademy.springmvc.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;

@Controller
public class ImageController {

    @ResponseBody
    @GetMapping(value = "/image", params = "filename")
    public Resource displayImage(@RequestParam("filename") String fileName) throws MalformedURLException {
        return new UrlResource("file:" + fileName);
    }

}
