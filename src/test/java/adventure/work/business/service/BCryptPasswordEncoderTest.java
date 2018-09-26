package adventure.work.business.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
		System.out.println(bCryptPasswordEncoder.encode("adventure"));
		System.out.println(bCryptPasswordEncoder.encode("olcay"));

	}
}
