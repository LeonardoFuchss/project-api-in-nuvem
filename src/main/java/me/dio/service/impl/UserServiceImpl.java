package me.dio.service.impl;

import me.dio.exception.GlobalExceptionHandler;
import me.dio.model.News;
import me.dio.model.User;
import me.dio.repositories.UserRepository;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) { /* se id for diferente de nulo e id existir no db */
            throw new IllegalArgumentException("User already exist");
        } else if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException(new Exception("User already exist")); /* se numero da conta já for existente no db */
        } else {
            return userRepository.save(user); /* caso contrário, salva um novo usuário */
        }
    }

    @Override
    public List<User> getAllUser() { /* retorna uma lista de usuário */
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) { /* recebe um id no parâmetro e faz a busca no db */
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new); /* Caso não for encontrado, lança a exceção */
    }

    @Override
    public void updateUser(Integer id, User user) { /* recebe o id do usuário a ser atualizado e recebe novos valores dos atributos */
        Optional<User> userFind = userRepository.findById(id);
        if (userFind.isPresent()) { /* se o usuário buscado existir */
            userRepository.save(user); /* atualiza seus dados */
        } else {
            throw new RuntimeException("User not find"); /* caso contrário, usuário não encontrado. */
        }
    }

    @Override
    public void deleteUserById(Integer id) { /* procura o usuário pelo seu id recebido no parâmetro */
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id); /* se o usuário existir, é deletado do db */
        } else {
            throw new RuntimeException("User not find"); /* caso contrário, usuário não encontrado */
        }
    }
}
