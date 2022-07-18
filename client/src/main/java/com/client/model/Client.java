package com.client.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Schema(description = "Client Informacion")
@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Customer names")
    @NotNull(message = "Names can not be null.")
    @Size(min = 3, max = 70, message = "Names must have at least 3 characters.")
    @Column(name = "names", nullable = false, length = 70)
    private String names;

    @Schema(description = "Customer last names")
    @NotNull(message = "Last name can not be null.")
    @Size(min = 3, max = 70, message = "Last name must have at least 3 characters.")
    @Column(name = "lastnames", nullable = false, length = 70)
    private String lastnames;

    @Schema(description = "Customer DNI")
    @NotNull(message = "DNI can not be null.")
    @Pattern(regexp = "^[0-9]*$", message = "DNI must contain only numeric digits.")
    @Size(min = 8, max = 8, message = "DNI must have 8 digits.")
    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Schema(description = "Customer direction")
    @NotNull(message = "Direction can not be null.")
    @Size(min = 3, max = 70, message = "Direction must have at least 3 characters.")
    @Column(name = "direction", nullable = false, length = 70)
    private String direction;

    @Schema(description = "Customer numberphone")
    @NotNull(message = "Numberphone can not be null.")
    @Size(min = 3, max = 70, message = "Numberphone must have at least 3 characters.")
    @Column(name = "numberphone", nullable = false, length = 70)
    private String numberphone;

    @Schema(description = "Customer email")
    @NotNull(message = "email can not be null.")
    @Size(min = 3, max = 70, message = "Email must have at least 3 characters.")
    @Column(name = "email", nullable = false, length = 70)
    private String email;

}