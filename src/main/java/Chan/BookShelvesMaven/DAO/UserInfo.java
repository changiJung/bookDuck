package Chan.BookShelvesMaven.DAO;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class UserInfo {
    private final String username;
    private final List<GrantedAuthority> authorities;


    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    
    
    private UserInfo (String username, List<GrantedAuthority> authorities) {
        
    	this.enabled = true;
		this.accountNonExpired = true;
		this.credentialsNonExpired = true;
		this.accountNonLocked = true;
		this.username = username;
        this.authorities = authorities;
    }
    
    public static UserInfo create(String username, List<GrantedAuthority> authorities) {
        if (username.equals(null)) throw new IllegalArgumentException("Username is blank: " + username);
        return new UserInfo(username, authorities);
    }

    public String getUsername() {
        return username;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
	
}
