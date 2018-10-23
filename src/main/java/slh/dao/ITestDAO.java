package slh.dao;

import org.springframework.stereotype.Component;
import slh.bean.Test;
@Component
public interface ITestDAO {
  Test getByIPName();
}
