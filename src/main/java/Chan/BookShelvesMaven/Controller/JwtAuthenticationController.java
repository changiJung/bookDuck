package Chan.BookShelvesMaven.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Chan.BookShelvesMaven.Config.Security.JwtTokenUtil;
import Chan.BookShelvesMaven.Config.Security.JwtUserDetailsService;
import Chan.BookShelvesMaven.DAO.JwtRequest;
import Chan.BookShelvesMaven.DAO.JwtResponse;



@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?>  createAuthenticationTokenPC(@ModelAttribute JwtRequest jwtRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		authenticate(jwtRequest.getUserId(), jwtRequest.getUserPw());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUserId());
		
		final String Authorization = jwtTokenUtil.generateToken(userDetails);
		response.setHeader("Authorization", Authorization);

				
		return ResponseEntity.ok(new JwtResponse(Authorization));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("사용하실 수 없는 아이디 입니다.", e);
		} catch (BadCredentialsException e) {
			throw new Exception("아이디 및 비밀번호가 유효하지 않습니다.", e);
		}
	}
	
}
