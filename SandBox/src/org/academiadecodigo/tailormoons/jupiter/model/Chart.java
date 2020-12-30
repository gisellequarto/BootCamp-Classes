package org.academiadecodigo.tailormoons.jupiter.model;

@Entity
@Table
public class Chart {

    @Id
    private int chartId;

    //date

    @ManyToOne
    private User user;

}
