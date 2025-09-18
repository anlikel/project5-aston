package classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User implements Comparable<User>{
    private final String name;
    private final int age;
    private final String email;

    @JsonCreator
    public User(@JsonProperty("name") String name,
                @JsonProperty("age") int age,
                @JsonProperty("email") String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    public static class UserBuilder {
        private String name;
        private int age;
        private String email;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, email='%s'}", name, age, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }
    @Override
    public int compareTo(User other) {
        // Natural order: сначала по name, затем по age, затем по email
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) {
            return nameCompare;
        }

        int ageCompare = Integer.compare(this.age, other.age);
        if (ageCompare != 0) {
            return ageCompare;
        }

        return this.email.compareTo(other.email);
    }
}
