package adventure.work.auth.config;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ReviewUserPrincipal implements UserDetails{

	private static final long serialVersionUID = 1L;
	private User userInfo;
	private List<AuthGroup> authGroups; 
	
	public ReviewUserPrincipal(User userInfo, List<AuthGroup> authGroups) {
		super();
		this.userInfo = userInfo;
		this.authGroups= authGroups;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(null == authGroups) {
			return Collections.emptyList();
		}
		Set<SimpleGrantedAuthority> grantAuthorities = new HashSet<>();
		this.authGroups.forEach(authGroup->{
			grantAuthorities.add(new SimpleGrantedAuthority(authGroup.getAuthGroup()));	
		});
		return grantAuthorities;
	}

	@Override
	public String getPassword() {
		return this.userInfo.getPassword();
	}

	@Override
	public String getUsername() {
		return this.userInfo.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
