package mong.shop.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mong.shop.Auditing.BaseTimeEntity;
import mong.shop.domain.dto.request.MemberForm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@NoArgsConstructor
@Table(name = "USERS")
@Getter
public class User extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = Role.ROLE_USER;
    }

    public static User memberFormToUserEntity(MemberForm form) {
        return User.builder().name(form.getName())
                .password(form.getPassword())
                .email(form.getEmail()).build();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return role.name();
            }
        });
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
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
