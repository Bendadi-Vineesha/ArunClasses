package demo.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PassEncoderDemo {

	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String[] pwds = {"demo@123", "admin@123", "manager@123"};

		for(String pwd:pwds) {
			System.out.println(pwd+" : "+encoder.encode(pwd));
		}
	}
	
}
