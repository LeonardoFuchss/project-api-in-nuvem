package me.dio.controller;

import me.dio.model.User;
import me.dio.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {  /* terá uma resposta do tipo usuário e recebe os parâmetros do usuário */
        User userSave = userService.saveUser(user);  /* salva o usuário no db e armazena na variável do tipo usuário */
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()  /* criando um objeto URI e instânciando um Servlet components builder com base na url da requisição */
                .path("/{id}")  /* Adicionando um identificador no caminho da URI */
                .buildAndExpand(userSave.getId())  /* Atribuindo o id do usuário salvo nesse identificador da URI */
                .toUri(); /* Convertendo o resultado em um objeto URI */
        return ResponseEntity.created(location).body(userSave);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){ /* terá uma resposta do tipo lista de usuários */
        List<User> getAll = userService.getAllUser(); /* chama o método buscar todos */
        return ResponseEntity.ok(getAll); /* retorna uma resposta ok com os usuários buscados */
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) { /* Resposta do tipo usuário que recebe um id no caminho da url da requisição */
        User userFind = userService.getById(id); /* busca o usuário com base no id e armazena na variável */
        return ResponseEntity.ok(userFind); /* retorna esse usuário com resposta ok */
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) { /* Resposta do tipo usuário que recebe um id no caminho da url da requisição */
        userService.deleteUserById(id); /* busca o usuário com base no id  */
        return (ResponseEntity<?>) ResponseEntity.ok();  /* retorna resposta ok */
    }
}
