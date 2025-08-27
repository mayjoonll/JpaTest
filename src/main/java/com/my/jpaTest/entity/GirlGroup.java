package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GirlGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String g_id;
    private String g_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "e_id")
    private Entertainment entertainment;

    @OneToMany(mappedBy = "girlGroup",
            fetch = FetchType.EAGER,
            cascade = { CascadeType.REMOVE, CascadeType.PERSIST})
    private List<IdolMember> idolMembers = new ArrayList<>();

    public void addMember(IdolMember member) {
        idolMembers.add(member);
        member.setGirlGroup(this);
    }
}
