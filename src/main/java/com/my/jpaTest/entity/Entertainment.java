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
public class Entertainment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String e_id;
    private String e_name;
    @OneToMany(mappedBy = "entertainment",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST})
    @Builder.Default
    private List<GirlGroup> girlGroups = new ArrayList<>();

    public void addGirlGroup(GirlGroup group) {
        girlGroups.add(group);
        group.setEntertainment(this);
    }
}
