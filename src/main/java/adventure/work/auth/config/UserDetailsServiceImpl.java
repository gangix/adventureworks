package adventure.work.auth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AuthGroupRepository authGroupRepository;
	private final UserInfoRepository userInfoRepository;

	@Autowired
	public UserDetailsServiceImpl(AuthGroupRepository authGroupRepository, UserInfoRepository userInfoRepository) {
		this.authGroupRepository = authGroupRepository;
		this.userInfoRepository = userInfoRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User userInfo = userInfoRepository.findByUsername(userName);
		if (userInfo == null) {
			throw new UsernameNotFoundException("can not find username " + userName);
		}
		List<AuthGroup> authGroups = authGroupRepository.findByUsername(userName);
		
		return new ReviewUserPrincipal(userInfo,authGroups);
	}
}
