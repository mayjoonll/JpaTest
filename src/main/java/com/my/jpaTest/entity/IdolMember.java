package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdolMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String m_id;
    private String m_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "g_id")
    private GirlGroup girlGroup;
}
