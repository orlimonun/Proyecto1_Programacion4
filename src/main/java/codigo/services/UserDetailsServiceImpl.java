package codigo.services;

import codigo.models.SecurityUsuario;
import codigo.models.Usuario;
import codigo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario user = userRepository.findByCorreo(correo);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new SecurityUsuario(user);
    }

}
