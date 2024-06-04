package it.marconi.spring_filmografia.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmForm {
    
    private String title;
    private String genre;
    private int year;
    private int rating;
}
