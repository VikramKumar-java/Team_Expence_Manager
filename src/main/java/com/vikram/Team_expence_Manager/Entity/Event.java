package com.vikram.Team_expence_Manager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String location;

    @ManyToMany(mappedBy = "events")
    private Set<User> members = new HashSet<>();
    @OneToMany(
            mappedBy = "event",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Expense> expenses = new HashSet<>();

}
