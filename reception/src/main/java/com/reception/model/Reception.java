package com.reception.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Schema(description = "Reception Informacion")
@Data
@Entity
@Table(name = "receptionprueba")
public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Book names")
    @NotNull(message = "Names can not be null.")
    @Size(min = 3, max = 70, message = "Names must have at least 3 characters.")
    @Column(name = "Book names", nullable = false, length = 70)
    private String book_id;

    @Schema(description = "id client")
    @NotNull(message = "id client can not be null.")
    @Size(min = 3, max = 70, message = "id client must have at least 3 characters.")
    @Column(name = "id client", nullable = false, length = 70)
    private String client_id;

    @Schema(description = "reception day")
    @NotNull(message = "reception day can not be null.")
    @Pattern(regexp = "^[0-9]*$", message = "reception day must contain only numeric digits.")
    @Size(min = 8, max = 8, message = "reception day must have 8 digits.")
    @Column(name = "reception day", nullable = false, length = 8, unique = true)
    private String receip_date;

    @Schema(description = "return day")
    @NotNull(message = "return day can not be null.")
    @Size(min = 3, max = 70, message = "return day must have at least 3 characters.")
    @Column(name = "return day", nullable = false, length = 70)
    private String return_date;

}