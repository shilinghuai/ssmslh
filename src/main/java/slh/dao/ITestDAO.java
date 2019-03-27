package slh.dao;

import org.springframework.stereotype.Component;
import slh.bean.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public interface ITestDAO {
  List<Map<String, Object>> getByIPName();
}
