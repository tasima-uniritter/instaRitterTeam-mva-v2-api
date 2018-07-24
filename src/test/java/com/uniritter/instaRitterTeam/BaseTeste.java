package com.uniritter.instaRitterTeam;

import javax.transaction.Transactional;

import org.springframework.test.context.TestPropertySource;

@Transactional
@TestPropertySource("classpath:test.properties")
public class BaseTeste {

}
