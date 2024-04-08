package com.example.servicejoueur.dto;

import com.example.servicejoueur.enums.JoueurRole;

public record RegisterDTO(String first_name, String last_name, String email, String password, String pseudo, String biographie, JoueurRole joueurRole) {
}
