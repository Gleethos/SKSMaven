package main.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_blogposts")
@NamedQuery(name = "BlogPost.findAll", query = "SELECT p FROM t_blogposts p")
public class BlogPost {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false, name = "authorid")
    private Author author;

    @ManyToOne
    @JoinColumn(nullable = false, name = "landmarkid")
    private Landmark landmark;

    @OneToMany
    private List<Invocation> invocations;

}
