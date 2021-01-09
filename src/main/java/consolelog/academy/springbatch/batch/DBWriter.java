package consolelog.academy.springbatch.batch;

import consolelog.academy.springbatch.model.User;
import consolelog.academy.springbatch.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {
    private UserRepository userRepository;

    @Autowired
    public DBWriter (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void write(List<? extends User> userList) throws Exception {
        userRepository.saveAll(userList);
    }
}
