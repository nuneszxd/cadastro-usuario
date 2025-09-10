package com.nunesz.cadastro_usuario.business;

import com.nunesz.cadastro_usuario.infrastructure.entitys.User;
import com.nunesz.cadastro_usuario.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user){

        if (repository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado!");
        }
        repository.saveAndFlush(user);
    }

    public User buscarUserPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void deletUserEmail(String email){
        repository.deleteByEmail(email);
    }

    public void updateUserEmail(String email, User user){
        User userEntity = buscarUserPorEmail(email);
        User userAtualizado = User.builder()
                .email(email)
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();
        repository.saveAndFlush(userAtualizado);
    }

}
