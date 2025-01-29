package com.practice.java.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class RuntimeTest {

    /**
     * [RuntimeTest.basicMethods] - runtime=java.lang.Runtime@61d6015a
     * [RuntimeTest.basicMethods] - version=21.0.6+8-LTS-188
     * [RuntimeTest.basicMethods] - version.version=[21, 0, 6]
     * [RuntimeTest.basicMethods] - version.feature=21
     * [RuntimeTest.basicMethods] - version.interim=0
     * [RuntimeTest.basicMethods] - version.update=6
     * [RuntimeTest.basicMethods] - version.build=Optional[8]
     */
    @Test
    void basicMethods() {
        Runtime runtime = Runtime.getRuntime();
        Runtime.Version version = Runtime.version();

        log.info("runtime={}", runtime);
        log.info("version={}", version);
        log.info("version.version={}", version.version());
        log.info("version.feature={}", version.feature());
        log.info("version.interim={}", version.interim());
        log.info("version.update={}", version.update());
        log.info("version.build={}", version.build());
    }
}
