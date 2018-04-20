package kae.hello.spring.core.hometask.service.inmemory;

import kae.hello.spring.core.hometask.domain.User;
import kae.hello.spring.core.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryUserService implements UserService {

    private final List<User> users;
    private final Map<String, User> emailIndex;

    public InMemoryUserService(List<User> users) {
        this.users = users;
        emailIndex = this.users.stream().collect(Collectors.toMap(User::getEmail, user -> user));
    }

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return emailIndex.get(email);
    }

    @Override
    public User save(@Nonnull User object) {
        users.add(object);
        emailIndex.put(object.getEmail(), object);
        return object;
    }

    @Override
    public void remove(@Nonnull User object) {
        users.remove(object);
        emailIndex.remove(object.getEmail());
    }

    @Override
    public User getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return users;
    }
}
