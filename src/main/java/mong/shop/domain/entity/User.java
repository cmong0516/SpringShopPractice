package mong.shop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;
import mong.shop.Auditing.BaseTimeEntity;
import mong.shop.domain.dto.request.MemberForm;

@Entity
@NoArgsConstructor
@Table(name = "USERS")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String email;

    @Builder
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public static User memberFormToUserEntity(MemberForm form) {
        return User.builder().name(form.getName())
                .password(form.getPassword())
                .email(form.getEmail()).build();
    }
}
