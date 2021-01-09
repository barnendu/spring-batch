package consolelog.academy.springbatch.batch;

import consolelog.academy.springbatch.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {
    private final Map<String, String> DEPT = new HashMap<>();

    public Processor() {
        DEPT.put("001","Engineering");
        DEPT.put("002","Finance");
        DEPT.put("003", "Operation");
    }

    @Override
    public User process(User user) throws Exception {
        String dept = DEPT.get(user.getDepertment());
        user.setDepertment(dept);
        return user;
    }
}
