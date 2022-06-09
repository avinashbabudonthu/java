package com.cerebro.batch;

@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Component
public class UserWriter implements org.springframework.batch.item.ItemWriter<com.cerebro.model.UserEntity> {

    @org.springframework.beans.factory.annotation.Autowired
    private com.cerebro.repository.UserRepository userRepository;

    @Override
    public void write(java.util.List<? extends com.cerebro.model.UserEntity> list) throws Exception {
        log.info("users={}", list);
        userRepository.saveAll(list);
    }
}
