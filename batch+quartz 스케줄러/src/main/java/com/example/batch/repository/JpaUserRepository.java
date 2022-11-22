package com.example.batch.repository;

import com.example.batch.entity.UserEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component("JpaUserRepository")
public class JpaUserRepository implements UserRepository{

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public UserEntity save(UserEntity user) {
        em.persist(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        UserEntity user = em.find(UserEntity.class, id);
        em.remove(user);
    }

    @Override
    public void update(UserEntity user) {
        em.createQuery("update users u set u.name= :name where u.id= :id")
                .setParameter("name",user.getName())
                .setParameter("id",user.getId())
                .executeUpdate();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        UserEntity user = em.find(UserEntity.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<UserEntity> findByName(String name) {
        List<UserEntity> result = em.createQuery("select u from users u where u.name= :name", UserEntity.class)
        .setParameter("name", name)
        .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<UserEntity> findAll() {
      List<UserEntity> result = em.createQuery("select u from users u", UserEntity.class)
                .getResultList();
        return result;
    }



}
