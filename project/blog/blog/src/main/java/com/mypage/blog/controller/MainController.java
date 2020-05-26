package com.mypage.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
    
    //test.jsp 파일을 페이지에 띄움
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String main() {
        return "test";
    }

    //jsp파일 안받고 test 문자만 페이지에 리턴
    // @RequestMapping(value="/", method=RequestMethod.GET)
    // @ResponseBody String main() {
    //     return "test";
    // }
    // @RequestMapping(value="/sh", method=RequestMethod.GET)
    // @ResponseBody String shmain() {
    //     return "shtest";
    // }
}