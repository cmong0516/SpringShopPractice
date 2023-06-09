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
import lombok.Getter;
import lombok.NoArgsConstructor;
import mong.shop.Auditing.BaseTimeEntity;
import mong.shop.domain.dto.request.MemberForm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@NoArgsConstructor
@Getter
public class Member extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonManagedReference
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Member(MemberForm form) {
        this.email = form.getEmail();
        this.name = form.getName();
        this.password = form.getPassword();
        this.role = Role.ROLE_GUEST;
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

