package slh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import slh.bean.Test;
import slh.dao.ITestDAO;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {
  @Autowired
  HttpServletRequest request;
  @Autowired
  private ITestDAO itestDAO;
  @RequestMapping(value = "/test1")
  public void test(){
    Test test = itestDAO.getByIPName();
    System.out.println(getRequest());
    HttpServletRequest r = getRequest();
  }

  public HttpServletRequest getRequest() {
    return request;
  }

  public void setRequest(HttpServletRequest request) {
    this.request = request;
  }
}
