package main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class News {
    @Id
    private Long id;
    private String title;
    private String text;
    private LocalDate date;
    private boolean topNews;

}
