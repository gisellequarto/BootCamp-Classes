package org.academiadecodigo.tailormoons.jupiter.model;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
//@NaturalIdCache
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {

    @Id
    @GeneratedValue
    private int userId;

    private String name;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "charts",
            fetch = FetchType.EAGER
    )
    private List<Chart> charts = new ArrayList<>();




}
