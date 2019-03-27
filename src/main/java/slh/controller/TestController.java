package slh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import slh.bean.Test;
import slh.dao.ITestDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trade")
public class TestController {
  @Autowired
  HttpServletRequest request;
  @Autowired
  private ITestDAO itestDAO;
  @RequestMapping(value = "/test")
  public List test(HttpServletRequest request, HttpServletResponse response){
    List test = itestDAO.getByIPName();
    System.out.println(getRequest());

    return test;
  }

  public HttpServletRequest getRequest() {
    return request;
  }

  public void setRequest(HttpServletRequest request) {
    this.request = request;
  }
}
